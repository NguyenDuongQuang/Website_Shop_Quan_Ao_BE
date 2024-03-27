package com.example.shopbackend.repository;

import com.example.shopbackend.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDto,Long> {
}
