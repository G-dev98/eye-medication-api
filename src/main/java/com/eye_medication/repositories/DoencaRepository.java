package com.eye_medication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eye_medication.domain.Doenca;

@Repository
public interface DoencaRepository extends JpaRepository<Doenca, Long> {

}
