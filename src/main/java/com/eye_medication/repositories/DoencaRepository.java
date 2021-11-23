package com.eye_medication.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eye_medication.domain.Doenca;

@Repository
public interface DoencaRepository extends JpaRepository<Doenca, Integer> {
	
	@Query( value = "Select Doenca.id, Doenca.nome, Doenca.descrição FROM Doenca"
			+" left JOIN Doenca_Paciente"
			+ " ON(Doenca.id= Doenca_Paciente.id_doenca)"
			+ " WHERE Doenca_Paciente.Codigo_Paciente = :id_pac "
			+ " ORDER BY Doenca.nome", nativeQuery = true )
	List<Doenca> findByDoencaPaciente(@Param("id_pac")Integer id_pac);
	
}
