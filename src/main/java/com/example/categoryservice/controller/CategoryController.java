package com.example.categoryservice.controller;

import com.example.categoryservice.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/category")
public class CategoryController {
    CategoryServiceImpl categoryService;

    @Autowired
    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping("/create")
    public String showCategoryInterface(){return "category/create"; }

    @RequestMapping("/info")
    public  String categoryInfo(){
        return "category/info";
    }

    @RequestMapping("/list")
    public  String categoryList(){
        return "category/list";
    }

    @RequestMapping("/remove")
    public  String categoryRemove(){
        return "category/remove";
    }

    @RequestMapping("/update")
    public  String categoryUpdate(){
        return "category/update";
    }


}
