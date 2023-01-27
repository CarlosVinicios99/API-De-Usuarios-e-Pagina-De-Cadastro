package br.com.projeto.apiusuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.apiusuario.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
