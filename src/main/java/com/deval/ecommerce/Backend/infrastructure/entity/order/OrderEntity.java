package com.deval.ecommerce.Backend.infrastructure.entity.order;

import com.deval.ecommerce.Backend.domain.model.order.OrderState;
import com.deval.ecommerce.Backend.infrastructure.entity.orderProduct.OrderProductoEntity;
import com.deval.ecommerce.Backend.infrastructure.entity.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @Enumerated(value = EnumType.STRING)
    private OrderState orderState;

    @ManyToOne
    private UserEntity userEntity;

    @OneToMany(mappedBy = "orderEntity", cascade = CascadeType.PERSIST) //creo una orden me inserta esos items
    private List<OrderProductoEntity> orderProducts;
}
