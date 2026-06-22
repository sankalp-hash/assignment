package com.nagp.assignment.repository;

import com.nagp.assignment.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRespository extends JpaRepository<Product, Long> {
}
