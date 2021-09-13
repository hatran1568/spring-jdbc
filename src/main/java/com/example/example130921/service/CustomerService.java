package com.example.example130921.service;

import com.example.example130921.dao.entity.Customer;
import com.example.example130921.dao.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Optional<List<Customer>> getAllCustomers(){
        return customerRepository.getAllCustomers();
    }

    public Optional<Customer> findById(int id){
        return customerRepository.findById(id);
    }
}
