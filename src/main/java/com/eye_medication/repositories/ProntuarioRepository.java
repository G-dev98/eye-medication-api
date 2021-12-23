package com.eye_medication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eye_medication.domain.Prontuario;

@Repository
public interface ProntuarioRepository extends JpaRepository<Prontuario, Long> {

	
	@Query(value="SELECT MOVIMENTACAO.ID,MOVIMENTACAO.DATA_MOVIMENTACAO,MOVIMENTACAO.TIPO, UNIDADE_MEDICA.N_QUARTO,UNIDADE_MEDICA.N_CAMA \r\n"
			+ "FROM MOVIMENTACAO\r\n"
			+ "INNER JOIN \r\n"
			+ "PRONTUARIO ON PRONTUARIO.PACIENTE_ID = MOVIMENTACAO.PACIENTE_ID\r\n"
			+ "INNER JOIN\r\n"
			+ "UNIDADE_MEDICA ON UNIDADE_MEDICA.ID = MOVIMENTACAO.UM_ID\r\n"
			+ "WHERE PRONTUARIO.PACIENTE_ID = :id_pac",nativeQuery = true)
	Prontuario historicoMovimentacao(@Param("id_pac")Integer id_pac);


}
