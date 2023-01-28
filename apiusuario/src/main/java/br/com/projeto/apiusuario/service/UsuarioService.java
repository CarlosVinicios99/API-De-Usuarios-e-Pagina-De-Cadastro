package br.com.projeto.apiusuario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.projeto.apiusuario.model.Usuario;
import br.com.projeto.apiusuario.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private PasswordEncoder passwordEncoder;
	
	public UsuarioService() {
		this.passwordEncoder = new BCryptPasswordEncoder();
	}
	
	public List<Usuario> obterUsuarios(){
		return usuarioRepository.findAll();
	}
	
	public Usuario cadastrarUsuario(Usuario usuario) {
		String encoder = this.passwordEncoder.encode(usuario.getSenha());
		usuario.setSenha(encoder);
		return usuarioRepository.save(usuario);
	}
	
	public Usuario alterarUsuario(Usuario usuario) {
		String encoder = this.passwordEncoder.encode(usuario.getSenha());
		usuario.setSenha(encoder);
		return usuarioRepository.save(usuario);
	}
	
	public Boolean excluirUsuario(Long id) {
		usuarioRepository.deleteById(id);
		return true;
	}
	
	public Boolean validarSenha(Usuario usuario) {
		Optional<Usuario> usuarioSalvo = usuarioRepository.findById(usuario.getId());
		String senha = usuarioSalvo.get().getSenha();
		Boolean senhaValida = passwordEncoder.matches(usuario.getSenha(), senha);
		return senhaValida;	
	}
	
	
}
