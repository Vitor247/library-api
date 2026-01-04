package com.vitorcamilodev.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitorcamilodev.library.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	
}
