package com.eye_medication.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eye_medication.domain.ItensPrescricao;
import com.eye_medication.domain.Prescricao;
import com.eye_medication.domain.Prontuario;
import com.eye_medication.repositories.ProntuarioRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ProntuarioService {

	@Autowired
	private ProntuarioRepository repository;
	
	@Autowired
	private MovimentacaoService movimentacaoService;
	
	public Prontuario findById(Long id) throws ObjectNotFoundException {
		Optional<Prontuario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"	Objeto não encontrado! ID:" + id + "Tipo  " + Prontuario.class.getName()));
	}
	
	public List<Prontuario> findAll() {
		return repository.findAll();
	}
	
	public void historicoMovimentacao( Long integer) throws ObjectNotFoundException {
		movimentacaoService.historicoMovimentacao(integer);
		
	}
	
	public Prontuario create(Prontuario obj) {
		obj.setId(null);
		Calendar c = Calendar.getInstance();
		obj.setDataCriacao(c.getTime());
		return repository.save(obj);
	}
	
	public Prontuario update(Long id, Prescricao item) throws ObjectNotFoundException {
		Prontuario obj2 = findById(id);
		List<Prescricao>lista = obj2.getPrescricao();
		
		
		//obj2.getItensPrescricao().add(item);
		lista.add(item);
		obj2.setPrescricao(lista);
		
		return repository.save(obj2);
	}

}
