package io.github.julianjupiter.app.service;

import java.util.Optional;

import io.github.julianjupiter.app.domain.Book;

public interface BookService {
	
	Iterable<Book> findAll();

	Optional<Book> findById(long id);
	
}
