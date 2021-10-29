package com.eye_medication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eye_medication.domain.UnidadeMedica;

@Repository
public interface UnidadeMedicaRepository extends JpaRepository<UnidadeMedica, Long> {

}
