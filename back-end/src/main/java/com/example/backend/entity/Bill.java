package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@Entity
@Table(name = "bill")
public class Bill {
    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ToString.Include
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date confirmedAt;

    @ToString.Include
    @Column(nullable = false)
    private String email;

    @ToString.Include
    private int phone;

    @ToString.Include
    @Column(columnDefinition = "nvarchar(1000)", nullable = false)
    private String address;

    @ToString.Include
    @Column(columnDefinition = "nvarchar(255)", nullable = false)
    private String ward;

    @ToString.Include
    @Column(columnDefinition = "nvarchar(255)", nullable = false)
    private String district;

    @ToString.Include
    @Column(columnDefinition = "nvarchar(255)", nullable = false)
    private String province;

    @ToString.Include
    @Column(columnDefinition = "nvarchar(1000)")
    private String note;

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
