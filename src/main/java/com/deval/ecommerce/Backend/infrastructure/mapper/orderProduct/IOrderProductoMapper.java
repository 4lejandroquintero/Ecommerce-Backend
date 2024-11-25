package com.deval.ecommerce.Backend.infrastructure.mapper.orderProduct;

import com.deval.ecommerce.Backend.domain.model.orderProduct.OrderProduct;
import com.deval.ecommerce.Backend.infrastructure.entity.orderProduct.OrderProductoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IOrderProductoMapper {
    @Mappings(
            {
                @Mapping(source = "id", target = "id"),
                @Mapping(source = "quantity", target = "quantity"),
                @Mapping(source = "price", target = "price"),
                @Mapping(source = "productId", target = "productId"),
            }
    )

    OrderProduct toOrderProduct(OrderProductoEntity orderProductoEntity);
    Iterable<OrderProduct> toOrderProductList(Iterable<OrderProductoEntity> orderProductoEntities);

    @InheritInverseConfiguration
    OrderProductoEntity toOrderProductEntity(OrderProduct orderProduct);
}
