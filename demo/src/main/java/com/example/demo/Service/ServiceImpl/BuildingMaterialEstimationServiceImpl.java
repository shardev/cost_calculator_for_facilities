package com.example.demo.Service.ServiceImpl;

import com.example.demo.Model.*;
import com.example.demo.Repository.BuildingMaterialEstimationRepository;
import com.example.demo.Service.*;
import com.example.demo.Utils.Metrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collection;

@Service
public class BuildingMaterialEstimationServiceImpl implements BuildingMaterialEstimationService {

    @Autowired
    private BuildingMaterialEstimationRepository buildingMaterialEstimationRepository;

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private WallService wallService;

    @Autowired
    private FacadeService facadeService;

    @Autowired
    private HeatingService heatingService;

    @Autowired
    private RoofService roofService;

    @Override
    public boolean existsForBuilding(Integer buildingId) {
        BuildingMaterialEstimation bme = findByBuildingId(buildingId);
        if (bme == null) {
            return false;
        }
        return true;
    }

    @Override
    public BuildingMaterialEstimation findByBuildingId(Integer buildingId) {
        return buildingMaterialEstimationRepository.findByBuilding_Id(buildingId);
    }

    @Override
    public BuildingMaterialEstimation calculateBME(Integer buildingId) {
        Building building = buildingService.findById(buildingId);

        Collection<ConcreteStructure> concreteStructures = new ArrayList<ConcreteStructure>();
        double wallCM = 0.0f;
        double concrete_m3 = 0.0f;
        double gravel_m3 = 0.0f;
        double armature_m2 = 0.0f;
        double hydroisolation_m2 = 0.0f;
        Integer loadBearingCounter = 0;


        // 1) Process walls
        for (var floor : building.getFloor()) {
            for (var wall : floor.getWalls()) {
                wallCM += wall.getLength();
                wall.setWallElementsCounter(wallService.countWallElements(wall.getId()));
                if (wall.getWallUnit().getWallUnitType() == WallUnitType.brick) {
                    // add concrete because of join of bricks
                    concrete_m3 += (wall.wallUnit.getWidth() * wall.getHeight() * wall.getLength() * 0.05) / Metrics.CM3_TO_M3_COEF;
                    if (wall.getLength() >= 600) {
                        // For load bearings
                        loadBearingCounter += 1;
                        concrete_m3 += (Math.pow(wall.wallUnit.getWidth(), 2) * wall.getHeight()) / Metrics.CM3_TO_M3_COEF;
                        armature_m2 += (wall.wallUnit.getWidth() * wall.getHeight()) / Metrics.CM2_TO_M2_COEF;

                        ConcreteStructure loadBearing = new ConcreteStructure();
                        loadBearing.setHeight(wall.getHeight());
                        loadBearing.setLength(wall.wallUnit.getWidth());
                        loadBearing.setWidth(wall.wallUnit.getWidth());
                        loadBearing.setStructureType(ConcreteStructureType.loadBearing);
                        concreteStructures.add(loadBearing);
                    }
                }
            }
        }


        // 2) Process concrete structures
        // 2.2 For floors and load bearings
        for (var floor : building.getFloor()) {
            concrete_m3 += (floor.getSurfaceArea() * 0.15);
            armature_m2 += floor.getSurfaceArea();

            ConcreteStructure floorSlab = new ConcreteStructure();
            floorSlab.setHeight(15.0f);
            floorSlab.setLength((float) Math.sqrt(floor.getSurfaceArea()));
            floorSlab.setWidth((float) Math.sqrt(floor.getSurfaceArea()));

            floorSlab.setStructureType(ConcreteStructureType.slab);
            concreteStructures.add(floorSlab);
        }

        // 2.3 For foundation
        Floor firstFloor = building.getFloor().iterator().next();
        concrete_m3 += (firstFloor.getSurfaceArea() * 0.20);
        armature_m2 += 2 * (firstFloor.getSurfaceArea());
        gravel_m3 += (firstFloor.getSurfaceArea() * 0.40);
        hydroisolation_m2 += (firstFloor.getSurfaceArea());

        ConcreteStructure foundation = new ConcreteStructure();
        foundation.setHeight(20.0f);
        foundation.setLength((float) Math.sqrt(firstFloor.getSurfaceArea()));
        foundation.setWidth((float) Math.sqrt(firstFloor.getSurfaceArea()));

        foundation.setStructureType(ConcreteStructureType.foundation);
        concreteStructures.add(foundation);

        building.setConcreteStructure(concreteStructures);
        // Process carpentry units -- already in building

        // Process facade
        Facade facade = facadeService.processFacade(building);
        building.setFacade(facade);

        // Process heating
        Heating heating = heatingService.processHeating(building);
        building.setHeating(heating);

        // Process roof
        Roof roof = roofService.processRoof(building);
        building.setRoof(roof);

        // Process rooms -- already in building

        buildingService.save(building);

        // Create bme and save, from bme you can access building properties
        BuildingMaterialEstimation bme = new BuildingMaterialEstimation();

        bme.setBuilding(building);
        bme.setArmatureMeters((float) armature_m2);
        bme.setCementKilos((float) (Metrics.CEMENT_IN_M3_OF_CONCRETE * concrete_m3));
        bme.setRockTons((float) ((Metrics.ROCK_IN_M3_OF_CONCRETE * concrete_m3) + gravel_m3) / 1000);
        bme.setSandTons((float) ((Metrics.SAND_IN_M3_OF_CONCRETE * concrete_m3) / 1000));
        bme.setElectricalInstallationCablesMeters((float) (2 * wallCM)/100);
        bme.setWatterPipeMeters((float) (0.5 * wallCM)/100);
        bme.setHydroIsolationMeters2((float) hydroisolation_m2);

        buildingMaterialEstimationRepository.save(bme);
        return bme;
    }
}
