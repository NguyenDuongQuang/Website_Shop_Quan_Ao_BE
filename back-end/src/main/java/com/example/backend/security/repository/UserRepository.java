package com.example.backend.security.repository;

import com.example.backend.security.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    public Users findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    String findByRole(String role);
}
