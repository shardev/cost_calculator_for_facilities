package com.example.demo.Model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "contractor_companies")
public class ContractorCompany extends Company {

   @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "contractorCompany")
   public Collection<ContractorEmployee> contractorEmployee;

   @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "contractorCompany")
   public Collection<Machine> machine;
}