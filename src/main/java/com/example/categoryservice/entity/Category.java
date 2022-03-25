package com.example.categoryservice.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.NaturalId;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {

    @Id
    @Column
    @GeneratedValue
    private int id;

    @NaturalId
    @Column
    private String name;

    @Column
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Category parentCategory;

    @OneToMany(mappedBy = "parentCategory", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<Category> subCategories = new HashSet<>();

    public Category(int id, String name, String description, int parent_id) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Category() {
    }

    public Category addSubCategory(Category category){
        this.subCategories.add(category);
        this.subCategories.add(category);
        category.setParentCategory(this);
        return category;
    }

    public void moveCategory(Category newParent) {
        this.getParentCategory().getSubCategories().remove(this);
        this.setParentCategory(newParent);
        newParent.getSubCategories().add(this);
    }

    public Category getParentCategory() { return parentCategory; }

    public void setParentCategory(Category parentCategory) { this.parentCategory = parentCategory; }

    public Set<Category> getSubCategories() { return subCategories; }

    public void setSubCategories(Set<Category> subCategories) { this.subCategories = subCategories; }

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
