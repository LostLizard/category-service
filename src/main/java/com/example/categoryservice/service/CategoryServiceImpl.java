package com.example.categoryservice.service;

import com.example.categoryservice.dto.Category;
import com.example.categoryservice.dao.entity.CategoryEntity;
import com.example.categoryservice.exception.EntityNotFoundException;
import com.example.categoryservice.dao.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class  CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(Category::new) //TODO передалать на неглублокое копиравание
                .collect(Collectors.toList());
    }

    @Override
    public void createCategory(String name, String description, Integer parentId) {
        CategoryEntity category = new CategoryEntity();
        category.setName(name);
        category.setDescription(description);
        category.setParentCategory(categoryRepository.findById(parentId).orElse(null)); //TODO смотри на updateCategory

        categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id)
                .map(Category::new)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void updateCategoryById(Integer id, String name, String description, Integer parentId) {
        CategoryEntity category = new CategoryEntity(); //TODO найти по id Category, поменять поля и сохранить
        category.setId(id);
        category.setName(name);
        category.setDescription(description);

        if (parentId == null) {
            category.setParentCategory(null);
        } else {
            category.setParentCategory(categoryRepository.findById(parentId).orElseThrow(EntityNotFoundException::new));
        }

        categoryRepository.save(category);
    }

    //TODO реализовать remove



}
