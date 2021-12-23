package com.eye_medication.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.eye_medication.Service.PacienteService;
import com.eye_medication.domain.Paciente;
import com.eye_medication.dtos.PacienteDTO;

import javassist.tools.rmi.ObjectNotFoundException;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/pacientes")
public class PacienteResource {

	@Autowired
	private PacienteService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Paciente> findById(@PathVariable Integer id) throws ObjectNotFoundException {
		Paciente obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}

	@GetMapping
	public ResponseEntity<List<PacienteDTO>> findAll() {
		List<Paciente> list = service.findAll();
		List<PacienteDTO> listDTO = list.stream().map(obj -> new PacienteDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<Paciente> create(@RequestBody Paciente obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Paciente> update(@PathVariable Integer id, @Valid @RequestBody Paciente objDto)
			throws ObjectNotFoundException {

		Paciente newObj = service.update(id, objDto);
		return ResponseEntity.ok().body(newObj);
	}

	@PatchMapping(value = "/{id}")
	public ResponseEntity<Paciente> updatePatch(@PathVariable Integer id, @Valid @RequestBody Paciente objDto)
			throws ObjectNotFoundException {

		Paciente newObj = service.updatePacth(id, objDto);
		return ResponseEntity.ok().body(newObj);
	}

	@Transactional
	@DeleteMapping(value = "/{id}/id_doenca/{id_doe}")
	public ResponseEntity<Void> desatrelarDoenca(@PathVariable Integer id, @PathVariable Integer id_doe)
			throws ObjectNotFoundException {
		service.desatrelarDoenca(id, id_doe);
		return ResponseEntity.noContent().build();
	}

	@Transactional
	@PatchMapping(value = "/{id}/add/{id_doe}")
	public ResponseEntity<Void> atribuirDoenca(@PathVariable Integer id, @PathVariable Integer id_doe)
			throws ObjectNotFoundException {

		service.atribuirDoenca(id, id_doe);

		return ResponseEntity.noContent().build();

	}
	
	@GetMapping(value ="/Status" )
	public ResponseEntity<List<Paciente>> findByStatus(){
		List<Paciente> list = service.findByStatus();
		return ResponseEntity.ok().body(list);
	}

}
