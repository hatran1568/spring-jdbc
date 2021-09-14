package com.example.example130921.service.impl;

import com.example.example130921.dao.entity.Customer;
import com.example.example130921.dao.repository.CustomerRepository;
import com.example.example130921.dto.response.CustomerResponse;
import com.example.example130921.exception.ResourceNotFoundException;
import com.example.example130921.service.AbstractService;
import com.example.example130921.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl extends AbstractService implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Optional<List<CustomerResponse>> getCustomers() {
        List<Customer> customers = customerRepository.getAllCustomers().orElseThrow(()->{
            throw new ResourceNotFoundException();
        });
        return Optional.of(customers.stream()
                .map(customer -> new CustomerResponse(customer.getCustomerId(), customer.getCustomerName(), customer.getPhone()))
                .collect(Collectors.toList()));
    }

    public Optional<CustomerResponse> getById(int id){
        Customer customer = customerRepository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException();
        });
        return Optional.of(new CustomerResponse(customer.getCustomerId(), customer.getCustomerName(), customer.getPhone()));
    }


}
