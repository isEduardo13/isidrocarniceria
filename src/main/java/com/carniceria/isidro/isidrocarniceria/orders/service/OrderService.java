package com.carniceria.isidro.isidrocarniceria.orders.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.carniceria.isidro.isidrocarniceria.exception.ResourceNotFoundException;
import com.carniceria.isidro.isidrocarniceria.mapper.Mapper;
import com.carniceria.isidro.isidrocarniceria.orders.dto.OrderResponseDTO;
import com.carniceria.isidro.isidrocarniceria.orders.entity.Order;
import com.carniceria.isidro.isidrocarniceria.orders.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Optional<OrderResponseDTO> findById(Long id) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        
                return Optional.of(Mapper.orderToResponseDTO(order));

    }

}
