package com.example.demo.Repository;

import com.example.demo.Model.MaterialsPriceList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialPricelistRepository extends JpaRepository<MaterialsPriceList,Integer> {
}
