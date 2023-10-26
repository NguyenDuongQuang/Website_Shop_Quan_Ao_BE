package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@Entity
@Table(name = "payment")
public class Payment {
    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ToString.Include
    @Column(nullable = false)
    @NotNull
    private int paymentStatus;

    @ToString.Include
    @Column(nullable = false)
    @NotNull
    private int paymentType;

    @ToString.Include
    @Column(nullable = false)
    @NotNull
    private int totalPayment;

    @ToString.Include
    @Column(nullable = false)
    @NotNull
    private int totalPrice;

    @ToString.Include
    @Column(nullable = false)
    @NotNull
    private int shipCode;

    @ToString.Include
    @Column(nullable = false)
    @NotNull
    private int shipType;

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
    @JoinColumn(name = "Id_Bill",referencedColumnName = "Id")
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "Id_Voucher",referencedColumnName = "Id")
    private Voucher voucher;

}
