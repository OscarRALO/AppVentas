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

import com.ventas.entities.Cdetalle;
import com.ventas.service.CdetalleService;

@RestController
@RequestMapping("api/cdetalles")
public class CdetalleController {
	@Autowired
	CdetalleService cdetalleService ;
	
	@GetMapping
	public Iterable<Cdetalle> listar(){
		
		return cdetalleService.findAll();
		
	}
	
	@PostMapping
	public Cdetalle create(@RequestBody Cdetalle cdetalle) {
		
		return cdetalleService.save(cdetalle);
	}
	
	@GetMapping("{id}")
	public Cdetalle get(@PathVariable Long id) {
	return cdetalleService.findById(id).orElse(null);
	}
	
	// Editar o actualizar un detalle de compra
    @PutMapping("{id}")
    public Cdetalle update(@PathVariable Long id, @RequestBody Cdetalle cdetalle) {
        Cdetalle cdetalleActual = cdetalleService.findById(id).orElse(null);
        if (cdetalleActual != null) {
            cdetalleActual.setCantidad(cdetalle.getCantidad());
            cdetalleActual.setPrecio(cdetalle.getPrecio());
            cdetalleActual.setSubtotal(cdetalle.getSubtotal());
            cdetalleActual.setProducto(cdetalle.getProducto());
            cdetalleActual.setCencabezado(cdetalle.getCencabezado());
            return cdetalleService.save(cdetalleActual);
        }
        return null;
    }

    // Eliminar un detalle de compra
	@DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        Cdetalle cdetalleActual = cdetalleService.findById(id).orElse(null);
        if(cdetalleActual != null){
        	cdetalleService.delete(cdetalleActual);
        }
    }
}
