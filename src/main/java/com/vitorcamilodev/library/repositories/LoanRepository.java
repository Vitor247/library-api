package com.vitorcamilodev.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitorcamilodev.library.entities.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long>{
	
}
