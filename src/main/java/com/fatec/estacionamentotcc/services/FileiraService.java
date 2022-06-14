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
	
	public Fileira findByDesc(String descricao) {

		Optional<Fileira> obj = repo.searchByDesc(descricao);
		return obj.orElseThrow(() -> new ObjNotFoundException("Fileira não encontrada! Descrição: " + descricao));
	}

	public List<Fileira> findAll() {

		List<Fileira> obj = new ArrayList<>();
		obj = repo.findAll();
		return obj;
	}

	public Fileira insert(Fileira obj) {
		 
		Fileira fileira = repo.save(obj);
		
		for(int i = 0; i < obj.getCountComuns(); i++) {
			Vaga vaga = new Vaga("comum", obj);
			vaga.setIdFileira(obj.getId());
			vaga.setIndexFileira(obj.getVagas().size()+1);
			obj.getVagas().add(vaga);
			repoVaga.save(vaga);
		}
		
		for(int i = 0; i < obj.getCountPreferencial(); i++) {
			Vaga vaga = new Vaga("preferencial", obj);
			vaga.setIdFileira(obj.getId());
			vaga.setIndexFileira(obj.getVagas().size()+1);
			obj.getVagas().add(vaga);
			repoVaga.save(vaga);
		}
		
		for(int i = 0; i < obj.getCountMensalista(); i++) {
			Vaga vaga = new Vaga("mensalista", obj);
			vaga.setIdFileira(obj.getId());
			vaga.setIndexFileira(obj.getVagas().size()+1);
			obj.getVagas().add(vaga);
			repoVaga.save(vaga);
		}		
		
		return fileira;
	}

	public Fileira update(Fileira obj) {
		find(obj.getId());
		return repo.save(obj);
		
	}

	public void delete(Integer id) {
		Fileira obj= find(id);
		repoVaga.deleteAll(obj.getVagas());
		repo.deleteById(obj.getId());

	}

}
