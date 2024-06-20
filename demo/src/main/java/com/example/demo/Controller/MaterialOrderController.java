package com.example.demo.Controller;

import com.example.demo.Model.BuildingOrderer;
import com.example.demo.Model.MaterialOrder;
import com.example.demo.Model.MaterialsPriceList;
import com.example.demo.Service.BuildingOrdererService;
import com.example.demo.Service.BuildingService;
import com.example.demo.Service.MaterialOrderService;
import com.example.demo.Service.MaterialPricelistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping("/materialOrders")
public class MaterialOrderController {

    @Autowired
    private BuildingOrdererService buildingOrdererService;

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private MaterialPricelistService materialPricelistService;

    @Autowired
    private MaterialOrderService materialOrderService;

    @RequestMapping(path="", method= RequestMethod.POST)
    ModelAndView addOrderForUser(@RequestParam("plId") Integer plId, @RequestParam("buildingId") Integer buildingId){
        //BuildingOrderer bo = buildingOrdererService.findById(1);
        MaterialOrder materialOrder = new MaterialOrder();
        materialOrder.setMaterialOrderForBuilding(buildingService.findById(buildingId));
        materialOrder.setOrderingDate(new Date());
        Collection<MaterialsPriceList> current = materialOrder.getMaterialsPriceList();
        current.add(materialPricelistService.findById(plId));

        materialOrder.setMaterialsPriceList(current);
        materialOrderService.save(materialOrder);

        ModelAndView modelAndView = new ModelAndView("materialOrders.html");
        modelAndView.addObject("materialOrders", materialOrderService.findForBuilding(buildingId));

        return modelAndView;
    }
}
