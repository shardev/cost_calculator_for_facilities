package com.example.demo.Service;

import com.example.demo.Model.Building;
import com.example.demo.Model.Heating;
import org.springframework.stereotype.Service;

@Service
public interface HeatingService {
    Heating processHeating(Building building);
}
