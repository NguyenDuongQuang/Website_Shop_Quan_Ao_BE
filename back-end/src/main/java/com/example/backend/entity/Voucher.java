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
@Table(name = "voucher")
public class Voucher {
    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ToString.Include
    @Column(columnDefinition = "nvarchar(255)", nullable = false)
    private String name;

    @ToString.Include
    @Column(nullable = false)
    private String code;

    @ToString.Include
    @Column(nullable = false)
    private int active;

    @ToString.Include
    @Column(nullable = false)
    private Integer slot;

    @ToString.Include
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @ToString.Include
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @ToString.Include
    @Column(columnDefinition = "nvarchar(225)")
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

    @ManyToOne
    @JoinColumn(name = "Id_Customer",referencedColumnName = "Id")
    private Customer customer;
}
