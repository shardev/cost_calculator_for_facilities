package com.example.demo.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "facades")
public class Facade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "facade_id", unique = true, nullable = false)
    private Integer id;

    @Column
    private float styrofoamWidth;

    @Column
    private float styrofoamSurfaceArea;

    @Column
    private float facadeNetSurfaceArea;

    @Column
    private float facadeFinalMassKilos;

    @Column
    private float facadeAdhesiveKilos;

    @OneToOne(mappedBy = "facade")
    private Building building;

    public Facade(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getStyrofoamWidth() {
        return styrofoamWidth;
    }

    public void setStyrofoamWidth(float styrofoamWidth) {
        this.styrofoamWidth = styrofoamWidth;
    }

    public float getStyrofoamSurfaceArea() {
        return styrofoamSurfaceArea;
    }

    public void setStyrofoamSurfaceArea(float styrofoamSurfaceArea) {
        this.styrofoamSurfaceArea = styrofoamSurfaceArea;
    }

    public float getFacadeNetSurfaceArea() {
        return facadeNetSurfaceArea;
    }

    public void setFacadeNetSurfaceArea(float facadeNetSurfaceArea) {
        this.facadeNetSurfaceArea = facadeNetSurfaceArea;
    }

    public float getFacadeFinalMassKilos() {
        return facadeFinalMassKilos;
    }

    public void setFacadeFinalMassKilos(float facadeFinalMassKilos) {
        this.facadeFinalMassKilos = facadeFinalMassKilos;
    }

    public float getFacadeAdhesiveKilos() {
        return facadeAdhesiveKilos;
    }

    public void setFacadeAdhesiveKilos(float facadeAdhesiveKilos) {
        this.facadeAdhesiveKilos = facadeAdhesiveKilos;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }
}