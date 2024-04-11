package com.example.shopbackend.service.Impl;

import com.example.shopbackend.controller.Message;
import com.example.shopbackend.entity.Category;
import com.example.shopbackend.entity.Product;
import com.example.shopbackend.repository.CategoryRepository;
import com.example.shopbackend.repository.ProductRepository;
import com.example.shopbackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

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
            if (createProduct.getName() == null || !isValid(createProduct.getName())) {
                errorMessage = "Product Không Hợp Lệ Vui Lòng Nhập Lại";
                errorResponse = new Message(errorMessage, TrayIcon.MessageType.ERROR);
                return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
            }
            Product product = productRepository.findByName(createProduct.getName());
            if (product != null) {
                errorMessage = "Trùng Tên Product Vui Lòng Nhập Lại";
                errorResponse = new Message(errorMessage, TrayIcon.MessageType.ERROR);
                return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
            }

            try {
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
                productRepository.save(newPro);
                System.out.println("Thêm Thành Công");
                List<Product> productList = productRepository.findAll();
                return ResponseEntity.ok().body(productList);
            } catch (Exception e) {
                errorMessage = e.getMessage();
                errorResponse = new Message(errorMessage, TrayIcon.MessageType.ERROR);
                return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
            }
        }


    @Override
    public ResponseEntity<Product> editProduct(Product editProduct) {
        String errorMessage;
        Message errorResponse;

        try {
            if (editProduct.getName() == null || !isValid(editProduct.getName())) {
                errorMessage = "Nhập Không Đúng Vui Lòng Nhập Lại";
                errorResponse = new Message(errorMessage, TrayIcon.MessageType.ERROR);
                return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
            }

            Product existingProduct = productRepository.findByName(editProduct.getName());
            if (existingProduct != null && !existingProduct.getId().equals(editProduct.getId())) {
                errorMessage = "Trùng Product Vui Lòng Nhập Lại";
                errorResponse = new Message(errorMessage, TrayIcon.MessageType.ERROR);
                return new ResponseEntity(errorResponse, HttpStatus.CONFLICT);
            }

            Optional<Product> optionalProduct = productRepository.findById(editProduct.getId());
            if (optionalProduct.isPresent()) {
                Product product = optionalProduct.get();
                    product.setName(editProduct.getName());
                    product.setStatus(editProduct.getStatus());
                    product.setPrice(editProduct.getPrice());
                    product.setDescription(editProduct.getDescription());
                    product.setDiscount(editProduct.getDiscount());
                    product.setCreatedAt(editProduct.getCreatedAt());
                    product.setThumbnail(editProduct.getThumbnail());
                    product.setQuantity(editProduct.getQuantity());
                    product.setUpdatedAt(editProduct.getUpdatedAt());
                    Category category=new Category();
                    category.setId(editProduct.getCategory().getId());
                    category.setName(editProduct.getCategory().getName());
                    category.setStatus(editProduct.getCategory().getStatus());
                    product.setCategory(category);
                    productRepository.save(product);
                    System.out.println("Sửa Thành Công");
                    return ResponseEntity.ok(product);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            errorMessage = e.getMessage();
            errorResponse = new Message(errorMessage, TrayIcon.MessageType.ERROR);
            return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }




    @Override
    public ResponseEntity<List<Product>> deleteProduct(Long id) {
        try{
            Optional<Product> optionalProduct=productRepository.findById(id);
            if(optionalProduct.isPresent()){
                productRepository.deleteById(id);
                List<Product> productList = productRepository.findAll();
                return ResponseEntity.ok(productList);
            }else {
                return ResponseEntity.notFound().build();
            }

        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

    }

    @Override
    public Product searchAllProduct(Long id) {
        return(Product) productRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Product Không Tồn Tại"));
    }
}
