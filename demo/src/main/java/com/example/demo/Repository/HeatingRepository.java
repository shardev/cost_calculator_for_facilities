package com.example.demo.Repository;

import com.example.demo.Model.Heating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeatingRepository extends JpaRepository<Heating, Integer> {
}
