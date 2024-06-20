package com.example.demo.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name ="building_material_estitmations")
public class BuildingMaterialEstimation implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "bme_id", unique = true, nullable = false)
   private Integer id;

   @Column
   private Float cementKilos;

   @Column
   private Float sandTons;

   @Column
   private Float rockTons;

   @Column
   private Float armatureMeters2;

   @Column
   private Float hydroIsolationMeters2;

   @Column
   private Float electricalInstallationCablesMeters;

   @Column
   private Float watterPipeMeters;

   @OneToOne(mappedBy = "buildingMaterialEstimation")
   public Building building;

   public BuildingMaterialEstimation() {
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public Float getCementKilos() {
      return cementKilos;
   }

   public void setCementKilos(Float cementKilos) {
      this.cementKilos = cementKilos;
   }

   public Float getSandTons() {
      return sandTons;
   }

   public Float getArmatureMeters() {
      return armatureMeters2;
   }

   public Float getArmatureMeters2() {
      return armatureMeters2;
   }

   public void setArmatureMeters2(Float armatureMeters2) {
      this.armatureMeters2 = armatureMeters2;
   }

   public Float getHydroIsolationMeters2() {
      return hydroIsolationMeters2;
   }

   public void setHydroIsolationMeters2(Float hydroIsolationMeters2) {
      this.hydroIsolationMeters2 = hydroIsolationMeters2;
   }

   public void setArmatureMeters(Float armatureMeters) {
      this.armatureMeters2 = armatureMeters;
   }

   public void setSandTons(Float sandTons) {
      this.sandTons = sandTons;
   }

   public Float getRockTons() {
      return rockTons;
   }

   public void setRockTons(Float rockTons) {
      this.rockTons = rockTons;
   }

   public Float getElectricalInstallationCablesMeters() {
      return electricalInstallationCablesMeters;
   }

   public void setElectricalInstallationCablesMeters(Float electricalInstallationCablesMeters) {
      this.electricalInstallationCablesMeters = electricalInstallationCablesMeters;
   }

   public Float getWatterPipeMeters() {
      return watterPipeMeters;
   }

   public void setWatterPipeMeters(Float watterPipeMeters) {
      this.watterPipeMeters = watterPipeMeters;
   }

   public Building getBuilding() {
      return building;
   }

   public void setBuilding(Building building) {
      this.building = building;
   }
}