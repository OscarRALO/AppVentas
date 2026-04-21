package com.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ventas.entities.Vdetalle;

public interface VdetalleRepository extends JpaRepository<Vdetalle, Long> {
	
}