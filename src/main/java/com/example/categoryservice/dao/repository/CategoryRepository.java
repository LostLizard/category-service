package com.example.categoryservice.dao.repository;

import com.example.categoryservice.dao.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer> {

    List<CategoryEntity> findAll();

}
