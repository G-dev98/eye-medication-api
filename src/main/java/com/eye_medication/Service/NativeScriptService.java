package com.eye_medication.Service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eye_medication.domain.Medico;

@Service
public class NativeScriptService {
	
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Medico> execute(String sql){
       return entityManager.createQuery(sql, Medico.class) .getResultList();
    }
    
   
    
}
