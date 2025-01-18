package com.deval.ecommerce.Backend.infrastructure.adapter.category.impl;

import com.deval.ecommerce.Backend.domain.model.category.Category;
import com.deval.ecommerce.Backend.domain.port.category.ICategoryRepository;
import com.deval.ecommerce.Backend.infrastructure.adapter.category.ICategoryCrudRepository;
import com.deval.ecommerce.Backend.infrastructure.mapper.category.CategoryMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryCrudRepositoryImpl implements ICategoryRepository {
    private final ICategoryCrudRepository iCategoryCrudRepository;
    private final CategoryMapper categoryMapper;

    public CategoryCrudRepositoryImpl(ICategoryCrudRepository iCategoryCrudRepository, CategoryMapper categoryMapper) {
        this.iCategoryCrudRepository = iCategoryCrudRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public Category save(Category category) {
        return categoryMapper.toCategory( iCategoryCrudRepository.save(categoryMapper.toCategoryEntity(category))) ;
    }

    @Override
    public Iterable<Category> findAll() {
        return categoryMapper.toCategoryList(iCategoryCrudRepository.findAll());
    }

    @Override
    public Category findById(Integer id) {
        return categoryMapper.toCategory(iCategoryCrudRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Categoría con id: "+id+ " no existe")
        ));
    }

    @Override
    public void deleteById(Integer id) {
        iCategoryCrudRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Categoría con id: "+id+ " no existe")
        );
        iCategoryCrudRepository.deleteById(id);
    }
}