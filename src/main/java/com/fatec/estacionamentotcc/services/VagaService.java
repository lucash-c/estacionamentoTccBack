package com.fatec.estacionamentotcc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fatec.estacionamentotcc.domain.Fileira;
import com.fatec.estacionamentotcc.domain.Vaga;
import com.fatec.estacionamentotcc.repositories.FileiraRepository;
import com.fatec.estacionamentotcc.repositories.VagaRepository;
import com.fatec.estacionamentotcc.services.exceptions.ObjNotFoundException;

@Service
public class VagaService {

	@Autowired
	private VagaRepository repo;

	@Autowired
	private FileiraRepository repoFileira;

	public Vaga find(Integer id) {

		Optional<Vaga> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjNotFoundException("Vaga não encontrada! id:" + id));
	}

	public List<Vaga> findAll() {

		List<Vaga> obj = new ArrayList<>();
		obj = repo.findAll();
		return obj;
	}
	
	public Page<Vaga> searchVagaDisp(String tipo) {
		PageRequest pageRequest = PageRequest.of(0,1,Sort.Direction.ASC,"id");
		return repo.searchVagaDisp(tipo, pageRequest);
	}
	
	public Vaga update(Vaga obj) {
		
		Optional<Fileira> fileira = repoFileira.findById(obj.getIdFileira());
		repoFileira.save(fileira.get());
		obj.setFileira(fileira.get());
		repo.save(obj);
		return obj; 		

		
		
	}

}
