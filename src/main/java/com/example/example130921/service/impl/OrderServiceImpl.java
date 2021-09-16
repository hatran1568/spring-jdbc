package com.example.example130921.service.impl;

import com.example.example130921.dao.entity.Order;
import com.example.example130921.dao.repository.OrderRepository;
import com.example.example130921.dto.request.OrderRequest;
import com.example.example130921.dto.response.OrderResponse;
import com.example.example130921.exception.ConstraintViolationException;
import com.example.example130921.exception.RequestParamInvalidException;
import com.example.example130921.exception.ResourceNotFoundException;
import com.example.example130921.service.AbstractService;
import com.example.example130921.service.CustomerService;
import com.example.example130921.service.EmployeeService;
import com.example.example130921.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl extends AbstractService implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EmployeeService employeeService;

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
    public void add(OrderRequest orderRequest) {
//        String message = validator.validateRequestThenReturnMessage(orderRequest);
//        if (!StringUtils.isEmpty(message)) {
//            throw new RequestParamInvalidException(message);
//        }
        int reqCustomerId = orderRequest.getCustomerId();
        int reqEmployeeId = orderRequest.getEmployeeId();
        if (!customerService.isValid(reqCustomerId) && employeeService.isValid(reqEmployeeId)) {
            orderRepository.add(modelMapper.map(orderRequest, Order.class));
        }
    }

    @Override
    public void deleteById(int orderId) {
        orderRepository.deleteById(orderId);
    }


}
