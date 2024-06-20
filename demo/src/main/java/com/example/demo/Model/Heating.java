package com.example.demo.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "heatings")
public class Heating implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "heating_id", unique = true, nullable = false)
   private Integer id;

   @Column
   private HeatingType heatingType;

   @Column
   private int heatingUnitsCounter;

   @Column
   private int heatingPipeMeters;

   @OneToOne(mappedBy="heating")
   private Building building;

   public Heating(){

   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public HeatingType getHeatingType() {
      return heatingType;
   }

   public void setHeatingType(HeatingType heatingType) {
      this.heatingType = heatingType;
   }

   public int getHeatingUnitsCounter() {
      return heatingUnitsCounter;
   }

   public void setHeatingUnitsCounter(int heatingUnitsCounter) {
      this.heatingUnitsCounter = heatingUnitsCounter;
   }

   public int getHeatingPipeMeters() {
      return heatingPipeMeters;
   }

   public void setHeatingPipeMeters(int heatingPipeMeters) {
      this.heatingPipeMeters = heatingPipeMeters;
   }

   public Building getBuilding() {
      return building;
   }

   public void setBuilding(Building building) {
      this.building = building;
   }
}