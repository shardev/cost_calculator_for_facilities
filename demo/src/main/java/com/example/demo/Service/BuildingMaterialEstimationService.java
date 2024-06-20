package com.example.demo.Service;

import com.example.demo.Model.BuildingMaterialEstimation;
import org.springframework.stereotype.Service;

@Service
public interface BuildingMaterialEstimationService {
    boolean existsForBuilding(Integer buildingId);

    BuildingMaterialEstimation findByBuildingId(Integer buildingId);

    BuildingMaterialEstimation calculateBME(Integer buildingId);
}
