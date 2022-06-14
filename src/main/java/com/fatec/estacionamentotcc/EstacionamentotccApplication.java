package com.fatec.estacionamentotcc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fatec.estacionamentotcc.domain.Cliente;
import com.fatec.estacionamentotcc.domain.Fileira;
import com.fatec.estacionamentotcc.domain.Usuario;
import com.fatec.estacionamentotcc.repositories.ClienteRepository;
import com.fatec.estacionamentotcc.repositories.FileiraRepository;
import com.fatec.estacionamentotcc.repositories.MovimentoRepository;
import com.fatec.estacionamentotcc.repositories.UsuarioRepository;
import com.fatec.estacionamentotcc.repositories.VagaRepository;

@SpringBootApplication
public class EstacionamentotccApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
<<<<<<< Updated upstream
=======
	@Autowired
	private FileiraRepository fileiraRepository;
	@Autowired
	private VagaRepository vagaRepository;
	@Autowired
	private MovimentoRepository movimentoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	


	public static void main(String[] args) {
		SpringApplication.run(EstacionamentotccApplication.class, args);
	}

	public void run(String... args) throws Exception {


		Usuario user = new Usuario("lucas@teste.com", "assad44");
		Usuario user2 = new Usuario("joao@teste.com", "sadds233");

		Fileira fileira1 = new Fileira("A", 10,20,30);
		Fileira fileira2 =new Fileira("B", 0,0,10);

	

		Cliente cliente = new Cliente("fulano");
		
		
		//LocalDateTime chegada = LocalDateTime.now();
		//LocalDateTime saida = LocalDateTime.now();
		
	
		//Movimento mov = new Movimento(chegada, saida, 22.0, 1 , vaga1, cliente, user);
		
		usuarioRepository.save(user);
		usuarioRepository.save(user2);
		clienteRepository.saveAll(Arrays.asList(cliente));	
		fileiraRepository.saveAll(Arrays.asList(fileira1));
		fileiraRepository.save(fileira2);
		vagaRepository.saveAll(fileira1.getVagas());
		vagaRepository.saveAll(fileira2.getVagas());
		
		//movimentoRepository.saveAll(Arrays.asList(mov));

		
		
>>>>>>> Stashed changes
	}

}
