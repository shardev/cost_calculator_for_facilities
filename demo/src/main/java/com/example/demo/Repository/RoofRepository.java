package com.example.demo.Repository;

import com.example.demo.Model.Roof;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoofRepository extends JpaRepository<Roof, Integer> {

}
