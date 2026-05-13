package com.carniceria.isidro.isidrocarniceria.orders.dto;

import java.time.LocalDateTime;

public record OrderDTO(Long id, Long customerId, LocalDateTime createAt, LocalDateTime estimatedDeliveryDate, String status, double totalMount, double deposit, double remainingAmount, String notes) {

}
