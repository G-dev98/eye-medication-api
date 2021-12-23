package com.eye_medication.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.eye_medication.domain.Paciente;
import com.eye_medication.domain.UnidadeMedica;
import com.eye_medication.repositories.UnidadeMedicaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class UnidadeMedicaService {

	@Autowired
	private UnidadeMedicaRepository repository;
	
	public UnidadeMedica findById(Long id) throws ObjectNotFoundException {
		Optional<UnidadeMedica> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"	Objeto não encontrado! ID:" + id + "Tipo  " + Paciente.class.getName()));
	}
	
	public List<UnidadeMedica> findAll() {
		return repository.findAll();
	}
	
	public UnidadeMedica create(UnidadeMedica obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	

	
	public UnidadeMedica update(Long id, UnidadeMedica obj) throws ObjectNotFoundException {
		
		UnidadeMedica obj2 = findById(id);
		
		obj2.setStatus(obj.getStatus());
		
		return repository.save(obj2);

	}
	
	public void delete(Long id) throws ObjectNotFoundException {

		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new com.eye_medication.Service.exceptions.DataIntegrityViolationExcepiton(
					"Objeto não pode ser deleta!  Possui objetos associado a ele");
		}
	}
	
	
	public List<UnidadeMedica> findByUmDisponivel(){
		return repository.findByUmDisponivel();
	}
	
}
