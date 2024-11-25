package com.deval.ecommerce.Backend.infrastructure.entity.orderProduct;

import com.deval.ecommerce.Backend.infrastructure.entity.order.OrderEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "order_products")
public class OrderProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private BigDecimal quantity;
    private BigDecimal price;
    private Integer productId;

    @ManyToOne
    private OrderEntity orderEntity;
}
