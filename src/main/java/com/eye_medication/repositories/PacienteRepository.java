package com.eye_medication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eye_medication.domain.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

	
	@Modifying
	@Query(value = "DELETE FROM DOENCA_PACIENTE"
	+" WHERE CODIGO_PACIENTE = :id"
	+" AND ID_DOENCA = :id2 ", nativeQuery = true)
	void desatrelarDoenca(@Param("id")Integer id,@Param("id2") Integer id2);

	
	@Modifying
	@Query(value ="INSERT INTO DOENCA_PACIENTE (CODIGO_PACIENTE,ID_DOENCA) "
			+"VALUES (:id, :id_doe)", nativeQuery = true)
	void atribuirDoenca(Integer id, Integer id_doe);

	
	

	
	

}
