package com.fatec.estacionamentotcc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.estacionamentotcc.domain.Vaga;
import com.fatec.estacionamentotcc.services.VagaService;

@RestController
@RequestMapping(value = "/vagas")
public class VagaResource {

	@Autowired
	VagaService service;


	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Vaga> obj = new ArrayList<>();
		obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	};
	
	@RequestMapping(value = "/{tipo}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable String tipo) {
		Page<Vaga> vagas = service.searchVagaDisp(tipo);
		return ResponseEntity.ok().body(vagas);
	};

}
