package com.example.demo.Repository;

import com.example.demo.Model.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Integer> {
    Collection<Building> findByBuildingOrderer_Id(Integer ordererId);
}
