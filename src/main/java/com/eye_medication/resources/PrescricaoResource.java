package com.eye_medication.resources;

import java.net.URI;
import java.util.List;

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

import com.eye_medication.Service.PrescricaoService;
import com.eye_medication.domain.ItensPrescricao;
import com.eye_medication.domain.Prescricao;

import javassist.tools.rmi.ObjectNotFoundException;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/prescricao")
public class PrescricaoResource {

	@Autowired
	private PrescricaoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Prescricao> findById(@PathVariable Long id) throws ObjectNotFoundException {
		Prescricao obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Prescricao>> findAll() {
		List<Prescricao> list = service.findAll();
		//List<PrescricaoDTO> listDTO = list.stream().map(obj -> new PrescricaoDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Prescricao> create(@RequestBody Prescricao obj) throws ObjectNotFoundException {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Prescricao> update(@PathVariable Long id, @RequestBody ItensPrescricao objDto)
			throws ObjectNotFoundException {

		Prescricao newObj = service.update(id, objDto);
		return ResponseEntity.ok().body(newObj);
	}
	
	@GetMapping(value="/prontuario={id_pront}")
	public ResponseEntity<List<Prescricao>> historicoPrescricao(@PathVariable Long id_pront) throws ObjectNotFoundException{
		List<Prescricao> list = service.historicoPrescricao(id_pront);
		
		return ResponseEntity.ok().body(list);
		
	}
	
	
}
