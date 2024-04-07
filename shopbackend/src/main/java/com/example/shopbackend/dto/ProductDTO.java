package com.example.shopbackend.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class ProductDTO {
    private Long id;
    private String name;
    private Double price;
    private String thumbnail;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer discount;
    private Integer quantity;
    private Integer status;
    private String categoryName;
}
