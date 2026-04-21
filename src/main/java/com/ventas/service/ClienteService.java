package com.ventas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventas.entities.Cliente;
import com.ventas.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public Iterable<Cliente> findAll(){
		return clienteRepository.findAll();
	}
	
	public Cliente save(Cliente cliente) {
		
		return clienteRepository.save(cliente);
	}
	
	public Optional<Cliente> findById(Long id) {
		return clienteRepository.findById(id);
		}
	
	public void delete(Cliente cliente) {
		clienteRepository.delete(cliente);
		}

}

