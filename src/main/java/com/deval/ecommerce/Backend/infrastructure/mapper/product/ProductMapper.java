package com.deval.ecommerce.Backend.infrastructure.mapper.product;

import com.deval.ecommerce.Backend.domain.model.product.Product;
import com.deval.ecommerce.Backend.domain.model.user.User;
import com.deval.ecommerce.Backend.infrastructure.entity.product.ProductEntity;
import com.deval.ecommerce.Backend.infrastructure.entity.user.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mappings(
            {
                    @Mapping(source = "id", target = "id"),
                    @Mapping(source = "name", target = "name"),
                    @Mapping(source = "code", target = "code"),
                    @Mapping(source = "description", target = "description"),
                    @Mapping(source = "urlImage", target = "urlImage"),
                    @Mapping(source = "price", target = "price"),
                    @Mapping(source = "dateCreated", target = "dateCreated"),
                    @Mapping(source = "dateUpdated", target = "dateUpdated"),
                    @Mapping(source = "userEntity.id", target = "userId"),
                    @Mapping(source = "categoryEntity.id", target = "categoryId"  )

            }
    )

    Product toProduct(ProductEntity productEntity);
    Iterable<Product>  toProductList( Iterable<ProductEntity> productEntities);

    @InheritInverseConfiguration
    ProductEntity toProductEntity(Product product);
}