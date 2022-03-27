package com.example.categoryservice.controller;

import com.example.categoryservice.service.CategoryServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


//TODO почитать http 1.2, подергать сервис,
@Controller
@RequestMapping("/category")
public class CategoryController {
    CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/creation")
    public String showCategoryInterface(){return "category/creation"; }

    @GetMapping("/info")
    public String categoryInfo(){
        return "category/info";
    }

    @GetMapping("/list")
    public String categoryList(){
        return "category/list";
    }

    @GetMapping("/removing")
    public String categoryRemove(){
        return "category/removing";
    }

    @GetMapping("/updating")
    public String categoryUpdating(){
        return "category/updating";
    }

}
