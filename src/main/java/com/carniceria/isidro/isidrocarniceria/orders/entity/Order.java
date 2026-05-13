package com.carniceria.isidro.isidrocarniceria.orders.entity;

import java.time.LocalDateTime;

import com.carniceria.isidro.isidrocarniceria.customers.entity.Customer;

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
@Table(name = "encargos")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Customer customer;

    @Column(name = "fecha_creacion")
    private LocalDateTime createAt;

    @Column(name = "fecha_estimada_entrega")
    private LocalDateTime estimatedDeliveryDate;

    @Column(name = "estado")
    private String status;

    @Column(name = "total")
    private double totalMount;

    @Column(name = "anticipo")
    private double deposit;

    @Column(name = "restante")
    private double remainingAmount;

    @Column(name = "notas")
    private String notes;
}
