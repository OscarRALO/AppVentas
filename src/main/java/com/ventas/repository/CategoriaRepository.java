package com.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ventas.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
}