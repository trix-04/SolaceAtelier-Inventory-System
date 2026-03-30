package com.SolaceAtelier.inventory_system.repositories;

import com.SolaceAtelier.inventory_system.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByBrandContaining(String brand, Pageable pageable);
}

