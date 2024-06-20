package com.example.demo.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name="wall_units")
public class WallUnit implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "wall_unit_id", unique = true, nullable = false)
   private Integer id;

   @Column
   private WallUnitType wallUnitType;

   @Column
   private ProductCategory productCategory;

   @Column
   private Float length;

   @Column
   private Float width;

   @Column
   private Float height;

   @OneToOne(mappedBy = "wallUnit")
   private Wall forWall;

   public WallUnit() {
   }

   @Override
   public String toString() {
      return "WallUnit{" +
              "id=" + id +
              ", wallUnitType=" + wallUnitType +
              ", productCategory=" + productCategory +
              ", length=" + length +
              ", width=" + width +
              ", height=" + height +
              '}';
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public WallUnitType getWallUnitType() {
      return wallUnitType;
   }

   public void setWallUnitType(WallUnitType wallUnitType) {
      this.wallUnitType = wallUnitType;
   }

   public Float getLength() {
      return length;
   }

   public void setLength(Float length) {
      this.length = length;
   }

   public Float getWidth() {
      return width;
   }

   public void setWidth(Float width) {
      this.width = width;
   }

   public Float getHeight() {
      return height;
   }

   public void setHeight(Float height) {
      this.height = height;
   }

   public Wall getForWall() {
      return forWall;
   }

   public void setForWall(Wall forWall) {
      this.forWall = forWall;
   }

   public ProductCategory getProductCategory() {
      return productCategory;
   }

   public void setProductCategory(ProductCategory productCategory) {
      this.productCategory = productCategory;
   }
}