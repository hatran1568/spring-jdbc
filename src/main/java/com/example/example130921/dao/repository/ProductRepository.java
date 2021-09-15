package com.example.example130921.dao.repository;

import com.example.example130921.dao.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Optional<List<Product>> getAllProducts();

    Optional<Product> getById(int productId);

    Optional<List<Integer>> getIdList();
}
