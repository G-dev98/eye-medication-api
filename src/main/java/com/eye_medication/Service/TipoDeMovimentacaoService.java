package com.eye_medication.Service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eye_medication.domain.TipoDeMovimentacao;
import com.eye_medication.repositories.TipoDeMovimentacaoRepository;

@Service
public class TipoDeMovimentacaoService {
	
	
	@Autowired
	private TipoDeMovimentacaoRepository repository;
	
	
	
	public TipoDeMovimentacao create(TipoDeMovimentacao obj) {
		
				obj.setTipo("Entrada");
				Calendar c = Calendar.getInstance();
				
				obj.setDataEntrada(c.getTime());
				return repository.save(new TipoDeMovimentacao(null, null, obj.getTipo(), obj.getPaciente(),obj.getUM()));
		}



	public TipoDeMovimentacao createSaida(TipoDeMovimentacao obj) {
		obj.setTipo("Saida");
		Calendar c = Calendar.getInstance();
		
		obj.setDataEntrada(c.getTime());
		return repository.save(new TipoDeMovimentacao(null, null, obj.getTipo(), obj.getPaciente(),obj.getUM()));
	}
}
