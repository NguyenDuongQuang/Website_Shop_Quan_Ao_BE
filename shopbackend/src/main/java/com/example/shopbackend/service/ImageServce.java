package com.example.shopbackend.service;


import com.example.shopbackend.entity.ProductImage;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ImageServce {
    List<ProductImage> getAll();

    ResponseEntity<?> createImage(ProductImage product_image);

    ResponseEntity<ProductImage>editImage(ProductImage editProImage);

    ResponseEntity<List<ProductImage>> deleteProImage(Long id);
}
