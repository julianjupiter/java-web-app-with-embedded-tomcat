package io.github.julianjupiter.app.repository;

import java.util.List;

import io.github.julianjupiter.app.domain.Book;

public interface BookRepository {
	List<Book> findAll();

	Book findById(long id);

	void save(Book book);

	void remove(long id);
}
