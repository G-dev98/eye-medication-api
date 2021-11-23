package com.eye_medication.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.eye_medication.domain.Doenca;
import com.eye_medication.domain.Paciente;
import com.eye_medication.repositories.DoencaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class DoencaService {

	@Autowired
	private DoencaRepository repository;
	
	@Autowired
	private PacienteService pacienteService;
	
	public Doenca findById(Integer id) throws ObjectNotFoundException {
		Optional<Doenca> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"	Objeto não encontrado! ID:" + id + "Tipo  " + Paciente.class.getName()));
	}
	
	public List<Doenca> findAll() {
		return repository.findAll();
	}
	
	
	
	public Doenca create(Doenca obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	

	
	public Doenca update(Integer id, Doenca objDto) throws ObjectNotFoundException {
		
		Doenca obj = findById(id);
		
		obj.setNome(objDto.getNome());
		obj.setDescrição(objDto.getDescrição());
		
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

	public List<Doenca> findByPaciente(Integer id_pac) throws ObjectNotFoundException {
		//List<Doenca> listDoencaPc = repository.findByDoencaPaciente(id_pac);
		pacienteService.findById(id_pac);
		//List<Medico> listMedico = repository.findByNomeContaining(nome);
		return repository.findByDoencaPaciente(id_pac);
	
	}
	
	
}
