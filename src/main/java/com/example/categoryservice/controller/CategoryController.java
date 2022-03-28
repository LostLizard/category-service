package com.example.categoryservice.controller;

import com.example.categoryservice.dto.Category;
import com.example.categoryservice.service.CategoryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class CategoryController {
    CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {

        this.categoryService = categoryService;
    }

    @GetMapping("getById")
    public ResponseEntity<Category> getById(@RequestParam Integer id){
        return new ResponseEntity<Category>(categoryService.getCategoryById(id), HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Category>> getAll(){
        return new ResponseEntity<List<Category>>(categoryService.getAllCategories(), HttpStatus.OK);
    }

    @PostMapping("update")
    public ResponseEntity<String> update(@RequestParam Category category, @RequestParam Integer parentId){
        categoryService.updateCategory(category, parentId);
        return new ResponseEntity<String>("Category updated", HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<String> create(@RequestParam Category category){
        categoryService.createCategory(category);
        return new ResponseEntity<String>("Category created", HttpStatus.OK);
    }

    @PostMapping("createById")
    public ResponseEntity<String> createById(@RequestParam Category category){
        System.out.println("вход");
        categoryService.createCategory(category);
        return new ResponseEntity<String>("Category created", HttpStatus.OK);
    }

    @DeleteMapping("remove")
    public ResponseEntity<String> remove(@RequestParam Integer id){
        categoryService.removeCategory(id);
        return new ResponseEntity<String>("Category removed", HttpStatus.OK);
    }

}
