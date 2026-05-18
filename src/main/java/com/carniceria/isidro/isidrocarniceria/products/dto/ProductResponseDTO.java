package com.carniceria.isidro.isidrocarniceria.products.dto;

public record ProductResponseDTO(
    Long id,
    String description,
    String name,
    double currentPrice,
    String saleUnit,
    boolean isActive
) {

}