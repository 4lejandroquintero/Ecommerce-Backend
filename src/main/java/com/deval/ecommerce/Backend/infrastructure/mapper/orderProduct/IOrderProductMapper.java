package com.deval.ecommerce.Backend.infrastructure.mapper.orderProduct;

import org.mapstruct.InheritInverseConfiguration;
import com.deval.ecommerce.Backend.infrastructure.entity.orderProduct.OrderProductEntity;
import com.deval.ecommerce.Backend.domain.model.orderProduct.OrderProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IOrderProductMapper {
    @Mappings(
            {
                    @Mapping(source = "id", target = "id"),
                    @Mapping(source = "quantity", target = "quantity"),
                    @Mapping(source = "price", target = "price"),
                    @Mapping(source = "productId", target = "productId"),
            }
    )
    OrderProduct toOrderProduct(OrderProductEntity orderProductEntity);
    Iterable<OrderProduct> toOrderProductList(Iterable<OrderProductEntity> orderProductEntities);

    @InheritInverseConfiguration
    OrderProductEntity toOrderProductEntity(OrderProduct orderProduct);
}
