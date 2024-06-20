package com.example.demo.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "concrete_structures")
public class ConcreteStructure implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "concrete_structure_id", unique = true, nullable = false)
   private Integer id;

   @Column
   private Float length;

   @Column
   private Float width;

   @Column
   private Float height;

   @Column
   private ConcreteStructureType structureType;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(referencedColumnName = "building_id")
   private Building concreteStructuresForBuilding;

   @OneToOne(mappedBy = "concreteStructure")
   private Floor forFloor;

   public ConcreteStructure(){

   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
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

   public ConcreteStructureType getStructureType() {
      return structureType;
   }

   public void setStructureType(ConcreteStructureType structureType) {
      this.structureType = structureType;
   }

   public Building getConcreteStructuresForBuilding() {
      return concreteStructuresForBuilding;
   }

   public void setConcreteStructuresForBuilding(Building concreteStructuresForBuilding) {
      this.concreteStructuresForBuilding = concreteStructuresForBuilding;
   }

   public Floor getForFloor() {
      return forFloor;
   }

   public void setForFloor(Floor forFloor) {
      this.forFloor = forFloor;
   }
}