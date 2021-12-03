package com.eye_medication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.eye_medication.domain.PacienteUM;

@Repository
public interface PacienteUMRepository extends  JpaRepository <PacienteUM, Long>  {

	@Query("SELECT obj FROM PacienteUM obj WHERE obj.unidadeMedica.id = :id_UM")
	PacienteUM findByDisponibilidade(@Param("id_UM")Long id_UM);

	

}
