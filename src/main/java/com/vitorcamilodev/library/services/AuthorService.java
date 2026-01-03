package com.vitorcamilodev.library.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vitorcamilodev.library.dto.AuthorDTO;
import com.vitorcamilodev.library.repositories.AuthorRepository;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository repository;
	
	@Transactional(readOnly = true)
    public List<AuthorDTO> findAll() {
        return repository.findAll().stream()
                .map(x -> new AuthorDTO(x))
                .collect(Collectors.toList());
    }

}
