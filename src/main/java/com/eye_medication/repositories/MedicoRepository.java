package com.eye_medication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eye_medication.domain.Medico;

@Repository
public interface MedicoRepository extends  JpaRepository <Medico, Integer> {

}
