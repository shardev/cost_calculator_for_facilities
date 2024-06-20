package com.example.demo.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "buildings")
public class Building implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "building_id", unique = true, nullable = false)
   private Integer id;

   @Column
   private Boolean active;

   @Column
   private Boolean built;

   @Column
   private java.util.Date createdAt;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(referencedColumnName = "wfc_id")
   public WorkForceEstimation workForceEstimation;

   @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialOrderForBuilding")
   public Collection<MaterialOrder> materialOrder;

   @OneToMany(cascade = CascadeType.ALL, mappedBy = "floorForBuilding")
   public Collection<Floor> floor;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(referencedColumnName = "heating_id")
   public Heating heating;

   @OneToMany(cascade = CascadeType.ALL, mappedBy = "concreteStructuresForBuilding")
   public Collection<ConcreteStructure> concreteStructure;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(referencedColumnName = "roof_id")
   public Roof roof;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(referencedColumnName = "facade_id")
   public Facade facade;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(referencedColumnName = "user_id")
   public BuildingOrderer buildingOrderer;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(referencedColumnName = "bme_id")
   public BuildingMaterialEstimation buildingMaterialEstimation;

   @OneToOne(mappedBy = "building")
   public ContractorEngagement contractorEngagement;

   public Building() {
   }

   @Override
   public String toString() {
      return "Building{" +
              "id=" + id +
              ", active=" + active +
              ", built=" + built +
              ", createdAt=" + createdAt +
              ", workForceEstimation=" + workForceEstimation +
              ", materialOrder=" + materialOrder +
              ", floor=" + floor +
              ", heating=" + heating +
              ", concreteStructure=" + concreteStructure +
              ", roof=" + roof +
              ", facade=" + facade +
              ", buildingOrderer=" + buildingOrderer +
              ", buildingMaterialEstimation=" + buildingMaterialEstimation +
              ", contractorEngagement=" + contractorEngagement +
              '}';
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public Boolean getActive() {
      return active;
   }

   public void setActive(Boolean active) {
      this.active = active;
   }

   public Boolean getBuilt() {
      return built;
   }

   public void setBuilt(Boolean built) {
      this.built = built;
   }

   public Date getCreatedAt() {
      return createdAt;
   }

   public void setCreatedAt(Date createdAt) {
      this.createdAt = createdAt;
   }

   public WorkForceEstimation getWorkForceEstimation() {
      return workForceEstimation;
   }

   public void setWorkForceEstimation(WorkForceEstimation workForceEstimation) {
      this.workForceEstimation = workForceEstimation;
   }

   public Collection<MaterialOrder> getMaterialOrder() {
      return materialOrder;
   }

   public void setMaterialOrder(Collection<MaterialOrder> materialOrder) {
      this.materialOrder = materialOrder;
   }

   public Collection<Floor> getFloor() {
      return floor;
   }

   public void setFloor(Collection<Floor> floor) {
      this.floor = floor;
   }

   public Heating getHeating() {
      return heating;
   }

   public void setHeating(Heating heating) {
      this.heating = heating;
   }

   public Collection<ConcreteStructure> getConcreteStructure() {
      return concreteStructure;
   }

   public void setConcreteStructure(Collection<ConcreteStructure> concreteStructure) {
      this.concreteStructure = concreteStructure;
   }

   public Roof getRoof() {
      return roof;
   }

   public void setRoof(Roof roof) {
      this.roof = roof;
   }

   public Facade getFacade() {
      return facade;
   }

   public void setFacade(Facade facade) {
      this.facade = facade;
   }

   public BuildingOrderer getBuildingOrderer() {
      return buildingOrderer;
   }

   public void setBuildingOrderer(BuildingOrderer buildingOrderer) {
      this.buildingOrderer = buildingOrderer;
   }

   public BuildingMaterialEstimation getBuildingMaterialEstimation() {
      return buildingMaterialEstimation;
   }

   public void setBuildingMaterialEstimation(BuildingMaterialEstimation buildingMaterialEstimation) {
      this.buildingMaterialEstimation = buildingMaterialEstimation;
   }

   public ContractorEngagement getContractorEngagement() {
      return contractorEngagement;
   }

   public void setContractorEngagement(ContractorEngagement contractorEngagement) {
      this.contractorEngagement = contractorEngagement;
   }

}