package com.deval.ecommerce.Backend.infrastructure.config;

import com.deval.ecommerce.Backend.application.UploadFile;
import com.deval.ecommerce.Backend.application.category.CategoryService;
import com.deval.ecommerce.Backend.application.order.OrderService;
import com.deval.ecommerce.Backend.application.product.ProductService;
import com.deval.ecommerce.Backend.application.security.RegistrationService;
import com.deval.ecommerce.Backend.application.user.UserService;
import com.deval.ecommerce.Backend.domain.port.category.ICategoryRepository;
import com.deval.ecommerce.Backend.domain.port.order.IOrderRepository;
import com.deval.ecommerce.Backend.domain.port.product.IProductRepository;
import com.deval.ecommerce.Backend.domain.port.user.IUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

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
    public ProductService productService(IProductRepository iProductRepository, UploadFile uploadFile){
        return  new ProductService(iProductRepository, uploadFile);
    }
    @Bean
    public OrderService orderService(IOrderRepository iOrderRepository){
        return new OrderService(iOrderRepository);
    }

    @Bean
    public UploadFile uploadFile(){
        return new UploadFile();
    }

    @Bean
    public RegistrationService registrationService(IUserRepository iUserRepository) {
        return new RegistrationService(iUserRepository);
    }


}
