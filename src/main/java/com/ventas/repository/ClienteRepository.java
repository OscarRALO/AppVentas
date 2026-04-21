package com.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ventas.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
}