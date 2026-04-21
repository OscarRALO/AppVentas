package com.ventas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ventas.entities.Cliente;
import com.ventas.service.ClienteService;

@RestController
@RequestMapping("api/clientes")
public class ClienteController {
	@Autowired
	ClienteService clienteService ;
	
	@GetMapping
	public Iterable<Cliente> listar(){
		
		return clienteService.findAll();
		
	}
	
	@PostMapping
	public Cliente create(@RequestBody Cliente cliente) {
		
		return clienteService.save(cliente);
	}
	
	@GetMapping("{id}")
	public Cliente get(@PathVariable Long id) {
	return clienteService.findById(id).orElse(null);
	}
	
	// Editar o actualizar un cliente
    @PutMapping("{id}")
    public Cliente update(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente clienteActual = clienteService.findById(id).orElse(null);
        if (clienteActual != null) {
            clienteActual.setApellido(cliente.getApellido());
            clienteActual.setDireccion(cliente.getDireccion());
            clienteActual.setEstado(cliente.getEstado());
            clienteActual.setNombre(cliente.getNombre());
	    clienteActual.setTelefono(cliente.getTelefono());
            return clienteService.save(clienteActual);
        }
        return null;
    }

    // Eliminar un cliente
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        Cliente clienteActual = clienteService.findById(id).orElse(null);
        if (clienteActual != null) {
            clienteService.delete(clienteActual);
        }
    }
}
