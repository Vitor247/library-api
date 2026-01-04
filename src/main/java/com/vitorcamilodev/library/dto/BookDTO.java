package com.vitorcamilodev.library.dto;

import java.time.Year;

import com.vitorcamilodev.library.entities.Book;

public class BookDTO {

	private Integer id;
	private String title;
	private String isbn;
	private Year publicationYear;
	private Integer authorId;

	public BookDTO(Integer id, String title, String isbn, Year publicationYear, Integer authorId) {
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.publicationYear = publicationYear;
		this.authorId = authorId;
	}

	public BookDTO(Book book) {
		this.id = book.getId();
		this.title = book.getTitle();
		this.isbn = book.getIsbn();
		this.publicationYear = book.getPublicationYear();
		this.authorId = book.getAuthor().getId();
	}

	public Integer getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getIsbn() {
		return isbn;
	}

	public Year getPublicationYear() {
		return publicationYear;
	}

	public Integer getAuthorId() {
		return authorId;
	}
	
}
