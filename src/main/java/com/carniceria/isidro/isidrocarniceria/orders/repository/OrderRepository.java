package com.carniceria.isidro.isidrocarniceria.orders.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.carniceria.isidro.isidrocarniceria.orders.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
    @Query("SELECT o FROM Order o JOIN FETCH o.customer WHERE o.id = :id")
    Optional<Order> findByIdWithCustomer(Long id);   
}
 