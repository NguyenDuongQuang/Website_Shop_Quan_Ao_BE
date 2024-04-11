package com.example.shopbackend.controller;

import com.example.shopbackend.entity.Category;
import com.example.shopbackend.repository.CategoryRepository;
import com.example.shopbackend.service.CategoryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategotyController {
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/get-all")
    public ResponseEntity<?> getAllCategory(){
        return ResponseEntity.ok().body(categoryService.getAll());
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCategory(@RequestBody Category category) throws Exception{
        return ResponseEntity.ok().body(categoryService.createCate(category));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCategory(@RequestBody Category category) throws Exception{
        return ResponseEntity.ok().body(categoryService.editCategory(category));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<Category>>deleteCategory(@PathVariable("id") Long id){
        return categoryService.deleteCategory(id);
    }
    @DeleteMapping("/deleteNgung/{id}")
    public ResponseEntity<List<Category>>deleteCategoryNgungKinhDoanh(@PathVariable("id") Long id){
        return categoryService.deleteCategory(id);
    }

    @GetMapping("search/{id}")
    public ResponseEntity<?>search(@PathVariable @Positive Long id){
        return ResponseEntity.ok().body(categoryService.searchAllCategory(id));
    }

}
