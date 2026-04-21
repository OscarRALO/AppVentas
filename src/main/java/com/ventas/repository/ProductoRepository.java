package com.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ventas.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
	
}