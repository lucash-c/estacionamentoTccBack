package com.fatec.estacionamentotcc.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.fatec.estacionamentotcc.domain.Movimento;
import com.fatec.estacionamentotcc.repositories.MovimentoRepository;
import com.fatec.estacionamentotcc.services.exceptions.ObjNotFoundException;

@Service
public class MovimentoService {

	@Autowired
	private MovimentoRepository repo;

	public Movimento find(Integer id) {

		Optional<Movimento> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjNotFoundException("Registro não encontrado! id:" + id));
	}

	public List<Movimento> findAll() {

		List<Movimento> obj = new ArrayList<>();
		obj = repo.findAll();
		return obj;
	}

	public Movimento insert(Movimento obj) {
		return repo.save(obj);
	}
	
	public Page<Movimento> search(Date horaSaida, Date horaChegada, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.search(horaSaida, horaChegada, pageRequest);	
	}

}