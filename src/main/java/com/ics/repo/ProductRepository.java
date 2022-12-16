package com.ics.repo;

import com.ics.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;


public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value="SELECT p FROM Product p WHERE p.id=?1")
    public Product findByProductId(Long id);


}
