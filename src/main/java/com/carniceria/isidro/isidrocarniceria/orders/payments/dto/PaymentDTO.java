package com.carniceria.isidro.isidrocarniceria.orders.payments.dto;

import java.time.LocalDateTime;

public record PaymentDTO(
        Long id,
        Long customerId,
        Long orderId,
        Double amount,
        LocalDateTime paidAt,
        String remarks) {
}