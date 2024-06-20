package com.example.demo.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name="walls")
public class Wall implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "wall_id", unique = true, nullable = false)
   private Integer id;

   @Column
   private Integer wallElementsCounter;

   @Column
   private Float length;

   @Column
   private Float height;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(referencedColumnName = "wall_unit_id")
   public WallUnit wallUnit;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(referencedColumnName = "floor_id")
   private Floor wallsForFloor;

   public Wall() {
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public Integer getWallElementsCounter() {
      return wallElementsCounter;
   }

   public void setWallElementsCounter(Integer wallElementsCounter) {
      this.wallElementsCounter = wallElementsCounter;
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

   public WallUnit getWallUnit() {
      return wallUnit;
   }

   public void setWallUnit(WallUnit wallUnit) {
      this.wallUnit = wallUnit;
   }

   public Floor getWallsForFloor() {
      return wallsForFloor;
   }

   public void setWallsForFloor(Floor wallsForFloor) {
      this.wallsForFloor = wallsForFloor;
   }

   @Override
   public String toString() {
      return "Wall{" +
              "id=" + id +
              ", wallElementsCounter=" + wallElementsCounter +
              ", length=" + length +
              ", height=" + height +
              '}';
   }
}