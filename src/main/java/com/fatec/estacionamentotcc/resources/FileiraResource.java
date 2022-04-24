package com.fatec.estacionamentotcc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.estacionamentotcc.domain.Fileira;
import com.fatec.estacionamentotcc.services.FileiraService;

@RestController
@RequestMapping(value = "/fileiras")
public class FileiraResource {

	@Autowired
	FileiraService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Fileira obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	};

}
