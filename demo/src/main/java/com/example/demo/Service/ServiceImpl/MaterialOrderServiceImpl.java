package com.example.demo.Service.ServiceImpl;

import com.example.demo.Model.MaterialOrder;
import com.example.demo.Repository.MaterialOrderRepository;
import com.example.demo.Service.MaterialOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MaterialOrderServiceImpl implements MaterialOrderService {

    @Autowired
    private MaterialOrderRepository materialOrderRepository;

    @Override
    public void save(MaterialOrder materialOrder) {
        materialOrderRepository.save(materialOrder);
    }

    @Override
    public Collection<MaterialOrder> findForBuilding(Integer buildingId) {
        return materialOrderRepository.findByMaterialOrderForBuilding_Id(buildingId);
    }
}
