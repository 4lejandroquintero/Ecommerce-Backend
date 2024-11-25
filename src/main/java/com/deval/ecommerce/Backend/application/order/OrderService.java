package com.deval.ecommerce.Backend.application.order;

import com.deval.ecommerce.Backend.domain.model.order.Order;
import com.deval.ecommerce.Backend.domain.port.order.IOrderRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderService {

    private final IOrderRepository iOrderRepository;

    public Order save(Order order){
        return this.iOrderRepository.save(order);
    }

    public Iterable<Order> findAll(){
        return this.iOrderRepository.findAll();
    }

    public Iterable<Order> findByUserId(Integer userId) {
        return this.iOrderRepository.findByUserId(userId);
    }

    public void updateStateById(Integer id, String state) {
        this.iOrderRepository.updateStateById(id, state);
    }

    public Order findById(Integer id){
        return this.iOrderRepository.findById(id);
    }
}
