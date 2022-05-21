package com.fatec.estacionamentotcc.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.estacionamentotcc.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM Usuario obj WHERE obj.email LIKE %:email% AND obj.senha LIKE %:senha% ")
	Usuario login(@Param("email") String email, @Param("senha") String senha);
}