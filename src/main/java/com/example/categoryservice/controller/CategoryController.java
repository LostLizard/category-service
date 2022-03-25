package com.example.categoryservice.controller;

import com.example.categoryservice.entity.Category;
import com.example.categoryservice.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpStatusCodeException;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

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
