package com.fatec.estacionamentotcc.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.estacionamentotcc.domain.Fileira;


@Repository
public interface FileiraRepository extends JpaRepository<Fileira, Integer> {

	
	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM Fileira obj WHERE obj.descricao LIKE %:descricao% ")
	Optional<Fileira> searchByDesc(@Param("descricao") String desricao);
}