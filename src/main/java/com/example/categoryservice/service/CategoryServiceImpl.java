package com.example.categoryservice.service;

import com.example.categoryservice.entity.Category;
import com.example.categoryservice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public boolean createCategory(Category category) {
        return false;
    }

    @Override
    public Category getCategory() {
        return null;
    }


}
