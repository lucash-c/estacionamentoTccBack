package com.fatec.estacionamentotcc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.estacionamentotcc.domain.Ticket;
import com.fatec.estacionamentotcc.repositories.TicketRepository;

@Service
public class TicketService {

	@Autowired
	private TicketRepository repo;

	public Ticket buscar(Integer id) {

		Optional<Ticket> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
