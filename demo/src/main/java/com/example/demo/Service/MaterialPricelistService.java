package com.example.demo.Service;

import com.example.demo.Model.BuildingMaterial;
import com.example.demo.Model.MaterialOrder;
import com.example.demo.Model.MaterialsPriceList;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface MaterialPricelistService {
    Collection<MaterialsPriceList> findCompanies(Collection<BuildingMaterial> foundWallUnits);

    MaterialsPriceList findById(Integer plId);

}
