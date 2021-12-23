package com.eye_medication.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.eye_medication.domain.ItensPrescricao;
import com.eye_medication.domain.Prescricao;
import com.eye_medication.repositories.ItensPrescricaoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ItensPrescricaoService {

	@Autowired
	private ItensPrescricaoRepository repository;
	
	@Autowired
	private PrescricaoService prescricaoService;
	
	public ItensPrescricao findById(Long id) throws ObjectNotFoundException {
		Optional<ItensPrescricao> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"	Objeto não encontrado! ID:" + id + "Tipo  " + ItensPrescricao.class.getName()));
	}
	
	
	public ItensPrescricao update(Long id, ItensPrescricao obj1) throws ObjectNotFoundException {
		//ItensPrescricao obj = findById(id);
		Prescricao prescricao = prescricaoService.findById(obj1.getPrescricao().getId());
		obj1.setPrescricao(prescricao);

		
		
		
		return repository.save(obj1);

	}

	
	public List<ItensPrescricao> findAll() {
		return repository.findAll();
	}
	
	public ItensPrescricao create(ItensPrescricao obj) throws ObjectNotFoundException {
		
		obj.setId(null);
		if(obj.getPrescricao() == null) {
			System.out.println("prescrição igual a nulo");
		}
		
		Prescricao prescricao = prescricaoService.findById(obj.getPrescricao().getId());
		
		
		prescricaoService.update(obj.getPrescricao().getId(), obj);
		//obj.setPrescricao(prescricao);
		
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
	
	public List<ItensPrescricao> findByItens(Long id) throws ObjectNotFoundException {
			
			Prescricao prescricao = prescricaoService.findById(id);
			
			return repository.findByItens(prescricao.getId());
	}
		
	
}
