package com.fatec.estacionamentotcc;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fatec.estacionamentotcc.domain.Cliente;
import com.fatec.estacionamentotcc.domain.Fileira;
import com.fatec.estacionamentotcc.domain.Movimento;
import com.fatec.estacionamentotcc.domain.Usuario;
import com.fatec.estacionamentotcc.domain.Vaga;
import com.fatec.estacionamentotcc.repositories.FileiraRepository;
import com.fatec.estacionamentotcc.repositories.MovimentoRepository;
import com.fatec.estacionamentotcc.repositories.UsuarioRepository;
import com.fatec.estacionamentotcc.repositories.VagaRepository;

@SpringBootApplication
public class EstacionamentotccApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private FileiraRepository fileiraRepository;
	@Autowired
	private VagaRepository vagaRepository;
	@Autowired
	private MovimentoRepository movimentoRepository;

	public static void main(String[] args) {
		SpringApplication.run(EstacionamentotccApplication.class, args);
	}

	public void run(String... args) throws Exception {

		Usuario user = new Usuario("lucas@teste.com", "assad44");
		Usuario user2 = new Usuario("joao@teste.com", "sadds233");

		Fileira fileira1 = new Fileira("A");

		Vaga vaga1 = new Vaga("comum", fileira1);
		Vaga vaga2 = new Vaga("comum", fileira1);
		Vaga vaga3 = new Vaga("comum", fileira1);
		Vaga vaga4 = new Vaga("comum", fileira1);
		Vaga vaga5 = new Vaga("preferencial", fileira1);
		Vaga vaga6 = new Vaga("mensalista", fileira1);

		Cliente cliente = new Cliente("fulano");

		Movimento mov = new Movimento(vaga1, 22.00, user,
				1);

		usuarioRepository.saveAll(Arrays.asList(user, user2));
		fileiraRepository.saveAll(Arrays.asList(fileira1));
		vagaRepository.saveAll(Arrays.asList(vaga1, vaga2, vaga3, vaga4, vaga5, vaga6));

		movimentoRepository.saveAll(Arrays.asList(mov));
	}

}
