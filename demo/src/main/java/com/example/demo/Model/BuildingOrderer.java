package com.example.demo.Model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "building_orderers")
public class BuildingOrderer extends User {

   @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "buildingOrderer")
   public Collection<Building> buildings;

   public BuildingOrderer() {
   }

   public Collection<Building> getBuildings() {
      return buildings;
   }

   public void setBuildings(Collection<Building> buildings) {
      this.buildings = buildings;
   }
}