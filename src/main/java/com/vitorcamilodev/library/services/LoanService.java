package com.vitorcamilodev.library.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vitorcamilodev.library.dto.LoanDTO;
import com.vitorcamilodev.library.entities.Loan;
import com.vitorcamilodev.library.repositories.BookRepository;
import com.vitorcamilodev.library.repositories.LoanRepository;
import com.vitorcamilodev.library.services.exceptions.DatabaseException;
import com.vitorcamilodev.library.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LoanService {

	@Autowired
	private LoanRepository repository;
	
	@Autowired
	private BookRepository bookRepository;

	@Transactional(readOnly = true)
	public LoanDTO findById(Integer id) {
		Loan loan = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Loan not found at id: " + id));
		return new LoanDTO(loan);
	}
	
	@Transactional(readOnly = true)
	public List<LoanDTO> findAll() {
		return repository.findAll().stream().map(x -> new LoanDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public LoanDTO create(LoanDTO dto) {
		Loan loan = new Loan();
		toEntity(loan, dto);
		loan = repository.save(loan);
		return new LoanDTO(loan);
	}

	@Transactional
	public LoanDTO update(Integer id, LoanDTO dto) {
		try {
			Loan loan = repository.getReferenceById(id);
			toEntity(loan, dto);
			loan = repository.save(loan);
			return new LoanDTO(loan);
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

	private Loan toEntity(Loan loan, LoanDTO dto) {
		loan.setUser(dto.getUser());
		loan.setLoanDate(dto.getLoanDate());
		loan.setReturnDate(dto.getReturnDate());
		loan.setStatus(dto.getStatus());
		loan.setBook(bookRepository.getReferenceById(dto.getBookId()));
		return loan;
	}

}
