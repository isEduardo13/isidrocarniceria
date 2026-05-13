package com.carniceria.isidro.isidrocarniceria.orders.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.carniceria.isidro.isidrocarniceria.customers.dto.CustomerDTO;
import com.carniceria.isidro.isidrocarniceria.orders.details.dto.DetailDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonPropertyOrder({ "id", "createAt", "estimatedDeliveryDate", "status", "totalMount", "deposit", "remainingAmount",
        "notes", "customer", "details" })
public class OrderResponseDTO {
    private Long id;

    private LocalDateTime createAt;

    private LocalDateTime estimatedDeliveryDate;

    private String status;

    private double totalMount;

    private double deposit;

    private double remainingAmount;

    private String notes;

    private CustomerDTO customer;

    @JsonIgnoreProperties({ "OrderId" })
    private List<DetailDTO> details;
}