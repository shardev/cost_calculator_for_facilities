package com.example.demo.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "floors")
public class Floor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "floor_id", unique = true, nullable = false)
    private Integer id;

    @Column
    private Float surfaceArea;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carpentryForFloor")
    public Collection<CarpentryUnit> carpentryUnits;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roomsForFloor")
    public Collection<Room> room;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wallsForFloor")
    public Collection<Wall> walls;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "concrete_structure_id")
    public ConcreteStructure concreteStructure;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "building_id")
    public Building floorForBuilding;

    public Floor() {
    }

    @Override
    public String toString() {
        return "Floor{" +
                "id=" + id +
                ", surfaceArea=" + surfaceArea +

                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(Float surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public Collection<CarpentryUnit> getCarpentryUnits() {
        return carpentryUnits;
    }

    public void setCarpentryUnits(Collection<CarpentryUnit> carpentryUnits) {
        this.carpentryUnits = carpentryUnits;
    }

    public Collection<Room> getRoom() {
        return room;
    }

    public void setRoom(Collection<Room> room) {
        this.room = room;
    }

    public Collection<Wall> getWalls() {
        return walls;
    }

    public void setWalls(Collection<Wall> walls) {
        this.walls = walls;
    }

    public ConcreteStructure getConcreteStructure() {
        return concreteStructure;
    }

    public void setConcreteStructure(ConcreteStructure concreteStructure) {
        this.concreteStructure = concreteStructure;
    }

    public Building getFloorForBuilding() {
        return floorForBuilding;
    }

    public void setFloorForBuilding(Building floorForBuilding) {
        this.floorForBuilding = floorForBuilding;
    }
}