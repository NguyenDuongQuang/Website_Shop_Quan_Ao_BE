package com.example.backend.exception;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ApiErrorResponse {
    private Integer status;
    private String error;
}
