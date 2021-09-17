package com.example.example130921.dao.repository.impl;

import com.example.example130921.dao.entity.Customer;
import com.example.example130921.dao.entity.Product;
import com.example.example130921.dao.repository.AbstractRepository;
import com.example.example130921.dao.repository.ProductRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;
import java.util.Optional;

public class ProductRepositoryImpl extends AbstractRepository implements ProductRepository {
    @Override
    public Optional<List<Product>> getAllProducts() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ").append(attributeNamesForSelect(Product.class));
        sql.append(" FROM ").append(getSimpleNameTable(Product.class));
        List<Product> products = jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(Product.class));
        return Optional.ofNullable(products);
    }

    @Override
    public Optional<Product> findById(int productId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ").append(attributeNamesForSelect(Product.class));
        sql.append(" FROM ").append(getSimpleNameTable(Product.class));
        sql.append(" WHERE product_id = ?");
        Product product = jdbcTemplate.queryForObject(sql.toString(),
                                                    new BeanPropertyRowMapper<>(Product.class),
                                                    new Integer[]{productId});
        return Optional.ofNullable(product);
    }

    @Override
    public Optional<List<Integer>> getIdList() {
        String sql = "SELECT product_id FROM product";
        List<Integer> idList = jdbcTemplate.queryForList(sql, Integer.class);
        return Optional.ofNullable(idList);
    }
}
