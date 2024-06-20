package com.example.demo.Service.ServiceImpl;

import com.example.demo.Model.Building;
import com.example.demo.Model.Heating;
import com.example.demo.Repository.HeatingRepository;
import com.example.demo.Service.HeatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeatingServiceImpl implements HeatingService {

    @Autowired
    private HeatingRepository heatingRepository;

    @Override
    public Heating processHeating(Building building) {
        Heating heating = building.getHeating();

        Integer heatingUnitsCounter = 0;
        Float heatingPipeMeters = 0.0f;
        for (var floor : building.getFloor()) {
            for (var cu : floor.getCarpentryUnits()) {
                heatingUnitsCounter += 1;
            }
            for (var wall : floor.getWalls()) {
                heatingPipeMeters += (wall.getLength())/100;
            }
        }

        heating.setHeatingUnitsCounter(heatingUnitsCounter);
        heating.setHeatingPipeMeters((int) Math.round(1.25 * heatingPipeMeters));

        return heatingRepository.save(heating);
    }
}
