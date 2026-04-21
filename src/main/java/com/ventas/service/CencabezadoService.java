package com.ventas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventas.entities.Cencabezado;
import com.ventas.repository.CencabezadoRepository;

@Service
public class CencabezadoService {
	
	@Autowired
	CencabezadoRepository cencabezadoRepository;
	
	public Iterable<Cencabezado> findAll(){
		return cencabezadoRepository.findAll();
	}
	
	public Cencabezado save(Cencabezado cencabezado) {
		
		return cencabezadoRepository.save(cencabezado);
	}
	
	public Optional<Cencabezado> findById(Long id) {
		return cencabezadoRepository.findById(id);
		}
	
	public void delete(Cencabezado cencabezado) {
		cencabezadoRepository.delete(cencabezado);
		}

}

