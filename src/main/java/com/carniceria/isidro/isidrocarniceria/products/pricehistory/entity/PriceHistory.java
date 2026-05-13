package com.carniceria.isidro.isidrocarniceria.products.pricehistory.entity;



import java.time.LocalDateTime;

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
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "historial_precios")
public class PriceHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id", nullable = false)
    private Product product;
    
    @Column(name = "precio")
    private double price;

    @Column(name = "fecha_inicio")
    private LocalDateTime startTime;

    @Column(name = "fecha_fin")
    private LocalDateTime endTime;


}
