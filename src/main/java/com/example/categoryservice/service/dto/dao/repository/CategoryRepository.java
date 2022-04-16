package com.example.categoryservice.service.dto.dao.repository;

import com.example.categoryservice.service.dto.dao.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer> {
    List<CategoryEntity> findAll();
}
