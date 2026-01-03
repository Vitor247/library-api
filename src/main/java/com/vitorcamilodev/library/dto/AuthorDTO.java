package com.vitorcamilodev.library.dto;

import java.util.Date;

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
