package org.example.ems.repo;

import org.example.ems.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo  extends JpaRepository<Product, Long> {
}
