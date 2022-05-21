package com.fatec.estacionamentotcc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fatec.estacionamentotcc.domain.Usuario;
import com.fatec.estacionamentotcc.domain.Vaga;
import com.fatec.estacionamentotcc.repositories.UsuarioRepository;
import com.fatec.estacionamentotcc.services.exceptions.ObjNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;

	public Usuario find(Integer id) {

		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjNotFoundException("Usuario não encontrado! id:" + id));
	}

	public List<Usuario> findAll() {

		List<Usuario> obj = new ArrayList<>();
		obj = repo.findAll();
		return obj;
	}

	public Usuario insert(Usuario obj) {
		return repo.save(obj);
	}

	public Usuario update(Usuario obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	public Usuario login(String email, String senha) {
		return repo.login(email, senha);
	}

}