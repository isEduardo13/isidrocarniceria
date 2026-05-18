package com.carniceria.isidro.isidrocarniceria.products.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.carniceria.isidro.isidrocarniceria.products.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    @Query("SELECT p FROM Product p WHERE p.id = :id")
    Optional<Product> findById(Long id);
    
}
