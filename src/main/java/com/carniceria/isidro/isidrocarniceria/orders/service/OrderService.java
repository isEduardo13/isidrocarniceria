package com.carniceria.isidro.isidrocarniceria.orders.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.carniceria.isidro.isidrocarniceria.orders.entity.Order;
import com.carniceria.isidro.isidrocarniceria.orders.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Optional<Order>findByIdWithCustomer(Long id) {
        return orderRepository.findByIdWithCustomer(id);
    }
    
}
