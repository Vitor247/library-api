package com.vitorcamilodev.library.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vitorcamilodev.library.dto.AuthorDTO;
import com.vitorcamilodev.library.services.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {
	
	@Autowired
	private AuthorService service;
	
    @GetMapping
    public ResponseEntity<List<AuthorDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
    
	@GetMapping(value = "/{id}")
	public ResponseEntity<AuthorDTO> findById(@PathVariable Integer id) {
		AuthorDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}

	@PostMapping
	public ResponseEntity<AuthorDTO> insert(@RequestBody AuthorDTO dto) {
		dto = service.create(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
}
