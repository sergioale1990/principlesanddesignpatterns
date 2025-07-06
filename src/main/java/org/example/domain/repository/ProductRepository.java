package org.example.domain.repository;

import org.example.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//Repositorio para Productos
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAll();
}
