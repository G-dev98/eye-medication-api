package com.eye_medication.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.eye_medication.Service.MedicoService;
import com.eye_medication.domain.Medico;
import com.eye_medication.dtos.MedicoDTO;

import javassist.tools.rmi.ObjectNotFoundException;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/medicos")
public class MedicoResource {

	@Autowired
	private MedicoService service;
	// Comando no navegador localhost8080/medicos/1

	@GetMapping(value = "/{id}")
	public ResponseEntity<Medico> findById(@PathVariable Integer id) throws ObjectNotFoundException {
		Medico obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}
	

	@GetMapping(value = "/filter")
	public ResponseEntity<List<MedicoDTO>> findById(@RequestParam("nome") String nome) throws ObjectNotFoundException {
		List<Medico> listMedico = service.findByNomeContaining(nome);
		List<MedicoDTO> listDTO = listMedico.stream().map(obj -> new MedicoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	/*
	@GetMapping(value = "/filter")
	public ResponseEntity<List<Medico>> findByNomeContaining(String nome) throws ObjectNotFoundException {
		List<Medico> listMedico = service.findByNomeContaining(nome);
		return ResponseEntity.ok().body(listMedico);
	}*/

	@GetMapping
	public ResponseEntity<List<MedicoDTO>> findAll() {
		List<Medico> list = service.findAll();
		List<MedicoDTO> listDTO = list.stream().map(obj -> new MedicoDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<Medico> create( @RequestBody Medico obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<MedicoDTO> update(@PathVariable Integer id, @RequestBody MedicoDTO objDto)
			throws ObjectNotFoundException {

		/*
		 * Medico newObj = MedicoService.update(id, objDto); return
		 * ResponseEntity.ok(new MedicoDTO(newObj));
		 */
		Medico newObj = service.update(id, objDto);
		return ResponseEntity.ok().body(new MedicoDTO(newObj));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) throws ObjectNotFoundException {

		service.delete(id);
		return ResponseEntity.noContent().build();

	}

}
