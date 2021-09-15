package com.example.example130921.dao.repository.impl;

import com.example.example130921.dao.entity.Customer;
import com.example.example130921.dao.repository.AbstractRepository;
import com.example.example130921.dao.repository.CustomerRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepositoryImpl extends AbstractRepository implements CustomerRepository {
    @Override
    public Optional<List<Customer>> getAllCustomers() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ").append(attributeNamesForSelect(Customer.class));
        sql.append(" FROM ").append(getSimpleNameTable(Customer.class));
        List<Customer> customers = jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(Customer.class));
        return Optional.ofNullable(customers);
    }

    @Override
    public Optional<Customer> findById(int id) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ").append(attributeNamesForSelect(Customer.class));
        sql.append(" FROM ").append(getSimpleNameTable(Customer.class));
        sql.append(" WHERE customer_id = ?");

        Customer customer = jdbcTemplate.queryForObject(sql.toString(), new BeanPropertyRowMapper<>(Customer.class), new Integer[]{id});
        return Optional.ofNullable(customer);
    }

    @Override
    public Optional<List<Integer>> getIdList() {
        String sql = "SELECT customer_id FROM customer";
        List<Integer> idList = jdbcTemplate.queryForList(sql, Integer.class);
        return Optional.ofNullable(idList);
    }


}
