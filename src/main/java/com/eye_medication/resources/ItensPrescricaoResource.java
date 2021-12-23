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

import com.eye_medication.Service.ItensPrescricaoService;
import com.eye_medication.domain.ItensPrescricao;

import javassist.tools.rmi.ObjectNotFoundException;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/itens")
public class ItensPrescricaoResource {

	
	@Autowired
	private ItensPrescricaoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ItensPrescricao> findById(@PathVariable Long id) throws ObjectNotFoundException {
		ItensPrescricao obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<ItensPrescricao>> findAll() {
		List<ItensPrescricao> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}


	@PostMapping
	public ResponseEntity<ItensPrescricao> create(@RequestBody ItensPrescricao obj) throws ObjectNotFoundException{
		
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping(value="/prescricao={id}")
	public ResponseEntity<List<ItensPrescricao>> findByItens(@PathVariable Long id) throws ObjectNotFoundException{
		List<ItensPrescricao> list = service.findByItens(id);
		
		return ResponseEntity.ok(list);
	}

}
