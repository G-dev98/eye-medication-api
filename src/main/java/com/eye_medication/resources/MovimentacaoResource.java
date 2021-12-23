package com.eye_medication.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.eye_medication.Service.MovimentacaoService;
import com.eye_medication.Service.PacienteService;
import com.eye_medication.domain.Movimentacao;

import javassist.tools.rmi.ObjectNotFoundException;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/movimentacao")
public class MovimentacaoResource {

	@Autowired
	private MovimentacaoService service;
	
	@Autowired
	private PacienteService pacienteService;
	
	@GetMapping
	public ResponseEntity<List<Movimentacao>> findAll() {
		List<Movimentacao> list = service.findAll();
	
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Movimentacao> create(@RequestBody Movimentacao obj) throws ObjectNotFoundException {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PostMapping(value = "/saida")
	public ResponseEntity<Movimentacao> createSaida(@RequestBody Movimentacao obj) throws ObjectNotFoundException {
		obj = service.createSaida(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping(value= "/prontuarios={id}")
	public ResponseEntity<List<Movimentacao>> historicoMovimentacao(@PathVariable Long id) throws ObjectNotFoundException{
		
		List<Movimentacao> list = service.historicoMovimentacao(id);
		return ResponseEntity.ok().body(list); 
	}
	

}
