package org.example.domain.repository;

import org.example.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

//Repositorio para Ordenes de compra
public interface OrderRepository  extends JpaRepository<Order, Long>{
}
