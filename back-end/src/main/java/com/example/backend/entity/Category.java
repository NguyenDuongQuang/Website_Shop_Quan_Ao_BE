package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "category")
public class Category {
    @ToString.Include
    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Column(nullable = false)
    private Integer id;

    @ToString.Include
    @NotBlank
    @javax.persistence.Column(columnDefinition = "nvarchar(255)")
    private String name;

    @ToString.Include
    @javax.persistence.Column(nullable = false)
    @NotNull
    private int status = 1;

    @ToString.Include
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    private Date createdAt = new Date();

    @ToString.Include
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    private Date updatedAt = new Date();

    @ToString.Include
    @NotBlank
    @javax.persistence.Column(length = 30)
    private String updatedBy;

}
