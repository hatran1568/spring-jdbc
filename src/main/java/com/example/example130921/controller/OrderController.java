package com.example.example130921.controller;

import com.example.example130921.dao.entity.Order;
import com.example.example130921.dto.request.OrderRequest;
import com.example.example130921.service.impl.OrderServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/orders")
@Validated
public class OrderController extends AbstractController<OrderServiceImpl>{


    @GetMapping(value = "")
    public ResponseEntity<?> getOrders(){
        return response(service.getAllOrders());
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return response(service.getById(id));
    }

    @PostMapping(value = "")
    public void add(@Valid @RequestBody OrderRequest orderRequest){
        service.add(orderRequest);
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable int id){
        service.deleteById(id);
    }
}
