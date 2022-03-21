package com.example.categoryservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {


    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/category-create")
    public String showCategoryInterface(){

        return "category-create";

    }

    @RequestMapping("/categoryCreate")
    public String createCategory(HttpServletRequest request, Model model){

        model.addAttribute("name", request.getParameter("name"));
        return "test";

    }

    @RequestMapping("/category-info")
    public  String categoryInfo(){
        return "category-info";
    }

    @RequestMapping("/category-list")
    public  String categoryList(){
        return "category-list";
    }

    @RequestMapping("/category-remove")
    public  String categoryRemove(){
        return "category-remove";
    }

    @RequestMapping("/category-update")
    public  String categoryUpdate(){
        return "category-update";
    }

}
