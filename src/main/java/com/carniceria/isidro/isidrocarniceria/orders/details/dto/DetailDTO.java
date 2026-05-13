package com.carniceria.isidro.isidrocarniceria.orders.details.dto;

public record DetailDTO(Long id, Long productId, Long OrderId, double salePrice, double subtotal) {

}
