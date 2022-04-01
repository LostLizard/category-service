package com.example.categoryservice.dao.entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//TODO исследовать n+1 trouble query
@Entity
public class CategoryEntity {
    // fields
    @Id
    @Column
    @GeneratedValue
    private int id;

    @NaturalId
    @Column
    private String name;

    @Column
    private String description;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private CategoryEntity parentCategory;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "parentCategory", cascade = {CascadeType.ALL})
    private Set<CategoryEntity> subCategories = new HashSet<>();

    //constructors
    public CategoryEntity(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public CategoryEntity() {
    }

    //methods
    public CategoryEntity addSubCategory(CategoryEntity category){
        this.subCategories.add(category);
        this.subCategories.add(category);
        category.setParentCategory(this);
        return category;
    }

    public void replaceCategoryParent(CategoryEntity newParent) {
        this.getParentCategory().getSubCategories().remove(this);
        this.setParentCategory(newParent);
        newParent.getSubCategories().add(this);
    }

    //getters and setters
    public CategoryEntity getParentCategory() { return parentCategory; }

    public void setParentCategory(CategoryEntity parentCategory) { this.parentCategory = parentCategory; }

    public Set<CategoryEntity> getSubCategories() { return subCategories; }

    public void setSubCategories(Set<CategoryEntity> subCategories) { this.subCategories = subCategories; }

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

}
