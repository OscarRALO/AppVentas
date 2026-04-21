package com.ventas.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ventas.dto.LoginRequest;
import com.ventas.entities.Usuario;
import com.ventas.service.UsuarioService;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService ;
	
	@GetMapping
	public Iterable<Usuario> listar(){
		
		return usuarioService.findAll();
		
	}
	
	@PostMapping
	public Usuario create(@RequestBody Usuario usuario) {
		
		return usuarioService.save(usuario);
	}
	
	@GetMapping("{id}")
	public Usuario get(@PathVariable Long id) {
	return usuarioService.findById(id).orElse(null);
	}
	
	// Editar o actualizar un usuario
    @PutMapping("{id}")
    public Usuario update(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario usuarioActual = usuarioService.findById(id).orElse(null);
        if (usuarioActual != null) {
            usuarioActual.setEstado(usuario.getEstado());
            usuarioActual.setPassword(usuario.getPassword());
            usuarioActual.setUsuario(usuario.getUsuario());
            usuarioActual.setEmpleado(usuario.getEmpleado());
            return usuarioService.save(usuarioActual);
        }
        return null;
    }

    // Eliminar un usuario
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        Usuario usuarioActual = usuarioService.findById(id).orElse(null);
        if (usuarioActual != null) {
            usuarioService.delete(usuarioActual);
        }
    }

  
    @PostMapping("/login")
    public boolean login(@RequestBody LoginRequest request) {
        Optional<Usuario> usuarioOpt = usuarioService.findByUsuario(request.getUsuario());
        
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            // Compara las contraseñas directamente (en producción deberías encriptarlas)
            if (usuario.getPassword().equals(request.getPassword())) {
                // Credenciales válidas
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    

}
