package com.ventas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventas.entities.Usuario;
import com.ventas.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Iterable<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	
	public Usuario save(Usuario usuario) {
		
		return usuarioRepository.save(usuario);
	}
	
	public Optional<Usuario> findById(Long id) {
		return usuarioRepository.findById(id);
		}
	
	public void delete(Usuario usuario) {
		usuarioRepository.delete(usuario);
		}
		

    public Optional<Usuario> findByUsuario(String usuario) {
        return usuarioRepository.findByUsuario(usuario);
    }

}

