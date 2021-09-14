package com.example.example130921.dao.repository.impl;

import com.example.example130921.dao.entity.Order;
import com.example.example130921.dao.repository.AbstractRepository;
import com.example.example130921.dao.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepositoryImpl extends AbstractRepository implements OrderRepository {

    @Autowired
    @Qualifier("dataSource")
    protected DataSource dataSource;

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    @Override
    public Optional<List<Order>> getAllOrders() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ").append(attributeNamesForSelect(Order.class));
        sql.append(" FROM ").append(getSimpleNameTable(Order.class));
        List<Order> orders = jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(Order.class));
        return Optional.ofNullable(orders);
    }

    @Override
    public Optional<Order> findById(int id) {

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ").append(attributeNamesForSelect(Order.class));
        sql.append(" FROM ").append(getSimpleNameTable(Order.class));
        sql.append(" WHERE id = :id");
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        Order order = jdbcTemplate.queryForObject(sql.toString(), Order.class, namedParameters);
        return Optional.ofNullable(order);

    }

    @Override
    public void add(Order order) {

    }

    @Override
    public void deleteById() {

    }
}
