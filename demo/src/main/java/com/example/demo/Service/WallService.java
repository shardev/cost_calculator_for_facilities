package com.example.demo.Service;

import com.example.demo.Model.Wall;
import com.example.demo.Model.WallUnit;
import com.example.demo.Model.WallUnitType;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface WallService {
    WallUnit findWallUnit(Collection<Wall> wallsForBuilding);

    Integer countWallElements(Integer id);
}
