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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatec.estacionamentotcc.domain.Usuario;
import com.fatec.estacionamentotcc.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired
	UsuarioService service;


	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Usuario> obj = new ArrayList<>();
		obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	};

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Usuario obj) {

		obj = service.insert(obj);

		// criando response com request e seu respectivo id

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).build();

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Usuario obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);

		return ResponseEntity.noContent().build();

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();

	}

	@RequestMapping(value = "/{login}", method = RequestMethod.GET)
	public ResponseEntity<?> login(@RequestParam(value = "email", defaultValue = "") String email,
			@RequestParam(value = "senha", defaultValue = "") String senha) {
		Usuario usuario = service.login(email, senha);

		if (usuario == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().body(usuario);
		}
	};

}
