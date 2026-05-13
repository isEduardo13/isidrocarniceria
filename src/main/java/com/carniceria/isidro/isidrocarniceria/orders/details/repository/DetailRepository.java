package com.carniceria.isidro.isidrocarniceria.orders.details.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carniceria.isidro.isidrocarniceria.orders.details.entity.Detail;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Long> {
    
}
