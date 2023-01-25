package br.com.projeto.apiusuario.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
	
	@GetMapping("/usuarios")
	public String exibirMensagem() {
		return "Ola";
	}
	
}
