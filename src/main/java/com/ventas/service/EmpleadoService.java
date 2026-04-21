package com.ventas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventas.entities.Empleado;
import com.ventas.repository.EmpleadoRepository;

@Service
public class EmpleadoService {
	
	@Autowired
	EmpleadoRepository empleadoRepository;
	
	public Iterable<Empleado> findAll(){
		return empleadoRepository.findAll();
	}
	
	public Empleado save(Empleado empleado) {
		
		return empleadoRepository.save(empleado);
	}
	
	public Optional<Empleado> findById(Long id) {
		return empleadoRepository.findById(id);
		}
	
	public void delete(Empleado empleado) {
		empleadoRepository.delete(empleado);
		}

}

