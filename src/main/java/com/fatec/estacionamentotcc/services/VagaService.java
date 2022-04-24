package com.fatec.estacionamentotcc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.estacionamentotcc.domain.Vaga;
import com.fatec.estacionamentotcc.repositories.VagaRepository;

@Service
public class VagaService {

	@Autowired
	private VagaRepository repo;

	public Vaga buscar(Integer id) {

		Optional<Vaga> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
