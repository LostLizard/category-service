package com.example.categoryservice.entity;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    public BusinessCategory() {
    }

    public static BusinessCategory getDeepBusinessCategory(Category category){
        BusinessCategory businessCategory = new BusinessCategory();
        businessCategory.setDescription(category.getDescription());
        businessCategory.setId(category.getId());
        businessCategory.setName(category.getName());
        List<BusinessCategory> list = category.getSubCategories().stream().map(BusinessCategory::getDeepBusinessCategory).collect(Collectors.toList());
        for (BusinessCategory e : list) {
            businessCategory.getSubCategories().add(e);
        }

        return businessCategory;
    }

    public static BusinessCategory getSurfaceBusinessCategory(Category category){
        BusinessCategory businessCategory = new BusinessCategory();
        businessCategory.setDescription(category.getDescription());
        businessCategory.setId(category.getId());
        businessCategory.setName(category.getName());

        return businessCategory;
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
