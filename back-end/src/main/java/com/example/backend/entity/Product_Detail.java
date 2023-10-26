package com.example.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@Entity
@Table(name = "product_detail")
public class Product_Detail {
    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ToString.Include
    @Column(nullable = false)
    @NotNull
    private int Amount;

    @ToString.Include
    @Column(nullable = false)
    @NotNull
    private double originPrice;

    @ToString.Include
    @Column(nullable = false)
    @NotNull
    private double promotionPercentage;

    @ToString.Include
    @Column(nullable = false)
    @NotNull
    private double promotionPrice;

    @ToString.Include
    @Column(nullable = false)
    private int status;

    @ManyToOne
    @JoinColumn(name = "Id_Color",referencedColumnName = "Id")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "Id_Product",referencedColumnName = "Id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "Id_Size",referencedColumnName = "Id")
    private Size size;
}
