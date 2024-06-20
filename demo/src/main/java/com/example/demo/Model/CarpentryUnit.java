package com.example.demo.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name="carpentry_units")
public class CarpentryUnit implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "carpentry_unit_id", unique = true, nullable = false)
   private Integer id;

   @Column
   private Boolean door;

   @Column
   private Float height;

   @Column
   private Float width;

   @Column
   private CarpentryMaterialType material;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(referencedColumnName = "floor_id")
   private Floor carpentryForFloor;

   public CarpentryUnit(){

   }

   @Override
   public String toString() {
      return "CarpentryUnit{" +
              "id=" + id +
              ", door=" + door +
              ", height=" + height +
              ", width=" + width +
              ", material=" + material +
              '}';
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public Boolean getDoor() {
      return door;
   }

   public void setDoor(Boolean door) {
      this.door = door;
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

   public CarpentryMaterialType getMaterial() {
      return material;
   }

   public void setMaterial(CarpentryMaterialType material) {
      this.material = material;
   }

   public Floor getCarpentryForFloor() {
      return carpentryForFloor;
   }

   public void setCarpentryForFloor(Floor carpentryForFloor) {
      this.carpentryForFloor = carpentryForFloor;
   }
}