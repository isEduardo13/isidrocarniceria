package com.carniceria.isidro.isidrocarniceria.customers.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.carniceria.isidro.isidrocarniceria.customers.entity.Customer;
import com.carniceria.isidro.isidrocarniceria.customers.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


  public Optional<Customer> getCustomerById(Long id) {
    return customerRepository.findById(id);
}
    
}
