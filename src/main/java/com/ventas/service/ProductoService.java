package com.ventas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventas.entities.Producto;
import com.ventas.repository.ProductoRepository;

@Service
public class ProductoService {
	
	@Autowired
	ProductoRepository productoRepository;
	
	public Iterable<Producto> findAll(){
		return productoRepository.findAll();
	}
	
	public Producto save(Producto producto) {
		
		return productoRepository.save(producto);
	}
	
	public Optional<Producto> findById(Long id) {
		return productoRepository.findById(id);
		}
	
	public void delete(Producto producto) {
		productoRepository.delete(producto);
		}

}

