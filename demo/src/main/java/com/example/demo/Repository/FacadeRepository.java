package com.example.demo.Repository;

import com.example.demo.Model.Facade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacadeRepository extends JpaRepository<Facade, Integer> {

}
