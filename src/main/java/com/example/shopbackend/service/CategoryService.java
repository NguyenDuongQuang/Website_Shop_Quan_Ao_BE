package com.example.shopbackend.service;

import com.example.shopbackend.entity.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {

    List<Category> getAll();

    ResponseEntity<?> createCate(Category createCategory);

    ResponseEntity<Category>editCategory(Category editCategory);

    ResponseEntity<List<Category>> deleteCategory(Long id);
    ResponseEntity<List<Category>> deleteCategoryNgungKinhDoanh(Long id);

    Category searchAllCategory(Long id);

}
