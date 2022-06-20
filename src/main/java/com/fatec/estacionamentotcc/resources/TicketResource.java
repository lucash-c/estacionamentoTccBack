package com.fatec.estacionamentotcc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Ticket obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	};

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Ticket> obj = new ArrayList<>();
		obj = service.findAll();
		
		return ResponseEntity.ok().body(obj);
	};

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> insert(@RequestBody Ticket obj) {

		obj = service.insert(obj);

		// criando response com request e seu respectivo id

		return ResponseEntity.ok().body(obj);

	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Ticket obj) {
		obj = service.update(obj);
		return ResponseEntity.ok().build();

	}

	@RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		service.delete(id);
		return ResponseEntity.noContent().build();

	}

}
