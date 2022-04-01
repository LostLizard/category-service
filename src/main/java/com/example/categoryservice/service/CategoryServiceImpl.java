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
                .map((el) -> {
                    return new Category(el.getId(), el.getName(), el.getDescription());
                })
                .collect(Collectors.toList());
    }

    @Override
    public void createCategory(Category category) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(category.getName());
        categoryEntity.setDescription(category.getDescription()); // init block

        if (category.getParentCategory() == null) {
            categoryEntity.setParentCategory(null);
        } else {
            categoryEntity.setParentCategory(categoryRepository.findById(category.getParentCategory().getId())
                    .orElseThrow(EntityNotFoundException::new));
        } // exception checking block

        categoryRepository.save(categoryEntity);
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id)
                .map(Category::new)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void updateCategory(Category category) {
        CategoryEntity categoryEntity = categoryRepository.findById(category.getId())
                .orElseThrow(EntityNotFoundException::new);
        categoryEntity.setId(category.getId());
        categoryEntity.setName(category.getName());
        categoryEntity.setDescription(category.getDescription());
        // init block

        if (category.getParentCategory().getId() == 0) {
            categoryEntity.setParentCategory(null);
        } else {
            categoryEntity.setParentCategory(categoryRepository.findById(category.getParentCategory().getId())
                    .orElseThrow(EntityNotFoundException::new));
        } // exception checking block

        categoryRepository.save(categoryEntity);
    }

    @Override
    public void removeCategory(Integer id){
        categoryRepository.deleteById(id);
    }

}
