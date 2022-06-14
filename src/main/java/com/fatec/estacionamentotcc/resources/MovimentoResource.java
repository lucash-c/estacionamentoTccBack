package com.fatec.estacionamentotcc.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatec.estacionamentotcc.domain.Movimento;
import com.fatec.estacionamentotcc.services.MovimentoService;

@RestController
@RequestMapping(value = "/movimentos")
public class MovimentoResource {

	@Autowired
	MovimentoService service;


	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Movimento obj) {

		obj = service.insert(obj);

		// criando response com request e seu respectivo id

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).build();

	}
	
	/*@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<Movimento>> findPage(
			@RequestParam(value="data_hora_s") @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm") Date horaSaida, 
			@RequestParam(value="data_hora_c") @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm") Date horaChegada, 
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="id") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Movimento> list = service.search(horaSaida, horaChegada, page, linesPerPage, orderBy, direction);
		
		return ResponseEntity.ok().body(list);
	}*/

}
