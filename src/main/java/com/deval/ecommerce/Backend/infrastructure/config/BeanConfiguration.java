package com.deval.ecommerce.Backend.infrastructure.config;

import com.deval.ecommerce.Backend.application.category.CategoryService;
import com.deval.ecommerce.Backend.application.order.OrderService;
import com.deval.ecommerce.Backend.application.product.ProductService;
import com.deval.ecommerce.Backend.application.user.UserService;
import com.deval.ecommerce.Backend.domain.port.category.ICategoryRepository;
import com.deval.ecommerce.Backend.domain.port.order.IOrderRepository;
import com.deval.ecommerce.Backend.domain.port.product.IProductRepository;
import com.deval.ecommerce.Backend.domain.port.user.IUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public UserService userService(IUserRepository iUserRepository){
        return new UserService(iUserRepository);
    }

    @Bean
    public CategoryService categoryService(ICategoryRepository iCategoryRepository){
        return new CategoryService(iCategoryRepository);
    }

    @Bean
    public ProductService productService(IProductRepository iProductRepository){
        return new ProductService(iProductRepository);
    }

    @Bean
    public OrderService orderService(IOrderRepository iOrderRepository){
        return new OrderService(iOrderRepository);
    }
}
