package com.carniceria.isidro.isidrocarniceria.orders.details.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.carniceria.isidro.isidrocarniceria.orders.details.entity.Detail;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Long> {

    @Query("SELECT d FROM Detail d JOIN FETCH d.product WHERE d.id = :id")
    @Override
    Optional<Detail> findById(Long id);
    
}
