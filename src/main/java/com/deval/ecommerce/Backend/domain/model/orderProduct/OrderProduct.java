package com.deval.ecommerce.Backend.domain.model.orderProduct;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderProduct {
    private Integer id;
    private BigDecimal quantity;
    private BigDecimal price;
    private Integer productId;

    public BigDecimal getTotalItem(){
        return this.price.multiply(quantity);
    }

}

