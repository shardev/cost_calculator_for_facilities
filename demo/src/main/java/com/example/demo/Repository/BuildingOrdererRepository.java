package com.example.demo.Repository;

import com.example.demo.Model.BuildingOrderer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingOrdererRepository extends JpaRepository<BuildingOrderer, Integer> {

}
