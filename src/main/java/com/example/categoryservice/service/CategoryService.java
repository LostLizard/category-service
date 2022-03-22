package com.example.categoryservice.service;

import com.example.categoryservice.entity.Category;

import java.util.List;

public interface CategoryService {

    public List<Category> getAllCategories();

    public boolean createCategory(Category category);

    public Category getCategory();
}
