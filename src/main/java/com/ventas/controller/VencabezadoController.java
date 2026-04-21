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

import com.ventas.entities.Vencabezado;
import com.ventas.service.VencabezadoService;

@RestController
@RequestMapping("api/vencabezados")
public class VencabezadoController {
	@Autowired
	VencabezadoService vencabezadoService ;
	
	@GetMapping
	public Iterable<Vencabezado> listar(){
		
		return vencabezadoService.findAll();
		
	}
	
	@PostMapping
	public Vencabezado create(@RequestBody Vencabezado vencabezado) {
		
		return vencabezadoService.save(vencabezado);
	}
	
	@GetMapping("{id}")
	public Vencabezado get(@PathVariable Long id) {
	return vencabezadoService.findById(id).orElse(null);
	}
	
	// Editar o actualizar un encabezado de compra
    @PutMapping("{id}")
    public Vencabezado update(@PathVariable Long id, @RequestBody Vencabezado vencabezado) {
    	Vencabezado vencabezadoActual = vencabezadoService.findById(id).orElse(null);
        if (vencabezadoActual != null) {
        	vencabezadoActual.setFecha(vencabezado.getFecha());
        	vencabezadoActual.setTotal(vencabezado.getTotal());
        	vencabezadoActual.setEmpleado(vencabezado.getEmpleado());
        	vencabezadoActual.setCliente(vencabezado.getCliente());
            return vencabezadoService.save(vencabezadoActual);
        }
        return null;
    }

    // Eliminar un encabezado de compra
	@DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
		Vencabezado vencabezadoActual = vencabezadoService.findById(id).orElse(null);
        if(vencabezadoActual != null){
        	vencabezadoService.delete(vencabezadoActual);
        }
    }
	
}
