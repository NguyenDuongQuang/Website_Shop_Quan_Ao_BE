package com.example.backend.security.service;

import com.example.backend.common.ServiceResult;
import com.example.backend.security.dto.request.SingUpRequest;
import com.example.backend.security.entity.Users;


public interface UserService {
    public Users findByUsername(String userName);
    boolean existsByUsername(String userName);
    boolean existsByEmail(String email);
    String findByRole(String role);
    ServiceResult<Users> saveOrUpdate(SingUpRequest signUpRepquest);
    boolean isUser(String username);

}

