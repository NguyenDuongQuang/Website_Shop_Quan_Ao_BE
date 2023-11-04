package com.example.backend.security.controller;

import com.example.backend.security.config.custom.CustomUserDetailService;
import com.example.backend.security.config.custom.CustomUserDetails;
import com.example.backend.security.dto.UsersDTO;
import com.example.backend.security.dto.request.SingInRequest;
import com.example.backend.security.dto.request.SingUpRequest;
import com.example.backend.security.dto.response.JwtResponse;
import com.example.backend.security.dto.response.MessageResponse;
import com.example.backend.security.jwt.JwtEntryPoint;
import com.example.backend.security.jwt.JwtTokenProvider;
import com.example.backend.security.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


import java.time.Instant;


@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class SercurityController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserService usersService;
    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtEntryPoint jwtEntryPoint;

    @PostMapping("/sign-up")
    public ResponseEntity<?> register(@Valid @RequestBody SingUpRequest signUpFormRequest){
        if(usersService.existsByUsername(signUpFormRequest.getUsername())){
            return new ResponseEntity<>(new MessageResponse("The Username is existed"), HttpStatus.OK);
        }
        try {
            return ResponseEntity.ok(usersService.saveOrUpdate(signUpFormRequest));
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new MessageResponse("Error occurred during registration"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

//    @PostMapping("/sign-in")
//    public ResponseEntity<?> login(@Valid @RequestBody SingInRequest signInRequet, HttpServletRequest request ){
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(signInRequet.getUsername(), signInRequet.getPassword())
//        );
//        UsersDTO usersDTO = new UsersDTO();
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
//        String token = jwtTokenProvider.generateToken(customUserDetails);
//        return ResponseEntity.ok(new JwtResponse(token, usersDTO.toUserDTO(customUserDetails)));
//    }
}