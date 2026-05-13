package com.carniceria.isidro.isidrocarniceria.orders.payments.dto;

import java.time.LocalDateTime;

import com.carniceria.isidro.isidrocarniceria.customers.dto.CustomerDTO;
import com.carniceria.isidro.isidrocarniceria.orders.dto.OrderDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonPropertyOrder({ "id", "amount", "paidAt", "remarks","customer",  "order",})
public class PaymentResponseDTO {

    private Long id;

    private CustomerDTO customer;

    @JsonIgnoreProperties({ "customerId"})
    private OrderDTO order;

    private Double amount;

    private LocalDateTime paidAt;

    private String remarks;

}
