package com.example.categoryservice.controller;

import com.example.categoryservice.service.dto.Category;
import com.example.categoryservice.service.CategoryServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/category")
public class CategoryController {
    CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {

        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Category>> getAll(){
        return ResponseEntity.of(Optional.of(categoryService.getAllCategories()));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Category> get(@PathVariable Integer id){
        return ResponseEntity.of(Optional.of(categoryService.getCategoryById(id)));
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestParam Category category){
        categoryService.updateCategory(category);
        return ResponseEntity.of(Optional.of("Category updated"));
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestParam Category category){
        categoryService.createCategory(category);
        return ResponseEntity.of(Optional.of("Category created"));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> remove(@PathVariable Integer id){
        categoryService.removeCategory(id);
        return ResponseEntity.of(Optional.of("Category removed"));
    }

}
