package com.example.demo.Service.ServiceImpl;

import com.example.demo.Model.BuildingOrderer;
import com.example.demo.Repository.BuildingOrdererRepository;
import com.example.demo.Service.BuildingOrdererService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingOrdererServiceImpl implements BuildingOrdererService {

    @Autowired
    private BuildingOrdererRepository buildingOrdererRepository;

    @Override
    public BuildingOrderer findById(Integer buildingOrdererId) {
        return buildingOrdererRepository.findById(buildingOrdererId).orElse(null);
    }
}
