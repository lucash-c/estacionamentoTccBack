package com.fatec.estacionamentotcc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.estacionamentotcc.domain.Fileira;
import com.fatec.estacionamentotcc.repositories.FileiraRepository;

@Service
public class FileiraService {

	@Autowired
	private FileiraRepository repo;

	public Fileira buscar(Integer id) {

		Optional<Fileira> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
