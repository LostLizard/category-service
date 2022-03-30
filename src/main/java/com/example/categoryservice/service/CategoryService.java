package com.example.categoryservice.service;

import com.example.categoryservice.dto.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    void createCategory(Category category);

    Category getCategoryById(Integer id);

    void updateCategory(Category category);

    void removeCategory(Integer id);
}
