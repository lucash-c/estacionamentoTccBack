package com.fatec.estacionamentotcc.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatec.estacionamentotcc.domain.Fileira;
import com.fatec.estacionamentotcc.services.FileiraService;

@RestController
@RequestMapping(value = "/fileiras")
public class FileiraResource {

	@Autowired
	FileiraService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Fileira> obj = new ArrayList<>();
		obj = service.findAll();

		return ResponseEntity.ok().body(obj);
	};
	
	@RequestMapping(value = "/{descricao}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable String descricao) {
		Fileira obj = service.findByDesc(descricao);
		return ResponseEntity.ok().body(obj);
	};

<<<<<<< Updated upstream
=======
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Fileira obj) {

		obj = service.insert(obj);

		// criando response com request e seu respectivo id

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).build();

	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Fileira obj) {
		obj = service.update(obj);

		return ResponseEntity.noContent().build();

	}
	
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		service.delete(id);
		return ResponseEntity.noContent().build();

	}

	
>>>>>>> Stashed changes
}
