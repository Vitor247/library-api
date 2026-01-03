package com.vitorcamilodev.library.dto;

import java.time.Year;

public class BookDTO {

	private Integer id;
	private String title;
	private String isbn;
	private Year publicationYear;
	private Long authorId;

	public BookDTO(Integer id, String title, String isbn, Year publicationYear, Long authorId) {
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.publicationYear = publicationYear;
		this.authorId = authorId;
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

	public Long getAuthorId() {
		return authorId;
	}
	
}
