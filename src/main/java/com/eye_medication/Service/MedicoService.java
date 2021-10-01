package com.eye_medication.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.eye_medication.domain.Medico;
import com.eye_medication.dtos.MedicoDTO;
import com.eye_medication.repositories.MedicoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class MedicoService {

	@Autowired
	private MedicoRepository repository;

	public Medico findById(Integer id) throws ObjectNotFoundException {
		Optional<Medico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"	Objeto não encontrado! ID:" + id + "Tipo  " + Medico.class.getName()));
	}
	
	public List<Medico> findByNomeContaining(String nome) throws ObjectNotFoundException {
		List<Medico> listMedico = repository.findByNomeContaining(nome);
		
		return listMedico;
	}

	public List<Medico> findAll() {
		return repository.findAll();
	}

	public Medico create(Medico obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Medico update(Integer id, MedicoDTO objDto) throws ObjectNotFoundException {
		Medico obj = findById(id);
		obj.setNome(objDto.getNome());
		obj.setCrm(objDto.getCrm());

		return repository.save(obj);

	}

	public void delete(Integer id) throws ObjectNotFoundException {

		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new com.eye_medication.Service.exceptions.DataIntegrityViolationExcepiton(
					"Objeto não pode ser deleta!  Possui objetos associado a ele");
		}
	}

}
