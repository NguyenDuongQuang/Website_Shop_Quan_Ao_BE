package com.example.backend.security.dto.response;

import com.example.backend.security.dto.UsersDTO;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private UsersDTO usersDTO;

    public JwtResponse(String token, UsersDTO toUserDTO) {
        this.token = token;
        this.usersDTO = toUserDTO;
    }
}