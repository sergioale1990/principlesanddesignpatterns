package org.example.domain.repository;

import org.example.domain.entity.Kardex;
import org.springframework.data.jpa.repository.JpaRepository;

//Repositorio para Kardex
public interface KardexRepository extends JpaRepository<Kardex, Long> {
}
