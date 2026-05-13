package com.carniceria.isidro.isidrocarniceria.customers.dto;

import lombok.Builder;

@Builder
public record CustomerDTO(Long id, String name, String phone, String address , String notes) {
}