package com.example.categoryservice.controller;

import com.example.categoryservice.entity.Category;
import com.example.categoryservice.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpStatusCodeException;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/category")
public class CategoryController {
    CategoryServiceImpl categoryService;

    @Autowired
    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping("/creation")
    public String showCategoryInterface(){return "category/creation"; }

    @RequestMapping("/info")
    public String categoryInfo(){
        return "category/info";
    }

    @RequestMapping("/list")
    public String categoryList(){
        return "category/list";
    }

    @RequestMapping("/removing")
    public String categoryRemove(){
        return "category/removing";
    }

    @RequestMapping("/updating")
    public String categoryUpdate(){
        return "category/updating";
    }

    @RequestMapping("/create")
    public ResponseEntity<String> categoryCreate(@RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("parent_id") Integer parent_id) {
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        category.setParent_id(parent_id);
        if(categoryService.createCategory(category)){
            return new ResponseEntity<>("Category created", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Data entry exception", HttpStatus.BAD_REQUEST);
        }
    }

}
