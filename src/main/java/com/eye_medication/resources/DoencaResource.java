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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.eye_medication.Service.DoencaService;
import com.eye_medication.domain.Doenca;

import javassist.tools.rmi.ObjectNotFoundException;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/doencas")
public class DoencaResource {

	@Autowired
	private DoencaService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Doenca> findById(@PathVariable Integer id) throws ObjectNotFoundException {
		Doenca obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Doenca>> findAll() {
		List<Doenca> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}
	
	
	@GetMapping(value= "/dp")
	public ResponseEntity<List<Doenca>> findByAllPaciente(@RequestParam(value = "paciente", defaultValue = "0" )Integer id_pac) throws ObjectNotFoundException{
		//localhost:8080/doencas?paciente= 1 
		List<Doenca> list = service.findByPaciente(id_pac);
		return ResponseEntity.ok().body(list); 
	}
	
	@PostMapping
	public ResponseEntity<Doenca> create(@RequestBody Doenca obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Doenca> update(@PathVariable Integer id, @Valid @RequestBody Doenca objDto)
			throws ObjectNotFoundException {

		/*
		 * Medico newObj = MedicoService.update(id, objDto); return
		 * ResponseEntity.ok(new MedicoDTO(newObj));
		 */
		Doenca newObj = service.update(id, objDto);
		return ResponseEntity.ok().body(newObj);
	}
	
	

}
