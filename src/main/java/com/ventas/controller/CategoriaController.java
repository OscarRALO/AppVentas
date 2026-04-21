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

import com.ventas.entities.Categoria;
import com.ventas.service.CategoriaService;

@RestController
@RequestMapping("api/categorias")
public class CategoriaController {
	@Autowired
	CategoriaService categoriaService ;
	
	@GetMapping
	public Iterable<Categoria> listar(){	
		return categoriaService.findAll();
		
	}
	
	@PostMapping
	public Categoria create(@RequestBody Categoria categoria) {	
		return categoriaService.save(categoria);
	}
	
	@GetMapping("{id}")
	public Categoria get(@PathVariable Long id) {
	return categoriaService.findById(id).orElse(null);
	}
	
    @PutMapping("{id}")
    public Categoria update(@PathVariable Long id, @RequestBody Categoria categoria) {
        Categoria categoriaActual = categoriaService.findById(id).orElse(null);
        if (categoriaActual != null) {
            categoriaActual.setCategoria(categoria.getCategoria());
            return categoriaService.save(categoriaActual);
        }
        return null;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        Categoria categoriaActual = categoriaService.findById(id).orElse(null);
        if (categoriaActual != null) {
            categoriaService.delete(categoriaActual);
        }
    }
	
}
