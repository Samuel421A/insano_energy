package com.samuca.insano_energy.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Marca")
    private String marca;

    @Column(name = "Sabor")
    private String sabor;

    @Column(name = "Quantidade(ml)")
    private String quantidade;

    @Column(name = "Valor")
    private Double valor;
}

