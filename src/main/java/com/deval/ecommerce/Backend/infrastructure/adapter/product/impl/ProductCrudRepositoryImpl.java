package com.deval.ecommerce.Backend.infrastructure.adapter.product.impl;

import com.deval.ecommerce.Backend.domain.model.product.Product;
import com.deval.ecommerce.Backend.domain.port.product.IProductRepository;
import com.deval.ecommerce.Backend.infrastructure.adapter.product.IProductCrudRepository;
import com.deval.ecommerce.Backend.infrastructure.mapper.product.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ProductCrudRepositoryImpl implements IProductRepository {

    private final IProductCrudRepository iProductCrudRepository;
    private final ProductMapper productMapper;


    @Override
    public Product save(Product product) {
        return productMapper.toProduct( iProductCrudRepository.save(productMapper.toProductEntity(product)));
    }

    @Override
    public Iterable<Product> findAll() {
        return productMapper.toProductList(iProductCrudRepository.findAll());
    }

    @Override
    public Product findById(Integer id) {
        return productMapper.toProduct( iProductCrudRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Producto con " + id + " No existe en BD")
        ));
    }

    @Override
    public void deleteById(Integer id) {
        iProductCrudRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Producto con " + id + " No existe en BD")
        );
        iProductCrudRepository.deleteById(id);
    }
}
