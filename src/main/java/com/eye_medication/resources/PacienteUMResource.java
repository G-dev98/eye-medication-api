package com.eye_medication.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.eye_medication.Service.PacienteUMService;
import com.eye_medication.domain.PacienteUM;

import javassist.tools.rmi.ObjectNotFoundException;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/pacientesUM")
public class PacienteUMResource {

	
	@Autowired
	private PacienteUMService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PacienteUM> findById(@PathVariable Long id) throws ObjectNotFoundException {
		PacienteUM obj = service.findById(id); 
		return ResponseEntity.ok(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<PacienteUM>> findAll() {
		List<PacienteUM> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<PacienteUM> update(@PathVariable Long id, @Valid @RequestBody PacienteUM obj)
			throws ObjectNotFoundException {

		PacienteUM newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@PostMapping
	public ResponseEntity<PacienteUM> create(@RequestBody PacienteUM obj) throws ObjectNotFoundException {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) throws ObjectNotFoundException {

		service.delete(id);
		return ResponseEntity.noContent().build();

	}
}
