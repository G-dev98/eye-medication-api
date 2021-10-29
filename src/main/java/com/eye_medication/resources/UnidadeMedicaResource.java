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

import com.eye_medication.Service.UnidadeMedicaService;
import com.eye_medication.domain.UnidadeMedica;

import javassist.tools.rmi.ObjectNotFoundException;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/unidadesMedicas")
public class UnidadeMedicaResource {

	@Autowired
	private UnidadeMedicaService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<UnidadeMedica> findById(@PathVariable Long id) throws ObjectNotFoundException {
		UnidadeMedica obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}

	@GetMapping
	public ResponseEntity<List<UnidadeMedica>> findAll() {
		List<UnidadeMedica> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<UnidadeMedica> create(@RequestBody UnidadeMedica obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<UnidadeMedica> update(@PathVariable Long id, @Valid @RequestBody UnidadeMedica objDto)
			throws ObjectNotFoundException {

		/*
		 * Medico newObj = MedicoService.update(id, objDto); return
		 * ResponseEntity.ok(new MedicoDTO(newObj));
		 */
		UnidadeMedica newObj = service.update(id, objDto);
		return ResponseEntity.ok().body(newObj);
	}
	
}
