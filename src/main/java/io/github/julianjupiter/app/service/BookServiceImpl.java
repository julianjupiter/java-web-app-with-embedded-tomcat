package io.github.julianjupiter.app.service;

import java.util.Optional;

import io.github.julianjupiter.app.domain.Book;
import io.github.julianjupiter.app.repository.BookRepository;

public class BookServiceImpl implements BookService {
	
	private BookRepository bookRepository;
	
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public Iterable<Book> findAll() {
		return this.bookRepository.findAll();
	}

	@Override
	public Optional<Book> findById(long id) {
		return this.bookRepository.findById(id);
	}

}
