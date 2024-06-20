package com.example.demo.Service;

import com.example.demo.Model.MaterialOrder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface MaterialOrderService {

    void save(MaterialOrder materialOrder);

     Collection<MaterialOrder> findForBuilding(Integer buildingId);
}
