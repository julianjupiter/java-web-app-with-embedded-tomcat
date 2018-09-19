package io.github.julianjupiter.app.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.github.julianjupiter.app.domain.Book;

public class BookRepositoryImpl implements BookRepository {
	
	private static List<Book> bookList = new ArrayList<>();
	
	static {
		Book book1 = new Book();
		book1.setId(1L);
		book1.setTitle("Beginning Spring Boot 2");
		book1.setIsbn("978-1-4842-2930-9");
		book1.setAuthor("K. Siva Prasad Reddy");
		book1.setYearPublished("2017");

		Book book2 = new Book();
		book2.setId(2L);
		book2.setTitle("Effective Java");
		book2.setEdition("Third Edition");
		book2.setIsbn("978-0-13-468599-1");
		book2.setAuthor("Joshua Block");
		book2.setYearPublished("2018");
		
		Book[] books = { book1, book2 };
		bookList = Arrays.asList(books);
	}

	@Override
	public List<Book> findAll() {
		return bookList;
	}

	@Override
	public Book findById(long id) {
		return bookList.stream()
			.filter(book -> book.getId() == id)
			.findFirst().orElse(null);
	}

}
