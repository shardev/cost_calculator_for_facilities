package com.example.demo.Service;

import com.example.demo.Model.Building;
import com.example.demo.Model.BuildingOrderer;
import org.springframework.stereotype.Service;

@Service
public interface BuildingOrdererService {
    BuildingOrderer findById(Integer buildingOrdererId);
}
