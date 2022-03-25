package com.example.categoryservice.entity;

import java.util.Set;

public class BusinessCategory {
    private int id;
    private String name;
    private String description;
    private int parentId;
    private BusinessCategory parentCategory;
    private Set<BusinessCategory> subCategories;

    public BusinessCategory(int id, String name, String description, BusinessCategory parentCategory, Set<BusinessCategory> subCategories) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.parentCategory = parentCategory;
        this.subCategories = subCategories;
    }

    public BusinessCategory(Category category) {
        id = category.getId();
        name = category.getName();
        description = category.getDescription();
        parentId = category.getParentCategory().getId();
    }

    public BusinessCategory() {
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

    public BusinessCategory getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(BusinessCategory parentCategory) {
        this.parentCategory = parentCategory;
    }

    public Set<BusinessCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(Set<BusinessCategory> subCategories) {
        this.subCategories = subCategories;
    }
}
