package com.example.demo.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "material_orders")
public class MaterialOrder implements Serializable{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "material_order_id", unique = true, nullable = false)
   private Integer id;

   @Column
   private Float finalPrice;

   @Column
   private OrderStatus status;

   @Column
   private Date orderingDate;

   @Column
   private Date deliveredDate;

   @Column
   private Date confirmedDate;

   @Column
   private Date rejectedDate;

   @Column
   private Date trucksLoadedDate;

   @Column
   private Boolean wantsDelivery;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(referencedColumnName = "cooperation_report_id")
   public CooperationReport cooperationReport;

   @ManyToMany(mappedBy = "forOrder")
   public Collection<MaterialsPriceList> materialsPriceList = new ArrayList<MaterialsPriceList>();

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(referencedColumnName = "building_id")
   public Building materialOrderForBuilding;

   public MaterialOrder() {}

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public Float getFinalPrice() {
      return finalPrice;
   }

   public void setFinalPrice(Float finalPrice) {
      this.finalPrice = finalPrice;
   }

   public OrderStatus getStatus() {
      return status;
   }

   public void setStatus(OrderStatus status) {
      this.status = status;
   }

   public Date getOrderingDate() {
      return orderingDate;
   }

   public void setOrderingDate(Date orderingDate) {
      this.orderingDate = orderingDate;
   }

   public Date getDeliveredDate() {
      return deliveredDate;
   }

   public void setDeliveredDate(Date deliveredDate) {
      this.deliveredDate = deliveredDate;
   }

   public Date getConfirmedDate() {
      return confirmedDate;
   }

   public void setConfirmedDate(Date confirmedDate) {
      this.confirmedDate = confirmedDate;
   }

   public Date getRejectedDate() {
      return rejectedDate;
   }

   public void setRejectedDate(Date rejectedDate) {
      this.rejectedDate = rejectedDate;
   }

   public Date getTrucksLoadedDate() {
      return trucksLoadedDate;
   }

   public void setTrucksLoadedDate(Date trucksLoadedDate) {
      this.trucksLoadedDate = trucksLoadedDate;
   }

   public Boolean getWantsDelivery() {
      return wantsDelivery;
   }

   public void setWantsDelivery(Boolean wantsDelivery) {
      this.wantsDelivery = wantsDelivery;
   }

   public CooperationReport getCooperationReport() {
      return cooperationReport;
   }

   public void setCooperationReport(CooperationReport cooperationReport) {
      this.cooperationReport = cooperationReport;
   }

   public Collection<MaterialsPriceList> getMaterialsPriceList() {
      return materialsPriceList;
   }

   public void setMaterialsPriceList(Collection<MaterialsPriceList> materialsPriceList) {
      this.materialsPriceList = materialsPriceList;
   }

   public Building getMaterialOrderForBuilding() {
      return materialOrderForBuilding;
   }

   public void setMaterialOrderForBuilding(Building materialOrderForBuilding) {
      this.materialOrderForBuilding = materialOrderForBuilding;
   }
}