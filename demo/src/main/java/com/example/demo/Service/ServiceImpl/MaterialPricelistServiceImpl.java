package com.example.demo.Service.ServiceImpl;

import com.example.demo.Model.BuildingMaterial;
import com.example.demo.Model.MaterialOrder;
import com.example.demo.Model.MaterialsPriceList;
import com.example.demo.Repository.MaterialPricelistRepository;
import com.example.demo.Service.MaterialPricelistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class MaterialPricelistServiceImpl implements MaterialPricelistService {

    @Autowired
    private MaterialPricelistRepository materialPricelistRepository;

    @Override
    public Collection<MaterialsPriceList> findCompanies(Collection<BuildingMaterial> foundWallUnits) {
        var allPricelists = materialPricelistRepository.findAll();

        Collection<MaterialsPriceList> inCompanies = new ArrayList<MaterialsPriceList>();
        for(var material : foundWallUnits){
            for(var pl: allPricelists){
                if(material.getId() == pl.getBuildingMaterial().getId()){
                    inCompanies.add(pl);
                }
            }

        }
        return inCompanies;
    }

    @Override
    public MaterialsPriceList findById(Integer plId) {
        return materialPricelistRepository.findById(plId).orElse(null);
    }

}
