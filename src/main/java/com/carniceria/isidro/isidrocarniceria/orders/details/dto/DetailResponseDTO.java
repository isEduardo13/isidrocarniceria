package com.carniceria.isidro.isidrocarniceria.orders.details.dto;

import com.carniceria.isidro.isidrocarniceria.orders.dto.OrderDTO;
import com.carniceria.isidro.isidrocarniceria.products.dto.ProductDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DetailResponseDTO {
    private Long id;

    private ProductDTO product;

    private OrderDTO order;

    private double salePrice;

    private double subtotal;
}
