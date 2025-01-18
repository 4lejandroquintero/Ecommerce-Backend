package com.deval.ecommerce.Backend.domain.port.product;

import com.deval.ecommerce.Backend.domain.model.product.Product;

public interface IProductRepository {
    Product save (Product product);
    Iterable<Product> findAll();
    Product findById(Integer id);
    void deleteById(Integer id);
}

