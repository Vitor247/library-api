package com.vitorcamilodev.library.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vitorcamilodev.library.dto.BookDTO;
import com.vitorcamilodev.library.entities.Book;
import com.vitorcamilodev.library.repositories.AuthorRepository;
import com.vitorcamilodev.library.repositories.BookRepository;
import com.vitorcamilodev.library.services.exceptions.DatabaseException;
import com.vitorcamilodev.library.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Transactional(readOnly = true)
	public BookDTO findById(Integer id) {
		Book book = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Book not found at id: " + id));
		return new BookDTO(book);
	}
	
	@Transactional(readOnly = true)
	public List<BookDTO> findAll() {
		return repository.findAll().stream().map(x -> new BookDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public BookDTO create(BookDTO dto) {
		Book book = new Book();
		toEntity(book, dto);
		book = repository.save(book);
		return new BookDTO(book);
	}

	@Transactional
	public BookDTO update(Integer id, BookDTO dto) {
		try {
			Book book = repository.getReferenceById(id);
			toEntity(book, dto);
			book = repository.save(book);
			return new BookDTO(book);
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

	private Book toEntity(Book book, BookDTO dto) {
		book.setTitle(dto.getTitle());
		book.setIsbn(dto.getIsbn());
		book.setPublicationYear(dto.getPublicationYear());
		book.setAuthor(authorRepository.getReferenceById(dto.getAuthorId()));
		return book;
	}
	
}
