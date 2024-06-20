package com.example.demo.Model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="seller_companies")
public class SellerCompany extends Company {


   @Column
   private Float priceForTransport;

   @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sellerCompany")
   public Collection<SellerEmployee> sellerEmployee;

   //@OneToOne(mappedBy="sellerCompany", fetch = FetchType.LAZY)
   //public MaterialsPriceList materialsPriceList;


   public SellerCompany() {
   }

   public Float getPriceForTransport() {
      return priceForTransport;
   }

   public void setPriceForTransport(Float priceForTransport) {
      this.priceForTransport = priceForTransport;
   }

   public Collection<SellerEmployee> getSellerEmployee() {
      return sellerEmployee;
   }

   public void setSellerEmployee(Collection<SellerEmployee> sellerEmployee) {
      this.sellerEmployee = sellerEmployee;
   }
}