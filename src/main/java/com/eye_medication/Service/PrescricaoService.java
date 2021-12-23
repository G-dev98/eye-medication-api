package com.eye_medication.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.eye_medication.domain.ItensPrescricao;
import com.eye_medication.domain.Prescricao;
import com.eye_medication.domain.Prontuario;
import com.eye_medication.repositories.PrescricaoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class PrescricaoService {

	
	@Autowired
	private PrescricaoRepository repository;
	
	@Autowired
	private PacienteService pacienteService;
	
	@Autowired
	private ProntuarioService prontuarioService;
	
	@Autowired
	private ItensPrescricaoService itensService;
	
	public Prescricao findById(Long id) throws ObjectNotFoundException {
		Optional<Prescricao> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"	Objeto não encontrado! ID:" + id + "Tipo  " + Prescricao.class.getName()));
	}
	
	public List<Prescricao> findAll() {
		return repository.findAll();
	}
	
	public Prescricao create(Prescricao obj) throws ObjectNotFoundException {
		obj.setId(null);
		//Paciente paciente = pacienteService.findById(obj.getProntuario().getPaciente().getId());
		Prontuario prontuario = prontuarioService.findById(obj.getProntuario().getId());
		Calendar c = Calendar.getInstance();
		
		obj.setDataCriacao(c.getTime());
		obj.setProntuario(prontuario);
		
		prontuarioService.update(prontuario.getId(), obj);
		
		return repository.save(new Prescricao(null,obj.getProntuario(),obj.getDataCriacao()));
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

	public Prescricao update(Long id, ItensPrescricao item) throws ObjectNotFoundException {
		Prescricao obj2 = findById(id);
		List<ItensPrescricao>lista = obj2.getItensPrescricao();
		
		
		//obj2.getItensPrescricao().add(item);
		lista.add(item);
		obj2.setItensPrescricao(lista);
		
		return repository.save(obj2);
	}

	public List<Prescricao> historicoPrescricao(Long id_pront) throws ObjectNotFoundException {
		
		Prontuario prontuario = prontuarioService.findById(id_pront);
		
		return repository.historicoPrescricao(prontuario.getId());
	}

	

	
	
	
}
