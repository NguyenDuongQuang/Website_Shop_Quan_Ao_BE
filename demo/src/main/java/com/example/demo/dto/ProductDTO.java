package com.example.demo.dto;

import com.example.demo.entity.Category;
import com.example.demo.entity.ProductImage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDTO {
    private Long id;
    private String name;
    private float price;
    private String thumbnail;
    private String description;
    private int discount;
    private int quantity;
    private int status;
    private Category categoryName;
    private String  imgUrl;

}
