package com.eye_medication.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eye_medication.domain.Prescricao;

@Repository
public interface PrescricaoRepository extends JpaRepository<Prescricao, Long> {

	
	@Query(value="SELECT  DISTINCT PRESCRICAO.ID, PRESCRICAO.DATA_CRIACAO, PRESCRICAO.PRONTUARIO_ID"
			+ " FROM PRESCRICAO"
			+ " INNER JOIN PRONTUARIO"
			+ " WHERE PRESCRICAO.PRONTUARIO_ID = :id_pront"
			+ " ORDER BY PRESCRICAO.ID DESC",nativeQuery = true)
	List<Prescricao> historicoPrescricao(@Param("id_pront")Long id_pront);

	
	

}
