package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ToString.Include
    @NotBlank
    @Column(columnDefinition = "nvarchar(255)")
    private String name;

    @ToString.Include
    @Column(nullable = false)
    @NotNull
    private int gender;

    @ToString.Include
    @NotBlank
    @Column(columnDefinition = "nvarchar(1000)")
    private String description;

    @ToString.Include
    @Column(nullable = false)
    @NotNull
    private int totalAmount;

    @ToString.Include
    @Column(nullable = false)
    @NotNull
    private int status = 0;

    @ToString.Include
    @Column(nullable = false)
    @NotNull
    private int available = 0;

    @ToString.Include
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    private Date createdAt = new Date();

    @ToString.Include
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    private Date updatedAt = new Date();

    @ToString.Include
    @Column(length = 30)
    private String updatedBy;

    @ManyToOne
    @JoinColumn(name = "Id_Barnd",referencedColumnName = "Id")
    private Barnd barnd;

    @ManyToOne
    @JoinColumn(name = "Id_Category",referencedColumnName = "Id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "Id_Material",referencedColumnName = "Id")
    private Material material;

    @ManyToOne
    @JoinColumn(name = "Id_Supplier",referencedColumnName = "Id")
    private Supplier supplier;

}
