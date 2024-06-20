package com.example.demo.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name="roofs")
public class Roof implements Serializable{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "roof_id", unique = true, nullable = false)
   private Integer id;

   @Column
   private Integer numberOfSides;

   @Column
   private Float lengthPerSide;

   @Column
   private Float surfaceAreaForDecking;

   @Column
   private Float surfaceAreaForBoarding;

   @Column
   private Float surfaceAreaForFoiling;

   @Column
   private Integer roofElementsCounter;

   @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "forRoof")
   public Collection<WoodenBeam> woodenBeam;

   @OneToOne(mappedBy = "forRoof")
   public RoofCoverUnit roofCoverUnit;
   
   public Roof(){

   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public Integer getNumberOfSides() {
      return numberOfSides;
   }

   public void setNumberOfSides(Integer numberOfSides) {
      this.numberOfSides = numberOfSides;
   }

   public Float getLengthPerSide() {
      return lengthPerSide;
   }

   public void setLengthPerSide(Float lengthPerSide) {
      this.lengthPerSide = lengthPerSide;
   }

   public Float getSurfaceAreaForDecking() {
      return surfaceAreaForDecking;
   }

   public void setSurfaceAreaForDecking(Float surfaceAreaForDecking) {
      this.surfaceAreaForDecking = surfaceAreaForDecking;
   }

   public Float getSurfaceAreaForBoarding() {
      return surfaceAreaForBoarding;
   }

   public void setSurfaceAreaForBoarding(Float surfaceAreaForBoarding) {
      this.surfaceAreaForBoarding = surfaceAreaForBoarding;
   }

   public Float getSurfaceAreaForFoiling() {
      return surfaceAreaForFoiling;
   }

   public void setSurfaceAreaForFoiling(Float surfaceAreaForFoiling) {
      this.surfaceAreaForFoiling = surfaceAreaForFoiling;
   }

   public Integer getRoofElementsCounter() {
      return roofElementsCounter;
   }

   public void setRoofElementsCounter(Integer roofElementsCounter) {
      this.roofElementsCounter = roofElementsCounter;
   }

   public Collection<WoodenBeam> getWoodenBeam() {
      return woodenBeam;
   }

   public void setWoodenBeam(Collection<WoodenBeam> woodenBeam) {
      this.woodenBeam = woodenBeam;
   }

   public RoofCoverUnit getRoofCoverUnit() {
      return roofCoverUnit;
   }

   public void setRoofCoverUnit(RoofCoverUnit roofCoverUnit) {
      this.roofCoverUnit = roofCoverUnit;
   }
}