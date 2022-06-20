package com.fatec.estacionamentotcc.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatec.estacionamentotcc.domain.Cliente;
import com.fatec.estacionamentotcc.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	ClienteService service;
	
	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Cliente> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	};

	@RequestMapping(value = "/{cod}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer cod) {
		Cliente obj = service.find(cod);
		return ResponseEntity.ok().body(obj);
	};

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Cliente obj) {
		//obj.setSerial(UUID.randomUUID().toString());
		obj = service.insert(obj);

		// criando response com request e seu respectivo id

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cod}").buildAndExpand(obj.getCod()).toUri();

		return ResponseEntity.created(uri).build();

	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Cliente obj) {
		obj = service.update(obj);

		return ResponseEntity.noContent().build();

	}

	@RequestMapping(value = "/remove/{cod}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer cod) {

		service.delete(cod);
		return ResponseEntity.noContent().build();

	}

}
