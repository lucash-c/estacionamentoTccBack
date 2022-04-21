package com.fatec.estacionamentotcc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.estacionamentotcc.domain.Usuario;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Usuario> listar() {
		Usuario user1 = new Usuario("Lucas", "123456");
		Usuario user2 = new Usuario("Joao", "123456");
		
		List<Usuario> lista = new ArrayList<>();
		lista.add(user1);
		lista.add(user2);
		return lista;
	}
}
