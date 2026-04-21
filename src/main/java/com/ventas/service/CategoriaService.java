package com.ventas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventas.entities.Categoria;
import com.ventas.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	public Iterable<Categoria> findAll(){
		return categoriaRepository.findAll();
	}
	
	public Categoria save(Categoria categoria) {
		
		return categoriaRepository.save(categoria);
	}
	
	public Optional<Categoria> findById(Long id) {
		return categoriaRepository.findById(id);
		}
	
	public void delete(Categoria categoria) {
		categoriaRepository.delete(categoria);
		}
}
