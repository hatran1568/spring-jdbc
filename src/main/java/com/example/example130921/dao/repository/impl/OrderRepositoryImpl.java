package com.example.example130921.dao.repository.impl;

import com.example.example130921.dao.entity.Order;
import com.example.example130921.dao.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

public class OrderRepositoryImpl implements OrderRepository {

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    @Override
    public Optional<List<Order>> getAllOrders() {
        String sql = "SELECT order_id, customer_id, employee_id, order_date FROM order";
        List<Order> orders = jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(Order.class));
        return Optional.ofNullable(orders);
    }

    @Override
    public Optional<Order> findById() {
        return Optional.empty();
    }

    @Override
    public void add() {

    }

    @Override
    public void deleteById() {

    }
}
