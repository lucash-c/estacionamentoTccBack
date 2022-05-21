package com.fatec.estacionamentotcc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.estacionamentotcc.domain.Ticket;
import com.fatec.estacionamentotcc.repositories.TicketRepository;
import com.fatec.estacionamentotcc.services.exceptions.ObjNotFoundException;

@Service
public class TicketService {

	@Autowired
	private TicketRepository repo;

	public Ticket find(Integer id) {

		Optional<Ticket> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjNotFoundException("Ticket não encontrado! id:" + id));
	}

	public List<Ticket> findAll() {

		List<Ticket> obj = new ArrayList<>();
		obj = repo.findAll();
		return obj;
	}

	public Ticket insert(Ticket obj) {
		return repo.save(obj);
	}

	public Ticket update(Ticket obj) {
		find(obj.getCod());
		return repo.save(obj);
	}

	public void delete(Integer cod) {
		find(cod);
		repo.deleteById(cod);
	}

}
