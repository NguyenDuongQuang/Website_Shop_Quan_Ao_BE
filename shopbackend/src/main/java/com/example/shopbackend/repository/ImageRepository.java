package com.example.shopbackend.repository;

import com.example.shopbackend.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ProductImage,Long> {
}
