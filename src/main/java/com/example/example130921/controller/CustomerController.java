package com.example.example130921.controller;

import com.example.example130921.dao.entity.Customer;
import com.example.example130921.service.CustomerService;
import com.example.example130921.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController extends AbstractController<CustomerService>{

    @GetMapping("")
    public ResponseEntity<?> getAllCustomers(){
        return response(service.getCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return response(service.getById(id));
    }
}
