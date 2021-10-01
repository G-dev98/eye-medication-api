package com.eye_medication.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eye_medication.domain.Medico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class NativeScriptService {
	
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Medico> execute(String sql){
       return entityManager.createQuery(sql, Medico.class) .getResultList();
    }
}
