package com.example.shopbackend.controller;

import com.example.shopbackend.entity.Product;
import com.example.shopbackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/get-all")
    public ResponseEntity<?>getAllPro(){
        return ResponseEntity.ok().body(productService.getAll());
    }
    @PostMapping("/create")
    public ResponseEntity<?>createPro(@RequestBody Product product){
        return ResponseEntity.ok().body(productService.createPro(product));
    }
}
