package com.example.demo.Service;

import com.example.demo.Model.Building;
import com.example.demo.Model.Roof;
import org.springframework.stereotype.Service;

@Service
public interface RoofService {
    Roof processRoof(Building building);
}
