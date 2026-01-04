package com.vitorcamilodev.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitorcamilodev.library.dto.LoanDTO;
import com.vitorcamilodev.library.services.LoanService;

@RestController
@RequestMapping("/loans")
public class LoanController {
	
	@Autowired
	private LoanService service;
	
    @GetMapping
    public ResponseEntity<List<LoanDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

}
