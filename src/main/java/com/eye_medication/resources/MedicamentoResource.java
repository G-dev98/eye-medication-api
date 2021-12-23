package com.eye_medication.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.eye_medication.Service.MedicamentoService;
import com.eye_medication.domain.Medicamento;

import javassist.tools.rmi.ObjectNotFoundException;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/medicamentos")
public class MedicamentoResource {

	@Autowired
	private MedicamentoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Medicamento> findById(@PathVariable Long id) throws ObjectNotFoundException {
		Medicamento obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Medicamento>> findAll() {
		List<Medicamento> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Medicamento> create(@RequestBody Medicamento obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Medicamento> update(@PathVariable Long id, @Valid @RequestBody Medicamento obj)
			throws ObjectNotFoundException {

		Medicamento newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	
}
