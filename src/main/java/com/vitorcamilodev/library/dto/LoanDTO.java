package com.vitorcamilodev.library.dto;

import java.time.Instant;

import com.vitorcamilodev.library.entities.enums.LoanStatus;

public class LoanDTO {

	private Integer id;
	private String user;
	private Instant loanDate;
	private Instant returnDate;
	private LoanStatus status;
	
	public LoanDTO(Integer id, String user, Instant loanDate, Instant returnDate, LoanStatus status) {
		this.id = id;
		this.user = user;
		this.loanDate = loanDate;
		this.returnDate = returnDate;
		this.status = status;
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
	
}
