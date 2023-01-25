package br.com.projeto.apiusuario.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.projeto.apiusuario.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

}
