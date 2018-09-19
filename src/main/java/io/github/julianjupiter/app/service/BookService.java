package io.github.julianjupiter.app.service;

import java.util.List;

import io.github.julianjupiter.app.domain.Book;

public interface BookService {
	
	List<Book> findAll();

	Book findById(long id);
	
}
