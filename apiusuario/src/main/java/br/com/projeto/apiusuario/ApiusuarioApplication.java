package br.com.projeto.apiusuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ApiusuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiusuarioApplication.class, args);
	}

}
