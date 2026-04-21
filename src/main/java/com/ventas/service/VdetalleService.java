package com.ventas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventas.entities.Vdetalle;
import com.ventas.repository.VdetalleRepository;

@Service
public class VdetalleService {
	
	@Autowired
	VdetalleRepository vdetalleRepository;
	
	public Iterable<Vdetalle> findAll(){
		return vdetalleRepository.findAll();
	}
	
	public Vdetalle save(Vdetalle vdetalle) {
		
		return vdetalleRepository.save(vdetalle);
	}
	
	public Optional<Vdetalle> findById(Long id) {
		return vdetalleRepository.findById(id);
		}
	
	public void delete(Vdetalle vdetalle) {
		vdetalleRepository.delete(vdetalle);
		}

}

