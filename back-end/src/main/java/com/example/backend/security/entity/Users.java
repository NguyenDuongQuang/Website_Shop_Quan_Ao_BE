package com.example.backend.security.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Column(name = "Username")
    private String username;
    @Column(name = "Name")
    private String name;
    @Column(name = "Password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Status")
    private int status;
    @Column(name = "Image")
    private String image;
    @Column(name = "Note")
    private String note;
    @Column(name = "Created_At")
    private Integer Created_At;
    @Column(name = "Updated_At")
    private Instant Updated_At;
    @Column(name = "Uodated_By")
    private String Uodated_By;
    @Column(name = "Id_Role")
    private String role;
}
