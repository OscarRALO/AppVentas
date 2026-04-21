package com.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ventas.entities.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
	
}