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

import com.eye_medication.Service.ProntuarioService;
import com.eye_medication.domain.Prontuario;

import javassist.tools.rmi.ObjectNotFoundException;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/prontuarios")
public class ProntuarioResource {

	@Autowired
	private ProntuarioService service;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Prontuario> findById(@PathVariable Long id) throws ObjectNotFoundException {
		Prontuario obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Prontuario>> findAll() {
		List<Prontuario> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Prontuario> create(@RequestBody Prontuario obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@GetMapping(value= "/historicoMovimentacao/{id}")
	public void historicoMovimentacao(@PathVariable Long pront) throws ObjectNotFoundException {
		//Prontuario list = service.historicoMovimentacao(pac.getId());
		
		service.historicoMovimentacao(pront);
		
	}
}
