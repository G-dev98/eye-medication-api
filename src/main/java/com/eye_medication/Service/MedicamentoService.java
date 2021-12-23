package com.eye_medication.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.eye_medication.domain.Medicamento;
import com.eye_medication.repositories.MedicamentoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class MedicamentoService {

	@Autowired
	private MedicamentoRepository repository;
	
	public Medicamento findById(Long id) throws ObjectNotFoundException {
		Optional<Medicamento> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"	Objeto não encontrado! ID:" + id + "Tipo  " + Medicamento.class.getName()));
	}
	
	public List<Medicamento> findAll() {
		return repository.findAll();
	}
	
	public Medicamento create(Medicamento obj) {
		obj.setId(null);
		return repository.save(obj);
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
	
	public Medicamento update(Long id, Medicamento objDto) throws ObjectNotFoundException {
		
		Medicamento obj = findById(id);
		
		
		return repository.save(obj);

	}
	
}
