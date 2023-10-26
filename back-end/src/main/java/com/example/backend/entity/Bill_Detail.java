package com.example.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@Entity
@Table(name = "bill_detail")
public class Bill_Detail {
    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ToString.Include
    @Column(columnDefinition = "nvarchar(255)")
    private String name;

    @ToString.Include
    @Column(columnDefinition = "nvarchar(1000)")
    private String image;

    @ToString.Include
    @Column(nullable = false)
    private int quantity;

    @ToString.Include
    @Column(nullable = false)
    private double listedPrice;

    @ToString.Include
    @Column(nullable = false)
    private double subPrice;

    @ManyToOne
    @JoinColumn(name = "Id_Bill",referencedColumnName = "Id")
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "Id_Product_Detail",referencedColumnName = "Id")
    private Product_Detail product_detail;
}
