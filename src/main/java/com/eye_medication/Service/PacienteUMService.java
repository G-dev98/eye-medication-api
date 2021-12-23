package com.eye_medication.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.eye_medication.domain.Movimentacao;
import com.eye_medication.domain.PacienteUM;
import com.eye_medication.repositories.PacienteUMRepository;
import com.eye_medication.resources.MovimentacaoResource;
import com.eye_medication.resources.PacienteResource;
import com.eye_medication.resources.UnidadeMedicaResource;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class PacienteUMService {

	
	@Autowired
	private PacienteUMRepository repository;
	
	@Autowired
	private MovimentacaoResource tipoDeMovimentacaoResource;
	
	@Autowired
	private UnidadeMedicaResource umResource;
	
	@Autowired
	private PacienteResource pacienteResource;
	
	
	
	public PacienteUM findById(Long id) throws ObjectNotFoundException {
		Optional<PacienteUM> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"	Objeto não encontrado! ID:" + id + "Tipo  " + PacienteUM.class.getName()));
	}
	
	public List<PacienteUM> findAll() {
		return repository.findAll();
	}
	
	public PacienteUM create(PacienteUM obj) throws ObjectNotFoundException {
		
		//PacienteUM obj2 = obj;
		if(findByDisponibilidade(obj) != null ) {
			
			throw new DataIntegrityViolationException("Leito selecionado já está ocupado");
		}
		if (findByPacienteUM(obj) != null) {
			throw new DataIntegrityViolationException("Paciente selecionado já está em alguam Unidade Medica");
		}
		
			
			Movimentacao entrada = new Movimentacao(null,obj.getDataMovimentacao(),null,obj.getPaciente(),obj.getUnidadeMedica(),null);
			tipoDeMovimentacaoResource.create(entrada);
			
			
			obj.getUnidadeMedica().setStatus("Ocupado");
			
			obj.getPaciente().setStatus("Internado");
			
			
			pacienteResource.updatePatch(obj.getPaciente().getId(),obj.getPaciente());
			umResource.update(obj.getUnidadeMedica().getId(),obj.getUnidadeMedica());
			
			Calendar c = Calendar.getInstance();
			
			
			obj.setDataMovimentacao(c.getTime());
			
			
			
			
			return repository.save(new PacienteUM(null,c.getTime(),obj.getPaciente(),obj.getUnidadeMedica()));
	}
	
	
	private PacienteUM findByDisponibilidade(PacienteUM disponibilidade) {
		
		PacienteUM obj = repository.findByDisponibilidade(disponibilidade.getUnidadeMedica().getId());
		
		if(obj != null) {
			return obj;
		}else {
			return null;
		}
	}
	
	private PacienteUM findByPacienteUM(PacienteUM pacienteIT) {
		PacienteUM obj = repository.findByPacienteUM(pacienteIT.getPaciente().getId());
		
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
		
		findById(id);
		PacienteUM obj = findById(id);
		try {
			
			Movimentacao saida = new Movimentacao(null,obj.getDataMovimentacao(),null,obj.getPaciente(),obj.getUnidadeMedica(),null);
			tipoDeMovimentacaoResource.createSaida(saida);
			
			
			obj.getPaciente().setStatus("Sem quarto");
			
			
			pacienteResource.updatePatch(obj.getPaciente().getId(),obj.getPaciente());
			umResource.update(obj.getUnidadeMedica().getId(),obj.getUnidadeMedica());
			
			obj.getUnidadeMedica().setStatus("Disponivel");
			umResource.update(obj.getUnidadeMedica().getId(),obj.getUnidadeMedica());
			
			repository.deleteById(id);
			
		} catch (DataIntegrityViolationException e) {
			throw new com.eye_medication.Service.exceptions.DataIntegrityViolationExcepiton(
					"Objeto não pode ser deletado!  Possui objetos associados a ele");
		}
	}
}
