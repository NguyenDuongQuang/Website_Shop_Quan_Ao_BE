package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @JsonIgnore
    @NotBlank
    private String password;

    @Column(columnDefinition = "nvarchar(255)")
    private String name;

    private int gender;

    @Column(unique = true, length = 20)
    private String identityCard;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date birthDay;

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

    @Column(unique = true, length = 100)
    private String email;

    @Column(length = 1000)
    private String image;

    @Column(columnDefinition = "nvarchar(255)")
    private String note;

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
