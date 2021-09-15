package com.example.example130921.service;

import com.example.example130921.dto.response.CustomerResponse;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Optional<List<CustomerResponse>> getCustomers();
    Optional<CustomerResponse> getById(int id);
    boolean isValid(int customerId);
}
