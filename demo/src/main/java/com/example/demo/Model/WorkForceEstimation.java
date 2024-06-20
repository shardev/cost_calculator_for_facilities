package com.example.demo.Model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "work_force_estimations")
public class WorkForceEstimation implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "wfc_id", unique = true, nullable = false)
   private Integer id;

   @Column
   private Integer numberOfTrucks;

   @Column
   private Integer numberOfExcavators;

   @Column
   private Integer numberOfCranes;

   @Column
   private Integer numberOfBrickMason;

   @Column
   private Integer numberOfMason;

   @Column
   private Integer numberOfElectrician;

   @Column
   private Integer numberOfCarpenters;

   @Column
   private Integer numberOfPlumbers;

   @Column
   private Integer numberOfFloorContractors;

   @Column
   private Integer numberOfProjectManagers;

   @Column
   private Integer numberOfFacadeContractors;

   @Column
   private Integer numberOfSiteSafetyManagers;

   @Column
   private Integer numberOfConstructionInspectors;

   @Column
   private Integer numberOfCraneOperators;

   @OneToOne(mappedBy= "workForceEstimation")
   public Building building;

}