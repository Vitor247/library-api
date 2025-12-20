package com.vitorcamilodev.library.entities;

import java.time.Instant;

import com.vitorcamilodev.library.entities.enums.LoanStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_loan")
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
    @Column(name = "user_name")
	private String user;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant loanDate;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant returnDate;

	@Enumerated(EnumType.STRING)
	private LoanStatus status;
	
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    
	public Loan() {

	}

	public Loan(Integer id, String user, Instant loanDate, Instant returnDate, LoanStatus status) {
		this.id = id;
		this.user = user;
		this.loanDate = loanDate;
		this.returnDate = returnDate;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Instant getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(Instant loanDate) {
		this.loanDate = loanDate;
	}

	public Instant getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Instant returnDate) {
		this.returnDate = returnDate;
	}

	public LoanStatus getStatus() {
		return status;
	}

	public void setStatus(LoanStatus status) {
		this.status = status;
	}
	
}
