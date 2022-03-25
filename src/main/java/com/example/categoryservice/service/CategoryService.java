package com.example.categoryservice.service;

import com.example.categoryservice.entity.BusinessCategory;
import com.example.categoryservice.entity.Category;

import java.util.List;

public interface CategoryService {

    public List<BusinessCategory> getAllCategories();

    public void createCategory(String name, String description, Integer parentId);

    public BusinessCategory getCategoryById(Integer id);

}
