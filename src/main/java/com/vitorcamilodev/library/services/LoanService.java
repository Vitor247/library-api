package com.vitorcamilodev.library.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vitorcamilodev.library.dto.LoanDTO;
import com.vitorcamilodev.library.repositories.LoanRepository;

@Service
public class LoanService {

	@Autowired
	private LoanRepository repository;

	@Transactional(readOnly = true)
	public List<LoanDTO> findAll() {
		return repository.findAll().stream().map(x -> new LoanDTO(x)).collect(Collectors.toList());
	}

}
