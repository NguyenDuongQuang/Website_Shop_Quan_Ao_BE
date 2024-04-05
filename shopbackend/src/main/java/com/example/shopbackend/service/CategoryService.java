package com.example.shopbackend.service;

import com.example.shopbackend.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> getAll();

    ResponseEntity<?> createCate(Category createCategory);

    ResponseEntity<Category>editCategory(Category editCategory);

    ResponseEntity<List<Category>> deleteCategory(Long id);

    Category searchAllCategory(Long id);
}
