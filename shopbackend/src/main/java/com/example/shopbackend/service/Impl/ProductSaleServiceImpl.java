package com.example.shopbackend.service.Impl;

import com.example.shopbackend.dto.ProductSaleDTO;
import com.example.shopbackend.entity.Category;
import com.example.shopbackend.entity.Product;
import com.example.shopbackend.repository.CategoryRepository;
import com.example.shopbackend.repository.ProductRepository;
import com.example.shopbackend.service.ProductSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductSaleServiceImpl implements ProductSaleService {
    @Autowired
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    private ProductSaleDTO maptoProductSaleDTO(Product product){
        ProductSaleDTO productSaleDTO=new ProductSaleDTO();
        productSaleDTO.setId(product.getId());
        productSaleDTO.setName(product.getName());
        productSaleDTO.setPrice(product.getPrice());
        productSaleDTO.setDescription(product.getDescription());
        productSaleDTO.setDiscount(product.getDiscount());
        productSaleDTO.setStatus(product.getStatus());
        productSaleDTO.setQuantity(product.getQuantity());
        productSaleDTO.setCategoryName(product.getCategory().getName());
        productSaleDTO.setImgUrl(product.getListImages().isEmpty() ? "" : product.getListImages().get(0).getImgUrl());
        return productSaleDTO;
    }

    @Override
    public List<ProductSaleDTO> getAllProSale() {
        List<Product>productList=productRepository.findAll();
        return productList.stream().map(this::maptoProductSaleDTO).collect(Collectors.toList());
    }

    @Override
    public List<ProductSaleDTO> getAllActiveAndAvailableProducts() {
        List<ProductSaleDTO> productSaleDTOs = new ArrayList<>();

        List<Product> productList = productRepository.findAll()
                .stream()
                .filter(product -> product.getStatus() == 1)
                .filter(product -> product.getPrice() > 0)
                .filter(product -> product.getCategory().getStatus() == 1)
                .collect(Collectors.toList());

        return mapToProductSaleDTO(productSaleDTOs,productList);
    }

    private List<ProductSaleDTO> mapToProductSaleDTO(List<ProductSaleDTO> productSaleDTOs, List<Product> productList) {
        return productList.stream()
                .map(product -> {
                    ProductSaleDTO productSaleDTO = new ProductSaleDTO();
                    productSaleDTO.setId(product.getId());
                    productSaleDTO.setName(product.getName());
                    productSaleDTO.setPrice(product.getPrice());
                    productSaleDTO.setDescription(product.getDescription());
                    productSaleDTO.setDiscount(product.getDiscount());
                    productSaleDTO.setStatus(product.getStatus());
                    productSaleDTO.setQuantity(product.getQuantity());
                    productSaleDTO.setCategoryName(product.getCategory().getName());
                    productSaleDTO.setImgUrl(product.getListImages().isEmpty() ? "" : product.getListImages().get(0).getImgUrl());
                    return productSaleDTO;
                })
                .collect(Collectors.toList());
    }


    @Override
    public List<ProductSaleDTO> getAllProSaleByCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Không Tìm Thấy Category"));

        if (category.getStatus() != 1) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category Không Tồn Tại");
        }
        return getAllActiveAndAvailableProducts().stream()
                .filter(productSaleDTO -> productSaleDTO.getCategoryName().equals(categoryId))
                .collect(Collectors.toList());
    }

}
