package com.eye_medication.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.eye_medication.domain.Paciente;
import com.eye_medication.repositories.PacienteRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository repository;
	
	
	public Paciente findById(Integer id) throws ObjectNotFoundException {
		Optional<Paciente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"	Objeto não encontrado! ID:" + id + "Tipo  " + Paciente.class.getName()));
	}
	
	public List<Paciente> findAll() {
		return repository.findAll();
	}
	
	public Paciente create(Paciente obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	

	
	public Paciente update(Integer id, Paciente objDto) throws ObjectNotFoundException {
		
		Paciente obj = findById(id);
		obj.setNome(objDto.getNome());
		obj.setCpf(objDto.getCpf());
		obj.setTelefone(objDto.getTelefone());
		obj.setEndereco(objDto.getEndereco());
		obj.setDataNascimento(objDto.getTelefone());
		obj.setNaturalidade(objDto.getNaturalidade());
		obj.setNomeMae(objDto.getNomeMae());
		obj.setSexo(objDto.getSexo());
		obj.setStatus(objDto.getStatus());
		obj.setDoencas(objDto.getDoencas());
		
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

	@Transactional
	public void desatrelarDoenca(Integer id, Integer id2) throws ObjectNotFoundException {
		repository.desatrelarDoenca(id,id2);	
	}

	@Transactional
	public void atribuirDoenca(Integer id, Integer id_doe) throws ObjectNotFoundException {
			repository.atribuirDoenca(id,id_doe);
		
	}
	

	
	
}
