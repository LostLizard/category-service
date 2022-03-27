package com.example.categoryservice.service;

import com.example.categoryservice.dto.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    void createCategory(String name, String description, Integer parentId);

    Category getCategoryById(Integer id);

    void updateCategory(Integer id, String name, String description, Integer parentId);

    void removeCategory(Category category);
}
