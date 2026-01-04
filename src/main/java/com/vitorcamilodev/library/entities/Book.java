package com.vitorcamilodev.library.entities;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String title;
	private String isbn;
	private Year publicationYear;
	
	@ManyToOne 
	@JoinColumn(name = "author_id")
	private Author author;
    
	@OneToMany(mappedBy = "book")
	private List<Loan> loans = new ArrayList<>();
	
	public Book() {

	}

	public Book(Integer id, String title, String isbn, Year publicationYear) {
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.publicationYear = publicationYear;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Year getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(Year publicationYear) {
		this.publicationYear = publicationYear;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Loan> getLoans() {
		return loans;
	}
	
}
