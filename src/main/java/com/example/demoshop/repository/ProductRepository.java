package com.example.demoshop.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demoshop.model.Product;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    Product findByName(String name);
}