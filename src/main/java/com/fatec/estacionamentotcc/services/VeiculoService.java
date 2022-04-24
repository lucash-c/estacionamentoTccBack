package com.fatec.estacionamentotcc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.estacionamentotcc.domain.Veiculo;
import com.fatec.estacionamentotcc.repositories.VeiculoRepository;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository repo;

	public Veiculo buscar(Integer id) {

		Optional<Veiculo> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
