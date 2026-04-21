package com.ventas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventas.entities.Vencabezado;
import com.ventas.repository.VencabezadoRepository;

@Service
public class VencabezadoService {
	
	@Autowired
	VencabezadoRepository vencabezadoRepository;
	
	public Iterable<Vencabezado> findAll(){
		return vencabezadoRepository.findAll();
	}
	
	public Vencabezado save(Vencabezado cdetalle) {
		
		return vencabezadoRepository.save(cdetalle);
	}
	
	public Optional<Vencabezado> findById(Long id) {
		return vencabezadoRepository.findById(id);
		}
	
	public void delete(Vencabezado vencabezado) {
		vencabezadoRepository.delete(vencabezado);
		}

}

