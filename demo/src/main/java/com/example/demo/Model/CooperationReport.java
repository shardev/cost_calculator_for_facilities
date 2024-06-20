package com.example.demo.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Entity
@Table(name = "cooperation_reports")
public class CooperationReport implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "cooperation_report_id", unique = true, nullable = false)
   private Integer id;

   @Column
   private int grade;

   @Column
   private String comment;

   @OneToOne(mappedBy = "cooperationReport")
   private ContractorEngagement contractorEngagement;

}