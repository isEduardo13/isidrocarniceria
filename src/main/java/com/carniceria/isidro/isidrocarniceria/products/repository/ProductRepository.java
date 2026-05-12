package com.carniceria.isidro.isidrocarniceria.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carniceria.isidro.isidrocarniceria.products.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
