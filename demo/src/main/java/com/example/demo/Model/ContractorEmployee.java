package com.example.demo.Model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "contractor_employees")
public class ContractorEmployee extends User {

   @Column
   private Integer pricePerHour;

   @Column
   private ContractorFieldType field;

   @Column
   private Boolean available;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(referencedColumnName = "company_id")
   private ContractorCompany contractorCompany;

}