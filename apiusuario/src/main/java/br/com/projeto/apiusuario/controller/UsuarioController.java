package br.com.projeto.apiusuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.apiusuario.model.Usuario;
import br.com.projeto.apiusuario.repository.UsuarioRepository;

@RestController
public class UsuarioController{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/usuarios")
	public List<Usuario> obterUsuarios() {
		return (List<Usuario>) usuarioRepository.findAll();
	}
	
}
