package com.example.shopbackend.service;

import com.example.shopbackend.dto.ProductSaleDTO;

import java.util.List;

public interface ProductSaleService {
    List<ProductSaleDTO>getAllProSale();
    List<ProductSaleDTO> getAllActiveAndAvailableProducts();
    List<ProductSaleDTO> getAllProSaleByCategory(Long categoryId);
}
