package com.carniceria.isidro.isidrocarniceria.customers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carniceria.isidro.isidrocarniceria.customers.entity.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}
