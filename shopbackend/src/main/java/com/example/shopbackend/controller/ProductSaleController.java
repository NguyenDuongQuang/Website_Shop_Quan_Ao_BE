package com.example.shopbackend.controller;

import com.example.shopbackend.dto.ProductSaleDTO;
import com.example.shopbackend.service.ProductSaleService;
import com.example.shopbackend.service.ProductService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/product/sale")
public class ProductSaleController {
    @Autowired
    private ProductSaleService productSaleService;
    @GetMapping("/get-all")
    public ResponseEntity<List<ProductSaleDTO>> getAllProductSale(){
        return ResponseEntity.ok().body(productSaleService.getAllProSale());
    }

    @GetMapping("/get-all-ready")
    public ResponseEntity<?> getAllProductSaleReady(){
        return ResponseEntity.ok().body(productSaleService.getAllActiveAndAvailableProducts());
    }

    @GetMapping("/category/get-all-ready/{id}")
    public ResponseEntity<?>getAllProByPro(@PathVariable @Positive Long id){
        return ResponseEntity.ok().body(productSaleService.getAllProSaleByCategory(id));
    }
}
