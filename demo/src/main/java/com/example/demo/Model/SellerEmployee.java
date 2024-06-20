package com.example.demo.Model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="seller_employees")
public class SellerEmployee extends User {

   @Column
   private Boolean isBoss;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(referencedColumnName = "company_id")
   public SellerCompany sellerCompany;

}