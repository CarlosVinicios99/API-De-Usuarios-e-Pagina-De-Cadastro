package br.com.projeto.apiusuario.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.apiusuario.model.Usuario;
import br.com.projeto.apiusuario.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<Usuario> obterUsuarios() {
		return (List<Usuario>) usuarioRepository.findAll();
	}
	
	@PostMapping
	public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
		Usuario novoUsuario = usuarioRepository.save(usuario);
		return novoUsuario;
	}
	
	@PutMapping
	public Usuario alterarUsuario(@RequestBody Usuario usuario) {
		Usuario novoUsuario = usuarioRepository.save(usuario);
		return novoUsuario;
	}
	
	@DeleteMapping("/{id}")
	public Optional<Usuario> excluirUsuario(@PathVariable Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		usuarioRepository.deleteById(id);
		return usuario;
	}
	
	
}
