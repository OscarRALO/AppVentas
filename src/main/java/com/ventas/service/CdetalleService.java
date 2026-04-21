package com.ventas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventas.entities.Cdetalle;
import com.ventas.repository.CdetalleRepository;

@Service
public class CdetalleService {
	
	@Autowired
	CdetalleRepository cdetalleRepository;
	
	public Iterable<Cdetalle> findAll(){
		return cdetalleRepository.findAll();
	}
	
	public Cdetalle save(Cdetalle cdetalle) {
		
		return cdetalleRepository.save(cdetalle);
	}
	
	public Optional<Cdetalle> findById(Long id) {
		return cdetalleRepository.findById(id);
		}
	
	public void delete(Cdetalle cdetalle) {
		cdetalleRepository.delete(cdetalle);
		}

}

