package com.deval.ecommerce.Backend.domain.port.order;

import com.deval.ecommerce.Backend.domain.model.order.Order;

public interface IOrderRepository {
    Order save (Order order);
    Order findById (Integer id);
    Iterable<Order> findAll();
    Iterable<Order> findByUserId(Integer userId);
    void updateStateById(Integer id, String state);
}
