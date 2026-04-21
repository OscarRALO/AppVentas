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

import com.ventas.entities.Cencabezado;
import com.ventas.service.CencabezadoService;

@RestController
@RequestMapping("api/cencabezados")
public class CencabezadoController {
	@Autowired
	CencabezadoService cencabezadoService ;
	
	@GetMapping
	public Iterable<Cencabezado> listar(){
		
		return cencabezadoService.findAll();
		
	}
	
	@PostMapping
	public Cencabezado create(@RequestBody Cencabezado cencabezado) {
		
		return cencabezadoService.save(cencabezado);
	}
	
	@GetMapping("{id}")
	public Cencabezado get(@PathVariable Long id) {
	return cencabezadoService.findById(id).orElse(null);
	}
	
	// Editar o actualizar un encabezado de compra
    @PutMapping("{id}")
    public Cencabezado update(@PathVariable Long id, @RequestBody Cencabezado cencabezado) {
    	Cencabezado cencabezadoActual = cencabezadoService.findById(id).orElse(null);
        if (cencabezadoActual != null) {
        	cencabezadoActual.setFecha(cencabezado.getFecha());
        	cencabezadoActual.setTotal(cencabezado.getTotal());
        	cencabezadoActual.setEmpleado(cencabezado.getEmpleado());
        	cencabezadoActual.setProveedor(cencabezado.getProveedor());
            return cencabezadoService.save(cencabezadoActual);
        }
        return null;
    }

    // Eliminar un encabezado de compra
	@DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
		Cencabezado cencabezadoActual = cencabezadoService.findById(id).orElse(null);
        if(cencabezadoActual != null){
        	cencabezadoService.delete(cencabezadoActual);
        }
    }
}
