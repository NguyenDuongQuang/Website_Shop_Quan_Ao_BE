package com.example.shopbackend.dto;
import com.example.shopbackend.entity.Category;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductSaleDTO implements Serializable {
    private Long id;
    private String name;
    private float price;
    private String description;
    private int discount;
    private int quantity;
    private int status;
    private String categoryName;
    private String imgUrl;
}
