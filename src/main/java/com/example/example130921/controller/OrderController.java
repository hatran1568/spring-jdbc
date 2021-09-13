package com.example.example130921.controller;

import com.example.example130921.dao.entity.Order;
import com.example.example130921.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController extends AbstractController<OrderService>{

    @Autowired
    private OrderService service;

    @GetMapping(value = "")
    public List<Order> getOrders(){
        return service.getAllOrders().get();
    }

    @PostMapping(value = "")
    public void add(@RequestBody Order order){
        service.add(order);
    }
}
