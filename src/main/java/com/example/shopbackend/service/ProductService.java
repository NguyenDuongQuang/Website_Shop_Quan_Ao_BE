package com.example.shopbackend.service;


import com.example.shopbackend.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    ResponseEntity<?> createPro(Product createProduct);

    ResponseEntity<Product>editProduct(Product editProduct);

    ResponseEntity<List<Product>> deleteProduct(Long id);

    Product searchAllProduct(Long id);

}
