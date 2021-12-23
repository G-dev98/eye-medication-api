package com.eye_medication.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eye_medication.domain.UnidadeMedica;

@Repository
public interface UnidadeMedicaRepository extends JpaRepository<UnidadeMedica, Long> {

	@Query(value = "SELECT UNIDADE_MEDICA.ID,UNIDADE_MEDICA.N_CAMA,"
			+ " UNIDADE_MEDICA.N_QUARTO,UNIDADE_MEDICA.STATUS,UNIDADE_MEDICA.TIPO" 
			+ " FROM UNIDADE_MEDICA"
			 + " WHERE  UNIDADE_MEDICA.STATUS = 'Disponivel'",nativeQuery = true)
	List<UnidadeMedica> findByUmDisponivel();

}
