package com.fatec.estacionamentotcc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.estacionamentotcc.domain.Usuario;
import com.fatec.estacionamentotcc.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;

	public Usuario buscar(Integer id) {

		Optional<Usuario> obj = repo.findById(id);
		return obj.orElse(null);
	}

}