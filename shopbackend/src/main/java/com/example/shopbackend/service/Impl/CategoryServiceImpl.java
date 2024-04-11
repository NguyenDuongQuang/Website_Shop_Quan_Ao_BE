package com.example.shopbackend.service.Impl;


import com.example.shopbackend.controller.Message;
import com.example.shopbackend.entity.Category;
import com.example.shopbackend.entity.Product;
import com.example.shopbackend.repository.CategoryRepository;
import com.example.shopbackend.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.awt.*;
import java.util.List;
import java.util.Optional;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;
    private boolean isValid(String str) {
        return str.matches("^[a-zA-Z\\d\\s\\S]+$");
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public ResponseEntity<?> createCate(Category createCategory) {
        String errorMessage;
        Message errorResponse;
        if (createCategory.getName() == null || !isValid(createCategory.getName())) {
            errorMessage = "Category Không Hợp Lệ";
            errorResponse = new Message(errorMessage, TrayIcon.MessageType.ERROR);
            return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
        }
        Category category = categoryRepository.findByName(createCategory.getName());
        if (category != null) {
            errorMessage = "Trùng Category";
            errorResponse = new Message(errorMessage, TrayIcon.MessageType.ERROR);
            return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
        }
        Category newCategory = new Category();
        try {
            newCategory.setName(createCategory.getName());
            newCategory.setStatus(1);
            categoryRepository.save(newCategory);
            List<Category> categories = categoryRepository.findAll();
            return ResponseEntity.ok().body(categories);
        } catch (Exception e) {
            return new ResponseEntity(new Message(e.getMessage(), TrayIcon.MessageType.ERROR), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Category> editCategory(Category editCategory) {
        String errorMessage;
        Message errorResponse;

        try {
            if (editCategory.getName() == null || !isValid(editCategory.getName())) {
                errorMessage = "Nhập Không Đúng !";
                errorResponse = new Message(errorMessage, TrayIcon.MessageType.ERROR);
                return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
            }

            Category existingCategory = categoryRepository.findByName(editCategory.getName());
            if (existingCategory != null && !existingCategory.getId().equals(editCategory.getId())) {
                errorMessage = "Trùng Loại Category !";
                errorResponse = new Message(errorMessage, TrayIcon.MessageType.ERROR);
                return new ResponseEntity(errorResponse, HttpStatus.CONFLICT);
            }

            Optional<Category> optionalCategory = categoryRepository.findById(editCategory.getId());
            if (optionalCategory.isPresent()) {
                Category category = optionalCategory.get();
                category.setName(editCategory.getName());
                category.setStatus(editCategory.getStatus());
                categoryRepository.save(category);
                System.out.println("Sửa Thành Công");
                return ResponseEntity.ok(category);

            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(new Message("Category Không Hợp Lệ !", TrayIcon.MessageType.ERROR), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity(new Message(e.getMessage(), TrayIcon.MessageType.ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    @Override
    public ResponseEntity<List<Category>> deleteCategory(Long id) {
        try {
            Optional<Category> optionalCategory = categoryRepository.findById(id);
            if (optionalCategory.isPresent()) {
                categoryRepository.deleteById(id);
                List<Category> categories = categoryRepository.findAll();
                return ResponseEntity.ok(categories);
            } else {
                return ResponseEntity.notFound().build();
            }

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @Override
    public ResponseEntity<List<Category>> deleteCategoryNgungKinhDoanh(Long id) {
        try {
            Optional<Category> optionalCategory = categoryRepository.findById(id);
            if (optionalCategory.isPresent()) {
                Category category=optionalCategory.get();
                category.setStatus(0);
                categoryRepository.save(category);
                List<Category> categories = categoryRepository.findAll();
                return ResponseEntity.ok(categories);
            } else {
                return ResponseEntity.notFound().build();
            }

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public Category searchAllCategory(Long id) {
        return (Category) categoryRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Category Không Tồn Tại"));
    }
}
