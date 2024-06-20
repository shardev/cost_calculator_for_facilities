package com.example.demo.Service.ServiceImpl;

import com.example.demo.Model.Wall;
import com.example.demo.Model.WallUnit;
import com.example.demo.Repository.WallRepository;
import com.example.demo.Service.WallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class WallServiceImpl implements WallService {

    @Autowired
    private WallRepository wallRepository;

    @Override
    public WallUnit findWallUnit(Collection<Wall> wallsForBuilding) {
        Wall firstWall = wallsForBuilding.iterator().next();
        return firstWall.getWallUnit();
    }

    @Override
    public Integer countWallElements(Integer wallId) {
        Wall wall = wallRepository.findById(wallId).orElse(null);
        WallUnit wallUnit = wall.getWallUnit();

        Float wallArea = wall.getLength() * wall.getHeight();
        Float wallUnitArea = wallUnit.getLength() * wallUnit.getHeight();

        return Math.round(wallArea/wallUnitArea);
    }
}
