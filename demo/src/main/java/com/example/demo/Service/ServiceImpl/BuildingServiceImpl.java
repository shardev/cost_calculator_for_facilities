package com.example.demo.Service.ServiceImpl;

import com.example.demo.Model.Building;
import com.example.demo.Model.CarpentryUnit;
import com.example.demo.Model.Wall;
import com.example.demo.Repository.BuildingRepository;
import com.example.demo.Service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    public Building findById(Integer buildingId) {
        return buildingRepository.findById(buildingId).orElse(null);
    }

    @Override
    public Collection<Wall> getWallsForBuilding(Integer buildingId) {
        Building building = findById(buildingId);

        Collection<Wall> wallsForBuilding = new ArrayList<Wall>();
        for (var floor : building.getFloor()) {
            for (var wall : floor.getWalls()) {
                wallsForBuilding.add(wall);
            }
        }

        return wallsForBuilding;
    }

    @Override
    public Collection<CarpentryUnit> getCarpentryUnitsForBuilding(Integer buildingId) {
        Building building = findById(buildingId);

        Collection<CarpentryUnit> carpentryUnitsForBuilding = new ArrayList<CarpentryUnit>();
        for (var floor : building.getFloor()) {
            for (var carpentryUnit : floor.getCarpentryUnits()) {
                carpentryUnitsForBuilding.add(carpentryUnit);
            }
        }

        return carpentryUnitsForBuilding;
    }

    @Override
    public Building save(Building building) {
        return buildingRepository.save(building);
    }

    @Override
    public Collection<Building> findByOwner(Integer ordererId) {
        return buildingRepository.findByBuildingOrderer_Id(ordererId);
    }
}
