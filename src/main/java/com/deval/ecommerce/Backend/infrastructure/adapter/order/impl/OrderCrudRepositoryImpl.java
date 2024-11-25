package com.deval.ecommerce.Backend.infrastructure.adapter.order.impl;

import com.deval.ecommerce.Backend.domain.model.order.Order;
import com.deval.ecommerce.Backend.domain.model.order.OrderState;
import com.deval.ecommerce.Backend.domain.port.order.IOrderRepository;
import com.deval.ecommerce.Backend.infrastructure.adapter.order.IOrderCrudRepository;
import com.deval.ecommerce.Backend.infrastructure.entity.order.OrderEntity;
import com.deval.ecommerce.Backend.infrastructure.entity.user.UserEntity;
import com.deval.ecommerce.Backend.infrastructure.mapper.order.IOrderMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class OrderCrudRepositoryImpl implements IOrderRepository {

    private final IOrderMapper iOrderMapper;
    private final IOrderCrudRepository iOrderCrudRepository;

    @Override
    public Order save(Order order) {
        OrderEntity orderEntity = iOrderMapper.toOrderEntity(order);

        orderEntity.getOrderProducts().forEach(
            orderProductoEntity ->  orderProductoEntity.setOrderEntity(orderEntity)
        );

        return iOrderMapper.toOrder( iOrderCrudRepository.save(orderEntity));
    }

    @Override
    public Order findById(Integer id) {
        return iOrderMapper.toOrder( iOrderCrudRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Orden con id " + id + " No existe en la BD")
        ));
    }

    @Override
    public Iterable<Order> findAll() {
        return iOrderMapper.toOrderList(iOrderCrudRepository.findAll());
    }

    @Override
    public Iterable<Order> findByUserId(Integer userId) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userId);
        return iOrderMapper.toOrderList(iOrderCrudRepository.findByUserEntity(userEntity));
    }

    @Override
    public void updateStateById(Integer id, String state) {
        if(state.equals(OrderState.CANCELLED)){
            iOrderCrudRepository.updateStateById(id, OrderState.CANCELLED);
        }else{
            iOrderCrudRepository.updateStateById(id, OrderState.CONFIRMED);
        }
    }
}
