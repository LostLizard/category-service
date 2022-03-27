package com.example.categoryservice.controller;

import com.example.categoryservice.dto.Category;
import com.example.categoryservice.service.CategoryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


//TODO почитать http 1.2, подергать сервис,
@RestController
@RequestMapping("/category")
public class CategoryController {
    CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {

        this.categoryService = categoryService;
    }

    @GetMapping("getCategoryById")
    public ResponseEntity<Category> getCategoryById(@RequestParam("id") Integer id){
        return new ResponseEntity<Category>(categoryService.getCategoryById(id), HttpStatus.OK);
    }

    @PutMapping("updateCategory")
    public ResponseEntity<String> updateCategory(@RequestParam("category") Category category, @RequestParam("parentId") Integer parentId){
        return null;
    }
}
