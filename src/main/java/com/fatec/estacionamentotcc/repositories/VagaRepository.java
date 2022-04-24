package com.fatec.estacionamentotcc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.estacionamentotcc.domain.Vaga;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Integer> {

}
