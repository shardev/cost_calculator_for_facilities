package com.example.demo.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "building_materials")
public class BuildingMaterial implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "building_material_id", unique = true, nullable = false)
    private Integer id;

    @Column(unique = true)
    private String code;

    @Column
    private ProductCategory productCategory;

    @Column
    private String name;

    @Column
    private String image;

    @Column
    private Float height;

    @Column
    private Float width;

    @Column
    private Float length;

    @Column
    private Float weight;

    //@OneToOne(mappedBy = "buildingMaterial", orphanRemoval = true, fetch= FetchType.LAZY)
    //private MaterialsPriceList materialsPriceList;

    public BuildingMaterial() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

//    public MaterialsPriceList getMaterialsPriceList() {
//        return materialsPriceList;
//    }
//
//    public void setMaterialsPriceList(MaterialsPriceList materialsPriceList) {
//        this.materialsPriceList = materialsPriceList;
//    }
}