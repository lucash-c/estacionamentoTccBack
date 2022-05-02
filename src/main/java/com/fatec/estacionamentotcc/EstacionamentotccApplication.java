package com.fatec.estacionamentotcc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fatec.estacionamentotcc.domain.Usuario;
import com.fatec.estacionamentotcc.repositories.UsuarioRepository;

@SpringBootApplication
public class EstacionamentotccApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(EstacionamentotccApplication.class, args);
	}

	public void run(String... args) throws Exception {

		Usuario user = new Usuario("Lucas", "assad44");
		Usuario user2 = new Usuario("Joao", "sadds233");

		usuarioRepository.saveAll(Arrays.asList(user, user2));

	}

}
