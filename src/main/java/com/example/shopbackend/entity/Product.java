package com.example.shopbackend.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Include
    @Column(nullable = false)
    private String name;

    @ToString.Include
    @Column(nullable = false)
    private float price;

    @ToString.Include
    @Column(nullable = false)
    private String thumbnail;

    @ToString.Include
    @Column(nullable = false)
    private String description;

    @ToString.Include
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ToString.Include
    @Column(name = "update_at", nullable = false)
    private LocalDateTime updatedAt;

    @ToString.Include
    @Column(nullable = false)
    private int discount;

    @ToString.Include
    @Column(nullable = false)
    private int quantity;

    @ToString.Include
    @Column(nullable = false)
    private int status;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductImage> listImages = new ArrayList<>();

}
