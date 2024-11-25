package com.deval.ecommerce.Backend.domain.port.category;

import com.deval.ecommerce.Backend.domain.model.category.Category;

public interface ICategoryRepository {
    Category save(Category category);
    Iterable<Category> findAll();
    Category findById(Integer id);
    void deleteById(Integer id);
}
