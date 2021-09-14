package com.example.example130921.service.impl;

import com.example.example130921.dao.entity.Order;
import com.example.example130921.dao.repository.OrderRepository;
import com.example.example130921.dto.request.OrderRequest;
import com.example.example130921.dto.response.OrderResponse;
import com.example.example130921.exception.ResourceNotFoundException;
import com.example.example130921.service.AbstractService;
import com.example.example130921.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl extends AbstractService implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Optional<List<OrderResponse>> getAllOrders(){
        List<Order> orders = orderRepository.getAllOrders().orElseThrow(() -> {
            throw new ResourceNotFoundException();
        });
        return Optional.of(orders.stream()
                .map(order -> new OrderResponse(order.getOrderId(),
                                                order.getCustomerId(),
                                                order.getEmployeeId(),
                                                order.getOrderDate()))
                .collect(Collectors.toList()));
    }

    @Override
    public Optional<OrderResponse> getById(int orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> {
            throw new ResourceNotFoundException();
        });
        return Optional.of(new OrderResponse(order.getOrderId(),
                                             order.getCustomerId(),
                                             order.getEmployeeId(),
                                             order.getOrderDate()));
    }

    @Override
    public void add(Order order) {
        orderRepository.add(order);
    }

    @Override
    public void deleteById(int orderId) {
        orderRepository.deleteById(orderId);
    }


}
