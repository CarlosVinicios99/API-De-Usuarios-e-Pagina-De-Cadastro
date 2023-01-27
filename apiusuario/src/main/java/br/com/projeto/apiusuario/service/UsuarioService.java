package br.com.projeto.apiusuario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.apiusuario.model.Usuario;
import br.com.projeto.apiusuario.repository.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> obterUsuarios(){
		return usuarioRepository.findAll();
	}
	
	public Usuario cadastrarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	
}
