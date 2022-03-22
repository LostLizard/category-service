package com.example.categoryservice.entity;

import org.hibernate.annotations.NaturalId;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @Column(name = "id")
    @GeneratedValue
    int id;

    @NaturalId
    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

    public Category(int id, String name, String description, int parent_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.parent_id = parent_id;
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

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    @Column(name = "parent_id")
    int parent_id;
}
