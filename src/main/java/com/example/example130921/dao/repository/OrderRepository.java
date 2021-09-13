package com.example.example130921.dao.repository;

import com.example.example130921.dao.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository {
    Optional<List<Order>> getAllOrders();

    Optional<Order> findById();

    void add();

    void deleteById();

}
