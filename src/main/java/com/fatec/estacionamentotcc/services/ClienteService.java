package com.fatec.estacionamentotcc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.estacionamentotcc.domain.Cliente;
import com.fatec.estacionamentotcc.repositories.ClienteRepository;
import com.fatec.estacionamentotcc.services.exceptions.ObjNotFoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repo;

	public Cliente find(Integer cod) {
		Optional<Cliente> obj = repo.findById(cod);
		return obj.orElseThrow(() -> new ObjNotFoundException("Cliente não encontrado! Código:" + cod));
	}

	public List<Cliente> findAll() {
		List<Cliente> obj = new ArrayList<>();
		obj = repo.findAll();
		return obj;
	}

	public Cliente insert(Cliente obj) {
		return repo.save(obj);
	}

	public Cliente update(Cliente obj) {
		return repo.save(obj);
	}

	public void delete(Integer cod) {
		find(cod);
		repo.deleteById(cod);
	}

}
