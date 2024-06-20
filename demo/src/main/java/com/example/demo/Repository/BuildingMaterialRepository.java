package com.example.demo.Repository;

import com.example.demo.Model.BuildingMaterial;
import com.example.demo.Model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BuildingMaterialRepository extends JpaRepository<BuildingMaterial, Integer> {
    Collection<BuildingMaterial> findByProductCategory(ProductCategory productCategory);


}
