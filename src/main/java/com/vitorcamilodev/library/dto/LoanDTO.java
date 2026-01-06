package com.vitorcamilodev.library.dto;

import java.time.Instant;

import com.vitorcamilodev.library.entities.Loan;
import com.vitorcamilodev.library.entities.enums.LoanStatus;

public class LoanDTO {

	private Integer id;
	private String user;
	private Instant loanDate;
	private Instant returnDate;
	private LoanStatus status;
	private Integer bookId;
	
	public LoanDTO() {

	}
	
	public LoanDTO(Integer id, String user, Instant loanDate, Instant returnDate, LoanStatus status, Integer bookId) {
		this.id = id;
		this.user = user;
		this.loanDate = loanDate;
		this.returnDate = returnDate;
		this.status = status;
		this.bookId = bookId;
	}
	
	public LoanDTO(Loan loan) {
		id = loan.getId();
		user = loan.getUser();
		loanDate = loan.getLoanDate();
		returnDate = loan.getReturnDate();
		status = loan.getStatus();
		bookId = loan.getBook().getId();
	}

	public Integer getId() {
		return id;
	}

	public String getUser() {
		return user;
	}

	public Instant getLoanDate() {
		return loanDate;
	}

	public Instant getReturnDate() {
		return returnDate;
	}

	public LoanStatus getStatus() {
		return status;
	}
	
	public Integer getBookId() {
		return bookId;
	}
	
}
