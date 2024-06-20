package com.example.demo.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name="materilas_pricelists")
public class MaterialsPriceList implements Serializable{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "materilas_pricelist_id", unique = true, nullable = false)
   private Integer id;

   @Column
   private Float price;

   @Column
   private Integer amount;

   @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   @JoinColumn(referencedColumnName = "company_id")
   public SellerCompany sellerCompany;

   @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
   @JoinColumn(referencedColumnName = "building_material_id")
   public BuildingMaterial buildingMaterial;

   @ManyToMany(cascade = CascadeType.ALL)
   @JoinTable(joinColumns = @JoinColumn(referencedColumnName = "materilas_pricelist_id"),
           inverseJoinColumns = @JoinColumn(referencedColumnName = "material_order_id"))
   public Collection<MaterialOrder> forOrder = new ArrayList<MaterialOrder>();

   public MaterialsPriceList() {
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public Float getPrice() {
      return price;
   }

   public void setPrice(Float price) {
      this.price = price;
   }

   public Integer getAmount() {
      return amount;
   }

   public void setAmount(Integer amount) {
      this.amount = amount;
   }

   public SellerCompany getSellerCompany() {
      return sellerCompany;
   }

   public void setSellerCompany(SellerCompany sellerCompany) {
      this.sellerCompany = sellerCompany;
   }

   public BuildingMaterial getBuildingMaterial() {
      return buildingMaterial;
   }

   public void setBuildingMaterial(BuildingMaterial buildingMaterial) {
      this.buildingMaterial = buildingMaterial;
   }

   public Collection<MaterialOrder> getForOrder() {
      return forOrder;
   }

   public void setForOrder(Collection<MaterialOrder> forOrder) {
      this.forOrder = forOrder;
   }
}