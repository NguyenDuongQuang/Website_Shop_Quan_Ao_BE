package com.example.backend.security.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SingUpRequest {
    private String fullname;
    private String username;
    private String password;
    private String email;
    private String phone;
    private Date birthday;
    private String gender;
}