package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@Entity
@Table(name = "supplier")
public class Supplier {
    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @ToString.Include
    @NotBlank
    @Column(columnDefinition = "nvarchar(255)")
    private String name;

    @ToString.Include
    @NotBlank
    @Column(columnDefinition = "nvarchar(1000)")
    private String address;

    @ToString.Include
    @NotBlank
    @Column(columnDefinition = "nvarchar(100)")
    private String ward;

    @ToString.Include
    @NotBlank
    @Column(columnDefinition = "nvarchar(100)")
    private String district;

    @ToString.Include
    @NotBlank
    @Column(columnDefinition = "nvarchar(100)")
    private String province;

    @ToString.Include
    private int phone;

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
    @JoinColumn(name = "Id_Country", referencedColumnName = "Id")
    private Country country;


}
