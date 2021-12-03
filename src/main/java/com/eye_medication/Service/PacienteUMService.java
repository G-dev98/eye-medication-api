package com.eye_medication.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.eye_medication.domain.TipoDeMovimentacao;
import com.eye_medication.domain.PacienteUM;
import com.eye_medication.repositories.PacienteUMRepository;
import com.eye_medication.resources.TipoDeMovimentacaoResource;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class PacienteUMService {

	
	@Autowired
	private PacienteUMRepository repository;
	
	@Autowired
	private TipoDeMovimentacaoResource tipoDeMovimentacaoResource;
	
	
	
	public PacienteUM findById(Long id) throws ObjectNotFoundException {
		Optional<PacienteUM> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"	Objeto não encontrado! ID:" + id + "Tipo  " + PacienteUM.class.getName()));
	}
	
	public List<PacienteUM> findAll() {
		return repository.findAll();
	}
	
	public PacienteUM create(PacienteUM obj) {
		
		if(findByDisponibilidade(obj) != null) {
			throw new DataIntegrityViolationException("Leito selecionado já está ocupado");
		}
			TipoDeMovimentacao entrada = new TipoDeMovimentacao(null,obj.getDataMovimentacao(),null,obj.getPaciente(),obj.getUnidadeMedica());
			tipoDeMovimentacaoResource.create(entrada);
			
			Calendar c = Calendar.getInstance();
			
			obj.setDataMovimentacao(c.getTime());
			return repository.save(new PacienteUM(null,obj.getDataMovimentacao(),obj.getPaciente(),obj.getUnidadeMedica()));
	}
	
	
	private PacienteUM findByDisponibilidade(PacienteUM disponibilidade) {
		
		PacienteUM obj = repository.findByDisponibilidade(disponibilidade.getUnidadeMedica().getId());
		
		if(obj != null) {
			return obj;
		}else {
			return null;
		}
	}
	
	public PacienteUM update(Long id, PacienteUM objDto) throws ObjectNotFoundException {
			
			PacienteUM obj = findById(id);
			obj.setDataMovimentacao(objDto.getDataMovimentacao());
			obj.setPaciente(objDto.getPaciente());
			obj.setUnidadeMedica(objDto.getUnidadeMedica());
			
			return repository.save(obj);
	
		}
	
	public void delete(Long id) throws ObjectNotFoundException {
	
		try {
			
			PacienteUM obj = findById(id);
			TipoDeMovimentacao saida = new TipoDeMovimentacao(null,obj.getDataMovimentacao(),null,obj.getPaciente(),obj.getUnidadeMedica());
			tipoDeMovimentacaoResource.createSaida(saida);
			repository.deleteById(id);
			
		} catch (DataIntegrityViolationException e) {
			throw new com.eye_medication.Service.exceptions.DataIntegrityViolationExcepiton(
					"Objeto não pode ser deletado!  Possui objetos associados a ele");
		}
	}
}
