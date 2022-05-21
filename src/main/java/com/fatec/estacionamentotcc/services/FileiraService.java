package com.fatec.estacionamentotcc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.estacionamentotcc.domain.Fileira;
import com.fatec.estacionamentotcc.domain.Vaga;
import com.fatec.estacionamentotcc.repositories.FileiraRepository;
import com.fatec.estacionamentotcc.repositories.VagaRepository;
import com.fatec.estacionamentotcc.services.exceptions.ObjNotFoundException;

@Service
public class FileiraService {

	@Autowired
	private FileiraRepository repo;
	
	@Autowired
	private VagaRepository repoVaga;

	public Fileira find(Integer id) {

		Optional<Fileira> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjNotFoundException("Fileira não encontrada! id:" + id));
	}

	public List<Fileira> findAll() {

		List<Fileira> obj = new ArrayList<>();
		obj = repo.findAll();
		return obj;
	}

	public Fileira insert(Fileira obj) {
		 
		Fileira fileira = repo.save(obj);
		
		int i = 0;
		for(Vaga vaga : obj.getVagas() ) {
			i++;
			vaga.setIndexFileira(i);
			vaga.setFileira(obj);
			
			repoVaga.save(vaga);
		}
		
		
		return fileira;
	}

	public Fileira update(Fileira obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}

}
