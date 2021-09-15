package com.example.example130921.dao.repository;

import com.example.example130921.dao.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    Optional<List<Customer>> getAllCustomers();

    Optional<Customer> findById(int id);

    List<Integer> getIdList();
}
