package com.carniceria.isidro.isidrocarniceria.products.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "productos")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "descripcion")
    private String descripcion;
    
    @Column(name= "precio_actual")
    private double currentPrice;

    @Column(name= "unidad_venta")
    private String saleUnit;

    @Column(name= "activo")
    private boolean isActive;
}