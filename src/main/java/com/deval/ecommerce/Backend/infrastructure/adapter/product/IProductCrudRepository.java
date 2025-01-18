package com.deval.ecommerce.Backend.infrastructure.adapter.product;

import com.deval.ecommerce.Backend.infrastructure.entity.product.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface IProductCrudRepository extends CrudRepository<ProductEntity, Integer> {
}

