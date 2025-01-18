package com.deval.ecommerce.Backend.infrastructure.adapter.order;

import com.deval.ecommerce.Backend.domain.model.order.OrderState;
import com.deval.ecommerce.Backend.infrastructure.entity.order.OrderEntity;
import com.deval.ecommerce.Backend.infrastructure.entity.user.UserEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface IOrderCrudRepository extends CrudRepository<OrderEntity, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE OrderEntity o SET o.orderState = :state WHERE o.id = :id")
    void updateStateById(Integer id, OrderState state);

    Iterable<OrderEntity> findByUserEntity(UserEntity userEntity);
}