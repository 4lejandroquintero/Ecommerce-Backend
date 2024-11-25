package com.deval.ecommerce.Backend.infrastructure.adapter.category;

import com.deval.ecommerce.Backend.infrastructure.entity.category.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryCrudRepository extends CrudRepository<CategoryEntity, Integer> {
}
