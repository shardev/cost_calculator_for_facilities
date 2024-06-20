package com.example.demo.Controller;

import com.example.demo.Model.Building;
import com.example.demo.Model.BuildingOrderer;
import com.example.demo.Service.BuildingOrdererService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/buildingOrderers")
public class BuildingOrdererController {

    @Autowired
    private BuildingOrdererService buildingOrdererService;

    @GetMapping(path = "")
    ModelAndView getUserDetails(){
        ModelAndView modelAndView = new ModelAndView("profile.html");
        BuildingOrderer buildingOrderer = buildingOrdererService.findById(1); // spring security
        modelAndView.addObject("buildingOrderer", buildingOrderer);

        return modelAndView;
    }
}
