package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ToString.Include
    @Column(length = 100)
    @JsonIgnore
    private String password;

    @ToString.Include
    @Column(columnDefinition = "nvarchar(255)")
    private String name;

    @ToString.Include
    @Column(nullable = true)
    private int gender;

    @ToString.Include
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date birthDay;

    @ToString.Include
    @Column(nullable = true)
    // @Size(min = 30, max = 300)
    private float height;

    @ToString.Include
    @Column(nullable = true)
    // @Size(min = 3, max = 362)
    private float weight;

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
    @Column(unique = true, length = 100)
    @NotBlank
    @Email
    private String email;

    @ToString.Include
    @NotBlank
    @Column(columnDefinition = "nvarchar(1000)")
    private String image;

    @ToString.Include
    @Column(nullable = false)
    @NotNull
    private int status = 1;

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
}
