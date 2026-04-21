package com.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ventas.entities.Cdetalle;

public interface CdetalleRepository extends JpaRepository<Cdetalle, Long> {
	
}