package com.eye_medication.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eye_medication.domain.Movimentacao;

@Repository
public interface TipoDeMovimentacaoRepository extends JpaRepository<Movimentacao, Long> {

	@Modifying
	@Query(value = "INSERT INTO HISTORICO (ID_PRONTUARIO,CODIGO_MOVIMENTACAO)"
			+ "VALUES (:id_pront, :id_mov)",nativeQuery = true)
	void gerarHistorico(@Param("id_pront")Long id_pront,@Param("id_mov")Long id_mov);

	
	@Query(value="SELECT MOVIMENTACAO.ID,MOVIMENTACAO.DATA_MOVIMENTACAO,MOVIMENTACAO.TIPO,MOVIMENTACAO.PACIENTE_ID,MOVIMENTACAO.UM_ID"
			+ ",MOVIMENTACAO.PRONTUARIO_ID"
			+ " FROM MOVIMENTACAO"
			+ " LEFT JOIN PRONTUARIO" 
			+ " ON (MOVIMENTACAO.PRONTUARIO_ID = PRONTUARIO.ID)"
			+ " WHERE MOVIMENTACAO.PRONTUARIO_ID = :id_pac",nativeQuery = true)
	List<Movimentacao> historicoMovimentacao(@Param("id_pac")Long id_pac);


	


	
	

	
	
}
