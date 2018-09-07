package io.github.julianjupiter.app.service;

import java.util.List;

import io.github.julianjupiter.app.domain.Book;
import io.github.julianjupiter.app.repository.BookRepository;

public class BookServiceImpl implements BookService {
	
	private BookRepository bookRepository;
	
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public List<Book> findAll() {
		return this.bookRepository.findAll();
	}

	@Override
	public Book findById(long id) {
		return this.bookRepository.findById(id);
	}

	@Override
	public void save(Book book) {
		this.bookRepository.save(book);
	}

	@Override
	public void remove(long id) {
		this.bookRepository.remove(id);
	}

}
