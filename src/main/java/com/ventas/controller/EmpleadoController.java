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

import com.ventas.entities.Empleado;
import com.ventas.service.EmpleadoService;

@RestController
@RequestMapping("api/empleados")
public class EmpleadoController {
	@Autowired
	EmpleadoService empleadoService ;
	
	@GetMapping
	public Iterable<Empleado> listar(){
		
		return empleadoService.findAll();
		
	}
	
	@PostMapping
	public Empleado create(@RequestBody Empleado empleado) {
		
		return empleadoService.save(empleado);
	}
	
	@GetMapping("{id}")
	public Empleado get(@PathVariable Long id) {
	return empleadoService.findById(id).orElse(null);
	}
	
	// Editar o actualizar un empleado
    @PutMapping("{id}")
    public Empleado update(@PathVariable Long id, @RequestBody Empleado empleado) {
        Empleado empleadoActual = empleadoService.findById(id).orElse(null);
        if (empleadoActual != null) {
            empleadoActual.setApematerno(empleado.getApematerno());
            empleadoActual.setApepaterno(empleado.getApepaterno());
            empleadoActual.setCargo(empleado.getCargo());
            empleadoActual.setNombre(empleado.getNombre());
            return empleadoService.save(empleadoActual);
        }
        return null;
    }

    // Eliminar un empleado
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        Empleado empleadoActual = empleadoService.findById(id).orElse(null);
        if (empleadoActual != null) {
            empleadoService.delete(empleadoActual);
        }
    }
}
