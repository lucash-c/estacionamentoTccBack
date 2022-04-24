package com.fatec.estacionamentotcc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.estacionamentotcc.domain.Cliente;
import com.fatec.estacionamentotcc.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	ClienteService service;

	@RequestMapping(value = "/{cod}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer cod) {
		Cliente obj = service.buscar(cod);
		return ResponseEntity.ok().body(obj);
	};

}
