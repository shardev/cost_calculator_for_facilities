package com.example.demo.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "rooms")
public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id", unique = true, nullable = false)
    private Integer id;

    @Column
    private Float surfaceArea;

    @Column
    private RoomPurpose purpose;

    @Column
    private FlooringType flooring;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "floor_id")
    private Floor roomsForFloor;

    public Room() {
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

    public RoomPurpose getPurpose() {
        return purpose;
    }

    public void setPurpose(RoomPurpose purpose) {
        this.purpose = purpose;
    }

    public FlooringType getFlooring() {
        return flooring;
    }

    public void setFlooring(FlooringType flooring) {
        this.flooring = flooring;
    }

    public Floor getRoomsForFloor() {
        return roomsForFloor;
    }

    public void setRoomsForFloor(Floor roomsForFloor) {
        this.roomsForFloor = roomsForFloor;
    }
}