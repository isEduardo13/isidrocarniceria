package com.carniceria.isidro.isidrocarniceria.orders.payments.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.carniceria.isidro.isidrocarniceria.orders.payments.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Query("SELECT p FROM Payment p JOIN FETCH p.customer JOIN FETCH p.order WHERE p.id = :id")
    @Override
    Optional<Payment> findById(Long id);
}