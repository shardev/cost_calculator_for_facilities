package com.example.demo.Service.ServiceImpl;

import com.example.demo.Model.Building;
import com.example.demo.Model.Facade;
import com.example.demo.Repository.FacadeRepository;
import com.example.demo.Service.FacadeService;
import com.example.demo.Utils.Metrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacadeServiceImpl implements FacadeService {

    @Autowired
    private FacadeRepository facadeRepository;

    @Override
    public Float calculateFacadeArea(Building building) {
        Float facadeArea = 0.0f;

        for(var floor: building.getFloor()){
            for(var wall: floor.getWalls()){
                facadeArea += (wall.getHeight() * wall.getLength())/Metrics.CM2_TO_M2_COEF;
            }
        }

        for(var floor: building.getFloor()){
            for(var cu: floor.getCarpentryUnits()){
                facadeArea -= (cu.getHeight() * cu.getWidth())/Metrics.CM2_TO_M2_COEF;
            }
        }

        return facadeArea;
    }

    @Override
    public Facade processFacade(Building building) {
        Float facadeArea = calculateFacadeArea(building);

        Facade facade = building.getFacade();
        facade.setFacadeNetSurfaceArea(facadeArea);
        facade.setStyrofoamSurfaceArea(facadeArea);
        facade.setFacadeAdhesiveKilos((float) (facadeArea* 0.25));
        facade.setFacadeFinalMassKilos((float) (facadeArea*0.35));

        return facadeRepository.save(facade);
    }
}
