package com.example.demo.Service;

import com.example.demo.Model.BuildingMaterial;
import com.example.demo.Model.Floor;
import com.example.demo.Model.WallUnit;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface BuildingMaterialService {
    Collection<BuildingMaterial> findWallUnits(WallUnit wallUnit);

    Collection<BuildingMaterial> findCarpentryUnits(Collection<Floor> floor);
}
