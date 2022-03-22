package com.example.categoryservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/category")
public class CategoryController {
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
