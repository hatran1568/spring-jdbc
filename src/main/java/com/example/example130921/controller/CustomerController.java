package com.example.example130921.controller;

import com.example.example130921.dao.entity.Customer;
import com.example.example130921.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController extends AbstractController<CustomerService>{
    @Autowired
    private CustomerService service;

    @GetMapping("")
    public List<Customer> getAllCustomers(){
        return service.getAllCustomers().get();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable int id){
        return service.findById(id).get();
    }
}
