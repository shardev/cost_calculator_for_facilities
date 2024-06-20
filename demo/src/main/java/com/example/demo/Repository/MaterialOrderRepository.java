package com.example.demo.Repository;

import com.example.demo.Model.MaterialOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface MaterialOrderRepository extends JpaRepository<MaterialOrder, Integer> {
    Collection<MaterialOrder> findByMaterialOrderForBuilding_Id(Integer buildingId);
}
