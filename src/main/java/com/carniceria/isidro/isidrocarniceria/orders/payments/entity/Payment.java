package com.carniceria.isidro.isidrocarniceria.orders.payments.entity;

import java.time.LocalDateTime;

import com.carniceria.isidro.isidrocarniceria.customers.entity.Customer;
import com.carniceria.isidro.isidrocarniceria.orders.entity.Order;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "abonos")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "encargo_id", nullable = false)
    private Order order;

    @Column(name = "monto")
    private double amount;

    @Column(name = "fecha")
    private LocalDateTime paidAt;

    @Column(name = "observaciones")
    private String remarks;
}
