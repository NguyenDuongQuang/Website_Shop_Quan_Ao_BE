package com.example.shopbackend.repository;


import com.example.shopbackend.entity.Product;
import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product>findAll();
    Optional<Product>findById(Long id);
    Product findByName(String name);
    Product findByCategory(Long category_id);

}
