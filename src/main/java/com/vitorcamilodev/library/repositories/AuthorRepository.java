package com.vitorcamilodev.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitorcamilodev.library.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{
	
}
