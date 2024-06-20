package com.example.demo.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "machines")
public class Machine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "machine_id", unique = true, nullable = false)
    private Integer id;

    @Column
    private String code;

    @Column
    private Integer pricePerHour;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "company_id")
    private ContractorCompany contractorCompany;
}