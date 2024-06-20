package com.example.demo.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "wooden_beams")
public class WoodenBeam implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wooden_beam_id", unique = true, nullable = false)
    private Integer id;

    @Column
    private Float length;

    @Column
    private Float height;

    @Column
    private Float width;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "roof_id")
    private Roof forRoof;

    public WoodenBeam(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Roof getForRoof() {
        return forRoof;
    }

    public void setForRoof(Roof forRoof) {
        this.forRoof = forRoof;
    }
}