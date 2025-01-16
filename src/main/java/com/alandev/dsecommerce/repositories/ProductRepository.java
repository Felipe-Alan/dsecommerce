package com.alandev.dsecommerce.repositories;

import com.alandev.dsecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
