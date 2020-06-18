package io.github.julianjupiter.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZonedDateTime;
import java.util.Optional;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.julianjupiter.app.domain.Book;
import io.github.julianjupiter.app.repository.BookRepositoryImpl;
import io.github.julianjupiter.app.service.BookService;
import io.github.julianjupiter.app.service.BookServiceImpl;
import io.github.julianjupiter.app.util.Error;
import io.github.julianjupiter.app.util.ErrorResponse;

@WebServlet(name = "bookController", urlPatterns = "/books")
public class BookController extends BaseController {

	private static final long serialVersionUID = -8199839431714257029L;
	private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);
	private final BookService bookService;
	
	public BookController() {
		this.bookService = new BookServiceImpl(new BookRepositoryImpl());
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = this.getAction(request);
		switch (action) {
			case "": 
			case "list":
				try {
					this.findAll(request, response);
				} catch (Exception exception) {
					LOGGER.error(exception.getMessage());
				}
				
				break;
			case "view":
				try {
					this.findById(request, response);
				} catch (Exception exception) {
					LOGGER.error(exception.getMessage());
				}
				
				break;
	
			default:
				try {
					response.setStatus(404);
					this.render(request, response, "error/404");
				} catch (Exception exception) {
					LOGGER.error(exception.getMessage());
				}
				
				break;
		}
		
	}
	
	private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Iterable<Book> books = this.bookService.findAll();
		request.setAttribute("pageName", "Books");
		request.setAttribute("books", books);
		this.render(request, response, "book/list");
	}
	
	private void findById(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		long bookId = Long.parseLong(id);
		Optional<Book> book = this.bookService.findById(bookId);
		String bookJson;
		try(Jsonb jsonbObject = JsonbBuilder.create()) {
			if (book.isPresent()) {
				response.setStatus(200);
				bookJson = jsonbObject.toJson(book.get());
			} else {
				response.setStatus(404);
				ErrorResponse errorResponse = new ErrorResponse();
				Error error = new Error();
				error.setMessage("Book with ID " + id + " was not found.");
				error.setCreatedAt(ZonedDateTime.now());
				errorResponse.setError(error);
				bookJson = jsonbObject.toJson(error);
			}
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(bookJson);
		out.flush();
	}

}
