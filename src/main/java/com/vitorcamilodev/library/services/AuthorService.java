package com.vitorcamilodev.library.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vitorcamilodev.library.dto.AuthorDTO;
import com.vitorcamilodev.library.entities.Author;
import com.vitorcamilodev.library.repositories.AuthorRepository;
import com.vitorcamilodev.library.services.exceptions.DatabaseException;
import com.vitorcamilodev.library.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository repository;

	@Transactional(readOnly = true)
	public AuthorDTO findById(Integer id) {
		Author author = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Author not found at id: " + id));
		return new AuthorDTO(author);
	}

	@Transactional(readOnly = true)
	public List<AuthorDTO> findAll() {
		return repository.findAll().stream().map(x -> new AuthorDTO(x)).collect(Collectors.toList());
	}

	@Transactional
	public AuthorDTO create(AuthorDTO dto) {
		Author author = new Author();
		toEntity(author, dto);
		author = repository.save(author);
		return new AuthorDTO(author);
	}

	@Transactional
	public AuthorDTO update(Integer id, AuthorDTO dto) {
		try {
			Author author = repository.getReferenceById(id);
			toEntity(author, dto);
			author = repository.save(author);
			return new AuthorDTO(author);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Resource not found");
		}
	}

	@Transactional
	public void delete(Integer id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException("Resource not found");
		}
		try {
			repository.deleteById(id);
			repository.flush();
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Referential integrity failure");
		}
	}

	private Author toEntity(Author author, AuthorDTO dto) {
		author.setName(dto.getName());
		author.setNationality(dto.getNationality());
		author.setBirthDate(dto.getBirthDate());
		return author;
	}

}
