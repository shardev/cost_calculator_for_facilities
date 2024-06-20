package com.example.demo.Repository;

import com.example.demo.Model.WoodenBeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WoodenBeamRepository extends JpaRepository<WoodenBeam, Integer> {

}
