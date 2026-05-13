package com.carniceria.isidro.isidrocarniceria.orders.details.entity;

import com.carniceria.isidro.isidrocarniceria.orders.entity.Order;
import com.carniceria.isidro.isidrocarniceria.products.entity.Product;

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
@Table(name = "detalle_encargo")
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "encargo_id", nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id", nullable = false)
    private Product product;

    @Column(nullable = false, name = "cantidad")
    private double quantity;
    
    @Column(name = "precio_venta", nullable = false)
    private double salePrice;

    @Column(name = "subtotal", nullable = false)
    private double subtotal;
}