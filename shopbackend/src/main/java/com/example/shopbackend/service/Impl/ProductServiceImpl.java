package com.example.shopbackend.service.Impl;

import com.example.shopbackend.controller.Message;
import com.example.shopbackend.entity.Product;
import com.example.shopbackend.repository.ProductRepository;
import com.example.shopbackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    private boolean isValid(String str) {
        return str.matches("^[a-zA-Z\\d\\s\\S]+$");
    }
    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public ResponseEntity<?> createPro(Product createProduct) {
            String errorMessage;
            Message errorResponse;

            // Check if the name of the product is not null and valid
            if (createProduct.getName() == null || !isValid(createProduct.getName())) {
                errorMessage = "Product Không Hợp Lệ Vui Lòng Nhập Lại";
                errorResponse = new Message(errorMessage, TrayIcon.MessageType.ERROR);
                return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
            }

            // Check if a product with the same name already exists
            Product product = productRepository.findByName(createProduct.getName());
            if (product != null) {
                errorMessage = "Trùng Tên Product Vui Lòng Nhập Lại";
                errorResponse = new Message(errorMessage, TrayIcon.MessageType.ERROR);
                return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
            }

            try {
                // Create a new product entity and set its properties
                Product newPro = new Product();
                newPro.setName(createProduct.getName());
                newPro.setStatus(createProduct.getStatus());
                newPro.setPrice(createProduct.getPrice());
                newPro.setDescription(createProduct.getDescription());
                newPro.setDiscount(createProduct.getDiscount());
                newPro.setCreatedAt(createProduct.getCreatedAt());
                newPro.setThumbnail(createProduct.getThumbnail());
                newPro.setQuantity(createProduct.getQuantity());
                newPro.setUpdatedAt(createProduct.getUpdatedAt());
                newPro.setCategory(createProduct.getCategory());

                // Save the new product entity to the database
                productRepository.save(newPro);

                // Get the list of all products after saving the new product
                List<Product> productList = productRepository.findAll();

                // Return a response entity with the list of all products
                return ResponseEntity.ok().body(productList);
            } catch (Exception e) {
                // Return an error message if an exception occurs
                errorMessage = e.getMessage();
                errorResponse = new Message(errorMessage, TrayIcon.MessageType.ERROR);
                return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
            }
        }


    @Override
    public ResponseEntity<Product> editProduct(Product editProduct) {
        return null;
    }

    @Override
    public ResponseEntity<List<Product>> deleteProduct(Long id) {
        return null;
    }

    @Override
    public Product searchAllProduct(Long id) {
        return null;
    }
}
