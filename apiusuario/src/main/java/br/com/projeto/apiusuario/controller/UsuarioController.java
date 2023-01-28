package br.com.projeto.apiusuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.apiusuario.model.Usuario;
import br.com.projeto.apiusuario.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController{
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> obterUsuarios() {
		return ResponseEntity.status(200).body(usuarioService.obterUsuarios());
	}
	
	@PostMapping
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
		return ResponseEntity.status(201).body(usuarioService.cadastrarUsuario(usuario));
	}
	
	@PutMapping
	public ResponseEntity<Usuario> alterarUsuario(@RequestBody Usuario usuario) {
		Usuario novoUsuario = usuarioService.alterarUsuario(usuario);
		return ResponseEntity.status(201).body(novoUsuario);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluirUsuario(@PathVariable Long id) {
		usuarioService.excluirUsuario(id);
		return ResponseEntity.status(204).build();
	}
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> validarSenha(@RequestBody Usuario usuario){
		Boolean senhaValida = usuarioService.validarSenha(usuario);
		
		if(senhaValida) {
			return ResponseEntity.status(200).build();
		}
		else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
	
}
