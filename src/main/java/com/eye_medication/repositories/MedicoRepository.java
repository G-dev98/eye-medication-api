package com.eye_medication.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eye_medication.domain.Medico;

@Repository
public interface MedicoRepository extends  JpaRepository <Medico, Integer> {

	
	@Query("SELECT m FROM  Medico m WHERE  m.nome LIKE  %?1% order by nome")
	List<Medico> findByNomeContaining(@Param("nome") String nome);
	

}
