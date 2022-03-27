package com.example.categoryservice.service;

import com.example.categoryservice.dto.Category;
import com.example.categoryservice.dao.entity.CategoryEntity;
import com.example.categoryservice.exception.EntityNotFoundException;
import com.example.categoryservice.dao.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
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
                .map(Category::replaceEntityOnSurfaceCategory)
                .collect(Collectors.toList());
    }

    @Override
    public void createCategory(String name, String description, Integer parentId) {
        CategoryEntity category = new CategoryEntity();
        category.setName(name);
        category.setDescription(description); // init block

        if (parentId == null) {
            category.setParentCategory(null);
        } else {
            category.setParentCategory(categoryRepository.findById(parentId)
                    .orElseThrow(EntityNotFoundException::new));
        } // exception checking block

        categoryRepository.save(category);
    }

    public void createCategory(Category category){
        createCategory(category.getName(), category.getDescription(), category.getParentCategory().getId());
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id)
                .map(Category::new)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void updateCategory(Integer id, String name, String description, Integer parentId) {
        CategoryEntity category = categoryRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        category.setId(id);
        category.setName(name);
        category.setDescription(description); // init block

        if (parentId == null) {
            category.setParentCategory(null);
        } else {
            category.setParentCategory(categoryRepository.findById(parentId)
                    .orElseThrow(EntityNotFoundException::new));
        } // exception checking block

        categoryRepository.save(category);
    }

    public void updateCategory(Category category, Integer parentId){
        updateCategory(category.getId(), category.getName(), category.getDescription(), parentId);
    }

    @Override
    public void removeCategory(Category category){
        categoryRepository.deleteById(category.getId());
    }

    public void removeCategory(Integer id){
        categoryRepository.deleteById(id);
    }

}
