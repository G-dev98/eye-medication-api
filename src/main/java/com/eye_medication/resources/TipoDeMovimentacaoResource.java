package com.eye_medication.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.eye_medication.Service.TipoDeMovimentacaoService;
import com.eye_medication.domain.TipoDeMovimentacao;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/tipoDeMovimentacao")
public class TipoDeMovimentacaoResource {

	@Autowired
	private TipoDeMovimentacaoService service;
	
	
	@PostMapping
	public ResponseEntity<TipoDeMovimentacao> create(@RequestBody TipoDeMovimentacao obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PostMapping(value = "/saida")
	public ResponseEntity<TipoDeMovimentacao> createSaida(@RequestBody TipoDeMovimentacao obj) {
		obj = service.createSaida(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
