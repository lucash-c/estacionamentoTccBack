package com.fatec.estacionamentotcc.repositories;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fatec.estacionamentotcc.domain.Movimento;

@Repository
public interface MovimentoRepository extends JpaRepository<Movimento, Integer> {

	@Query("SELECT obj FROM Movimento obj WHERE obj.horaChegada = :horaChegada AND obj.horaSaida = :horaSaida")
	Page<Movimento> search(
			 @Param("horaChegada") Date horaChegada,
			 @Param("horaSaida") Date horaSaida, 
			 Pageable pageRequest);

}