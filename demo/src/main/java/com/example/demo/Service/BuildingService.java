package com.example.demo.Service;

import com.example.demo.Model.Building;
import com.example.demo.Model.CarpentryUnit;
import com.example.demo.Model.Wall;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface BuildingService {
    Building findById(Integer buildingId);

    Collection<Wall> getWallsForBuilding(Integer buildingId);

    Collection<CarpentryUnit> getCarpentryUnitsForBuilding(Integer buildingId);

    Building save(Building building);

    Collection<Building> findByOwner(Integer ordererId);
}
