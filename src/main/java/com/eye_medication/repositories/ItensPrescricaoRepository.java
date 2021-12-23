package com.eye_medication.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eye_medication.domain.ItensPrescricao;

@Repository
public interface ItensPrescricaoRepository extends JpaRepository<ItensPrescricao, Long> {

	@Query(value="SELECT DISTINCT ITENS_PRESCRICAO.ID, ITENS_PRESCRICAO.INDICACAO, ITENS_PRESCRICAO.MEDICAMENTO_ID, ITENS_PRESCRICAO.PRESCRICAO_ID"
			+ " FROM ITENS_PRESCRICAO"
			+ " INNER  JOIN PRESCRICAO"
			+ " WHERE ITENS_PRESCRICAO.PRESCRICAO_ID = :id ",nativeQuery = true)
	List<ItensPrescricao> findByItens(@Param("id")Long id);
	
}
