package com.example.example130921.service;

import com.example.example130921.dao.entity.Order;
import com.example.example130921.dao.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Optional<List<Order>> getAllOrders(){
        return orderRepository.getAllOrders();
    }

    public Optional<Order> findById(int id){
        return orderRepository.findById(id);
    }

    public void add(Order order){
        orderRepository.add(order);
    }
}
