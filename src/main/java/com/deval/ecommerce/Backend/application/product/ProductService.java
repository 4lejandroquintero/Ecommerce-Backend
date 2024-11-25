package com.deval.ecommerce.Backend.application.product;

import com.deval.ecommerce.Backend.domain.model.product.Product;
import com.deval.ecommerce.Backend.domain.port.product.IProductRepository;

public class ProductService {
    private final IProductRepository iProductRepository;

    public ProductService(IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }

    public Product save (Product product) {
        return this.iProductRepository.save(product);
    }

    public Iterable<Product> findAll(){
        return this.iProductRepository.findAll();
    }

    public Product findById (Integer id) {
        return this.iProductRepository.findById(id);
    }

    public void deleteById (Integer id) {
        this.iProductRepository.deleteById(id);
    }
}
