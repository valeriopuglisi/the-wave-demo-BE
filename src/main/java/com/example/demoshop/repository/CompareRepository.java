package com.example.demoshop.repository;

import com.example.demoshop.model.Compare;
import com.example.demoshop.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompareRepository extends CrudRepository<Compare, Integer> {

}
