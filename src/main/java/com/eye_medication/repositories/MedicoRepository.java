package com.eye_medication.repositories;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eye_medication.Service.NativeScriptService;
import com.eye_medication.domain.Medico;

@Repository
public interface MedicoRepository extends  JpaRepository <Medico, Integer> {

	/*@Autowired 
	private NativeScriptService nativeScriptService;
	
    public static List<Medico> medicoPorNome(String nomeMedico) {
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT * \n");
        sql.append("FROM medicos   \n");
        sql.append("WHERE \n");
        sql.append("  nome LIKE '" + nomeMedico + "%' \n");
        
		try {
			String busca = new String(sql.toString());
			
			
	        return nativeScriptService.execute(busca);
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		

    }*/
	
	@Query("SELECT m FROM  Medico m WHERE  m.nome LIKE  %?1% order by nome")
	List<Medico> findByNomeContaining(@Param("nome") String nome);
	

}
