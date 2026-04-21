package com.ventas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventas.entities.Proveedor;
import com.ventas.repository.ProveedorRepository;

@Service
public class ProveedorService {
	
	@Autowired
	ProveedorRepository proveedorRepository;
	
	public Iterable<Proveedor> findAll(){
		return proveedorRepository.findAll();
	}
	
	public Proveedor save(Proveedor proveedor) {
		
		return proveedorRepository.save(proveedor);
	}
	
	public Optional<Proveedor> findById(Long id) {
		return proveedorRepository.findById(id);
		}
	
	public void delete(Proveedor proveedor) {
		proveedorRepository.delete(proveedor);
		}

}

