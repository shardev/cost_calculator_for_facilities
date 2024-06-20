package com.example.demo.Service;

import com.example.demo.Model.Building;
import com.example.demo.Model.Facade;
import org.springframework.stereotype.Service;

@Service
public interface FacadeService {
    Float calculateFacadeArea(Building building);

    Facade processFacade(Building building);
}
