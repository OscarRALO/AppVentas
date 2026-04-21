package com.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ventas.entities.Vencabezado;

public interface VencabezadoRepository extends JpaRepository<Vencabezado, Long> {
	
}