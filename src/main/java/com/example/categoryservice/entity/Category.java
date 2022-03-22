package com.example.categoryservice.entity;

import org.springframework.context.annotation.Primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @Column(name = "id")
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

    @Column(name = "parent_id")
    int parent_id;
}
