package com.vitorcamilodev.library.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vitorcamilodev.library.dto.LoanDTO;
import com.vitorcamilodev.library.services.LoanService;

@RestController
@RequestMapping("/loans")
public class LoanController {
	
	@Autowired
	private LoanService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<LoanDTO> findById(@PathVariable Integer id) {
		LoanDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}
	
    @GetMapping
    public ResponseEntity<List<LoanDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
    
	@PostMapping
	public ResponseEntity<LoanDTO> insert(@RequestBody LoanDTO dto) {
		dto = service.create(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<LoanDTO> update(@PathVariable Integer id, @RequestBody LoanDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
