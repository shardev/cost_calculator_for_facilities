package com.example.demo.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
@Entity
@Table(name = "contractor_engagements")
public class ContractorEngagement implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "contractor_engagement_id", unique = true, nullable = false)
   private Integer id;

   @Column
   private Date startingDate;

   @Column
   private Date finishDate;

   @Column
   private Boolean contractorAccepted;

   @ManyToMany(cascade = CascadeType.ALL)
   @JoinTable(name = "contractor_engagements_employee",
           joinColumns = @JoinColumn(referencedColumnName = "contractor_engagement_id"),
           inverseJoinColumns = @JoinColumn(referencedColumnName = "user_id"))
   public Collection<ContractorEmployee> contractorEmployee;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(referencedColumnName = "cooperation_report_id")
   public CooperationReport cooperationReport;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(referencedColumnName = "building_id")
   public Building building;
}