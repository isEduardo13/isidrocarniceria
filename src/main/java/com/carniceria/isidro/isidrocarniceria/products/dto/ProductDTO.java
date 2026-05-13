package com.carniceria.isidro.isidrocarniceria.products.dto;

import lombok.Builder;

@Builder
public record ProductDTO(Long id, String description, double currentPrice, String saleUnit, boolean isActive) {

}
