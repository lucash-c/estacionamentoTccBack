package com.fatec.estacionamentotcc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.estacionamentotcc.domain.Ticket;
import com.fatec.estacionamentotcc.services.TicketService;

@RestController
@RequestMapping(value = "/tickets")
public class TicketResource {

	@Autowired
	TicketService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Ticket obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	};

}
