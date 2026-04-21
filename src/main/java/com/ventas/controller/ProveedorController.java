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

import com.ventas.entities.Proveedor;
import com.ventas.service.ProveedorService;

@RestController
@RequestMapping("api/proveedores")
public class ProveedorController {
	@Autowired
	ProveedorService proveedorService ;
	
	@GetMapping
	public Iterable<Proveedor> listar(){
		
		return proveedorService.findAll();
		
	}
	
	@PostMapping
	public Proveedor create(@RequestBody Proveedor proveedor) {
		
		return proveedorService.save(proveedor);
	}
	
	@GetMapping("{id}")
	public Proveedor get(@PathVariable Long id) {
	return proveedorService.findById(id).orElse(null);
	}
	
	// Editar o actualizar un proveedor
    @PutMapping("{id}")
    public Proveedor update(@PathVariable Long id, @RequestBody Proveedor proveedor) {
        Proveedor proveedorActual = proveedorService.findById(id).orElse(null);
        if (proveedorActual != null) {
            proveedorActual.setDireccion(proveedor.getDireccion());
            proveedorActual.setEstado(proveedor.getEstado());
            proveedorActual.setNombre(proveedor.getNombre());
            proveedorActual.setRuc(proveedor.getRuc());
            proveedorActual.setTelefono(proveedor.getTelefono());
            return proveedorService.save(proveedorActual);
        }
        return null;
    }

    // Eliminar un proveedor
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        Proveedor proveedorActual = proveedorService.findById(id).orElse(null);
        if (proveedorActual != null) {
            proveedorService.delete(proveedorActual);
        }
    }
    
}
