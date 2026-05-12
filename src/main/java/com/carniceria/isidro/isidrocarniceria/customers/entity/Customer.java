package com.carniceria.isidro.isidrocarniceria.customers.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Clientes")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "nombre")
    private String name;
    @Column(name= "telefono")
    private String phone;
    @Column(name= "direccion")
    private String address;
    @Column(name= "notas")
    private String notes;   

    
}
