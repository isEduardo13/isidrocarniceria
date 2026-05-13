package com.carniceria.isidro.isidrocarniceria.orders.dto;

public record OrderSummaryDTO(Long id, String customerName, String status, double totalMount) {
    
}
