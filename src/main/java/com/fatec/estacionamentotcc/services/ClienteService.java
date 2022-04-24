package com.fatec.estacionamentotcc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.estacionamentotcc.domain.Cliente;
import com.fatec.estacionamentotcc.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente buscar(Integer cod) {

		Optional<Cliente> obj = repo.findById(cod);
		return obj.orElse(null);
	}

}
