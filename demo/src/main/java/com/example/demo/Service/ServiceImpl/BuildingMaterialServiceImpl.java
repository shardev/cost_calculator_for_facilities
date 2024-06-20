package com.example.demo.Service.ServiceImpl;

import com.example.demo.Model.BuildingMaterial;
import com.example.demo.Model.CarpentryUnit;
import com.example.demo.Model.Floor;
import com.example.demo.Model.WallUnit;
import com.example.demo.Repository.BuildingMaterialRepository;
import com.example.demo.Service.BuildingMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class BuildingMaterialServiceImpl implements BuildingMaterialService {

    @Autowired
    private BuildingMaterialRepository buildingMaterialRepository;

    @Override
    public Collection<BuildingMaterial> findWallUnits(WallUnit wallUnit) {
        Collection<BuildingMaterial> allWallUnitsFromCategory = buildingMaterialRepository.findByProductCategory(wallUnit.getProductCategory());

        Collection<BuildingMaterial> foundWU = new ArrayList<BuildingMaterial>();
        for(var wu: allWallUnitsFromCategory){

            if((wu.getHeight().equals(wallUnit.getHeight())) && (wu.getWidth().equals(wallUnit.getWidth())) && (wu.getLength().equals(wallUnit.getLength()))){
                foundWU.add(wu);
            }
        }
        return foundWU;
    }

    @Override
    public Collection<BuildingMaterial> findCarpentryUnits(Collection<Floor> floor) {
        Collection<CarpentryUnit> allCarpentry = new ArrayList<CarpentryUnit>();

        return null;
    }
}
