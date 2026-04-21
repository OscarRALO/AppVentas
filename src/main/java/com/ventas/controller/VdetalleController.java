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

import com.ventas.entities.Vdetalle;
import com.ventas.service.VdetalleService;

@RestController
@RequestMapping("api/vdetalles")
public class VdetalleController {
	@Autowired
	VdetalleService vdetalleService ;
	
	@GetMapping
	public Iterable<Vdetalle> listar(){
		
		return vdetalleService.findAll();
		
	}
	
	@PostMapping
	public Vdetalle create(@RequestBody Vdetalle vdetalle) {
		
		return vdetalleService.save(vdetalle);
	}
	
	@GetMapping("{id}")
	public Vdetalle get(@PathVariable Long id) {
	return vdetalleService.findById(id).orElse(null);
	}
	
	// Editar o actualizar un detalle de compra
    @PutMapping("{id}")
    public Vdetalle update(@PathVariable Long id, @RequestBody Vdetalle vdetalle) {
        Vdetalle vdetalleActual = vdetalleService.findById(id).orElse(null);
        if (vdetalleActual != null) {
            vdetalleActual.setCantidad(vdetalle.getCantidad());
            vdetalleActual.setPrecio(vdetalle.getPrecio());
            vdetalleActual.setSubtotal(vdetalle.getSubtotal());
            vdetalleActual.setProducto(vdetalle.getProducto());
            vdetalleActual.setVencabezado(vdetalle.getVencabezado());
            return vdetalleService.save(vdetalleActual);
        }
        return null;
    }

    // Eliminar un detalle de venta
	@DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        Vdetalle vdetalleActual = vdetalleService.findById(id).orElse(null);
        if(vdetalleActual != null){
        	vdetalleService.delete(vdetalleActual);
        }
    }
}
