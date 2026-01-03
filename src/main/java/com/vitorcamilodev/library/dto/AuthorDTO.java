package com.vitorcamilodev.library.dto;

import java.util.Date;

import com.vitorcamilodev.library.entities.Author;

public class AuthorDTO {

	private Integer id;
	private String name;
	private String nationality;
	private Date birthDate;

	public AuthorDTO(Integer id, String name, String nationality, Date birthDate) {
		this.id = id;
		this.name = name;
		this.nationality = nationality;
		this.birthDate = birthDate;
	}
	
	public AuthorDTO(Author author) {
		id = author.getId();
		name = author.getName();
		nationality = author.getNationality();
		birthDate = author.getBirthDate();
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getNationality() {
		return nationality;
	}

	public Date getBirthDate() {
		return birthDate;
	}
	
}
