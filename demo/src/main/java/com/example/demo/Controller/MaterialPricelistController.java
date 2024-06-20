package com.example.demo.Controller;

import com.example.demo.Model.Building;
import com.example.demo.Model.BuildingMaterial;
import com.example.demo.Model.MaterialsPriceList;
import com.example.demo.Service.BuildingMaterialService;
import com.example.demo.Service.BuildingService;
import com.example.demo.Service.MaterialPricelistService;
import com.example.demo.Service.WallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/materialPricelist")
public class MaterialPricelistController {

    @Autowired
    private MaterialPricelistService materialPricelistService;

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private BuildingMaterialService buildingMaterialService;

    @GetMapping(path = "/choose")
    ModelAndView getNeededBuildingMaterialsForBuilding() {
        ModelAndView modelAndView = new ModelAndView("houses.html");
        modelAndView.addObject("houses", buildingService.findByOwner(1)); // spring security
        modelAndView.addObject("action", "buy");

        return modelAndView;
    }

    @GetMapping(path = "/{buildingId}")
    ModelAndView getNeededBuildingMaterialsForBuilding(@PathVariable("buildingId") Integer buildingId) {
        Building building =  buildingService.findById(buildingId);
        Collection<MaterialsPriceList> overall = new ArrayList<MaterialsPriceList>();
        ModelAndView modelAndView = new ModelAndView("materials.html");

        // Find wall units that are good
        Collection<BuildingMaterial> foundWallUnits = buildingMaterialService.findWallUnits(building.getFloor().iterator().next().getWalls().iterator().next().getWallUnit());
        // Find companies that sells it and have it enough
        Collection<MaterialsPriceList> companiesWithWU = materialPricelistService.findCompanies(foundWallUnits);
        for(var wu : companiesWithWU){ overall.add(wu); }

        // Find carpentry
        //Collection<BuildingMaterial> foundCarpentry = buildingMaterialService.findCarpentryUnits(building.getFloor());
        // Find companies that sells it and have it enough
        //Collection<MaterialsPriceList> companiesWithCU = materialPricelistService.findCompanies(foundCarpentry);
        //for(var cu : companiesWithCU){ overall.add(cu); }

        // Find cement


        modelAndView.addObject("pricelists", overall);
        modelAndView.addObject("buildingId", buildingId);
        return modelAndView;
    }
}
