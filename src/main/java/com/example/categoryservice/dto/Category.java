package com.example.categoryservice.dto;

import com.example.categoryservice.dao.entity.CategoryEntity;

import java.util.List;
import java.util.stream.Collectors;

public class Category {

    private int id;
    private String name;
    private String description;
    private int parentId;
    private Category parentCategory;
    private List<Category> subCategories;

    public Category(int id, String name, String description, Integer parentId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.parentId = parentId;

    }

    public Category(CategoryEntity category){
        this.id = category.getId();
        this.name = category.getName();
        this.description = category.getDescription();
        this.parentId = category.getParentCategory().getId();
        this.subCategories = category.getSubCategories().stream().map(Category::new).collect(Collectors.toList());

    }

    public static Category replaceEntityOnSurfaceCategory(CategoryEntity categoryEntity){
        Category category = new Category();
        category.setId(categoryEntity.getId());
        category.setName(categoryEntity.getName());
        category.setDescription(categoryEntity.getDescription());
        return category;
    }

    public Category() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public List<Category> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<Category> subCategories) {
        this.subCategories = subCategories;
    }
}
