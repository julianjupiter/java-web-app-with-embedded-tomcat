package io.github.julianjupiter.app.repository;

import java.util.Optional;

import io.github.julianjupiter.app.domain.Book;

public interface BookRepository {
	
	Iterable<Book> findAll();

	Optional<Book> findById(long id);
	
}
