package com.example.demo.Controller;


import com.example.demo.Model.BuildingMaterialEstimation;
import com.example.demo.Service.BuildingMaterialEstimationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.security.auth.callback.TextInputCallback;

@RestController
@RequestMapping("/estimations")
public class BuildingMaterialEstimationController {

    @Autowired
    private BuildingMaterialEstimationService buildingMaterialEstimationService;

    @GetMapping("/{buildingId}")
    ModelAndView getEstimationsForBuilding(@PathVariable("buildingId") Integer buildingId){
        ModelAndView modelAndView = new ModelAndView("estimations.html");

        if(buildingMaterialEstimationService.existsForBuilding(buildingId)){
            BuildingMaterialEstimation bme = buildingMaterialEstimationService.findByBuildingId(buildingId);
            modelAndView.addObject("bme", bme);
            return modelAndView;
        }

        BuildingMaterialEstimation bme = buildingMaterialEstimationService.calculateBME(buildingId);
        modelAndView.addObject("bme", bme);
        return modelAndView;
    }
}
