package com.eye_medication.Service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eye_medication.domain.Movimentacao;
import com.eye_medication.domain.Paciente;
import com.eye_medication.domain.Prontuario;
import com.eye_medication.repositories.TipoDeMovimentacaoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class MovimentacaoService {
	
	
	@Autowired
	private TipoDeMovimentacaoRepository repository;
	
	
	@Autowired
	private PacienteService pacienteService;
	
	@Autowired
	private ProntuarioService prontService;
	
	public List<Movimentacao>findAll(){
		return repository.findAll();
	}
	
	public Movimentacao create(Movimentacao obj) throws ObjectNotFoundException {
				
				Paciente paciente = pacienteService.findById(obj.getPaciente().getId());
		
				//prontuario = prontuarioResource.findById(obj.getPaciente().getProntuario().getId());
		
				obj.setTipo("Entrada");
				Calendar c = Calendar.getInstance();
				
				
				
				obj.setDataEntrada(c.getTime());
				obj.setProntuario(paciente.getProntuario());
				return repository.save(new Movimentacao(null, obj.getDataEntrada(),obj.getTipo(), obj.getPaciente(),obj.getUM(),obj.getProntuario()));
		}



	public Movimentacao createSaida(Movimentacao obj) throws ObjectNotFoundException {
		obj.setTipo("Saida");
		Calendar c = Calendar.getInstance();
		
		Paciente paciente = pacienteService.findById(obj.getPaciente().getId());
		
		obj.setDataEntrada(c.getTime());
		obj.setProntuario(paciente.getProntuario());
		
		
		return repository.save(new Movimentacao(null, obj.getDataEntrada(), obj.getTipo(), obj.getPaciente(),obj.getUM(),obj.getProntuario()));
		
	}

	public List<Movimentacao> historicoMovimentacao(Long id_pac) throws ObjectNotFoundException {
		
		//Long number = (long) 16;
		Prontuario prontuario = prontService.findById(id_pac);
		
		return repository.historicoMovimentacao(prontuario.getId());
	}
	


	

}
