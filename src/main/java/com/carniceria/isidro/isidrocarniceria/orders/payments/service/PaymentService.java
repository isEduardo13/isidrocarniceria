package com.carniceria.isidro.isidrocarniceria.orders.payments.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.carniceria.isidro.isidrocarniceria.exception.ResourceNotFoundException;
import com.carniceria.isidro.isidrocarniceria.mapper.Mapper;
import com.carniceria.isidro.isidrocarniceria.orders.payments.dto.PaymentResponseDTO;
import com.carniceria.isidro.isidrocarniceria.orders.payments.entity.Payment;
import com.carniceria.isidro.isidrocarniceria.orders.payments.repository.PaymentRepository;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Optional<PaymentResponseDTO> findById(Long id) {
        Payment payment = paymentRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Payment not found " ));
        return Optional.of(Mapper.paymentToResponseDTO(payment));
    }

}