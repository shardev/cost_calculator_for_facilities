package com.example.demo.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name="roof_cover_units")
public class RoofCoverUnit implements Serializable{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "roof_cover_unit_id", unique = true, nullable = false)
   private Integer id;

   @Column
   private RoofCoverType roofCoverType;

   @Column
   private Float length;

   @Column
   private Float width;

   @Column
   private Float height;

   @Column
   private Integer levelOfEnergyEfficiency;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(referencedColumnName = "roof_id")
   private Roof forRoof;

   public RoofCoverUnit() {
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public RoofCoverType getRoofCoverType() {
      return roofCoverType;
   }

   public void setRoofCoverType(RoofCoverType roofCoverType) {
      this.roofCoverType = roofCoverType;
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

   public Integer getLevelOfEnergyEfficiency() {
      return levelOfEnergyEfficiency;
   }

   public void setLevelOfEnergyEfficiency(Integer levelOfEnergyEfficiency) {
      this.levelOfEnergyEfficiency = levelOfEnergyEfficiency;
   }

   public Roof getForRoof() {
      return forRoof;
   }

   public void setForRoof(Roof forRoof) {
      this.forRoof = forRoof;
   }
}