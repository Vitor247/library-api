package com.vitorcamilodev.library.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vitorcamilodev.library.dto.BookDTO;
import com.vitorcamilodev.library.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;

	@Transactional(readOnly = true)
	public List<BookDTO> findAll() {
		return repository.findAll().stream().map(x -> new BookDTO(x)).collect(Collectors.toList());
	}

}
