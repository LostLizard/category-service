package com.example.categoryservice.service;

import com.example.categoryservice.entity.BusinessCategory;
import com.example.categoryservice.entity.Category;
import com.example.categoryservice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class  CategoryServiceImpl implements CategoryService{
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<BusinessCategory> getAllCategories() {
        List<BusinessCategory> list = new ArrayList<>();
        for (Category e : categoryRepository.findAll()) {
            BusinessCategory businessCategory = new BusinessCategory();
            businessCategory.setId(e.getId());
            businessCategory.setName(e.getName());
            businessCategory.setDescription(e.getDescription());

            list.add(businessCategory);
        }

        return list;
    }

    @Override
    public void createCategory(String name, String description, Integer parentId) {
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        category.setParentCategory(categoryRepository.findById(parentId).orElse(null));

        categoryRepository.save(category);
    }

    @Override
    public BusinessCategory getCategoryById(Integer id) {
        BusinessCategory businessCategory = new BusinessCategory();
        Category category = categoryRepository.findById(id).orElse(null);
        businessCategory.setName(category.getName());
        businessCategory.setId(category.getId());
        businessCategory.setDescription(category.getDescription());

        // надо добавить обход в глубину дочерних элементов
        return businessCategory;
    }

    @Override
    public void updateCategoryById(Integer id, String name, String description, Integer parentId) {
        Category category = new Category();
        category.setId(id);
        category.setName(name);
        category.setDescription(description);
        category.setParentCategory(categoryRepository.findById(parentId).orElse(null));
        categoryRepository.save(category);
    }


}
