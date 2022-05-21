package com.fatec.estacionamentotcc.repositories;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.estacionamentotcc.domain.Vaga;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Integer> {

@Transactional(readOnly=true)
@Query("SELECT DISTINCT obj FROM Vaga obj WHERE obj.tipo LIKE %:tipo% AND obj.estado = 0")
Page<Vaga> searchVagaDisp(@Param("tipo") String tipo, Pageable pageRequest);
	
}
