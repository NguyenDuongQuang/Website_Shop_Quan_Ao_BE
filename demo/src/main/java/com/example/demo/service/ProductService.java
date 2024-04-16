package com.example.demo.service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductImage;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAllProductsWithDetails() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToProductDTO).collect(Collectors.toList());
    }

    private ProductDTO mapToProductDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setThumbnail(product.getThumbnail());
        dto.setDescription(product.getDescription());
        dto.setDiscount(product.getDiscount());
        dto.setQuantity(product.getQuantity());
        dto.setStatus(product.getStatus());
        dto.setCategoryName(product.getCategory());
        dto.setImgUrl(product.getListImages().isEmpty() ? "" : product.getListImages().get(0).getImgUrl());
        return dto;
    }

}