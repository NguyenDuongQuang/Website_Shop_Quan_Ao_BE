package com.example.shopbackend.controller;

import com.example.shopbackend.entity.Product;
import com.example.shopbackend.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/update/{id}")
    public ResponseEntity<?> editPro(@RequestBody Product product){
        return ResponseEntity.ok().body(productService.editProduct(product));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<Product>> deletePro(@PathVariable("id") Long id){
        return productService.deleteProduct(id);
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<?> searchPro(@PathVariable @Positive Long id){
        return ResponseEntity.ok().body(productService.searchAllProduct(id));
    }

}
