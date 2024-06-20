package com.example.demo.Repository;

import com.example.demo.Model.BuildingMaterialEstimation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingMaterialEstimationRepository extends JpaRepository<BuildingMaterialEstimation, Integer> {
    BuildingMaterialEstimation findByBuilding_Id(Integer buildingId);
}
