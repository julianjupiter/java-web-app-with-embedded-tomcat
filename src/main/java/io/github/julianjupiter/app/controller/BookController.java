package io.github.julianjupiter.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.julianjupiter.app.domain.Book;
import io.github.julianjupiter.app.repository.BookRepositoryImpl;
import io.github.julianjupiter.app.service.BookService;
import io.github.julianjupiter.app.service.BookServiceImpl;

@WebServlet(name = "bookController", urlPatterns = "/books")
public class BookController extends BaseController {

	private static final long serialVersionUID = -8199839431714257029L;
	private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);
	private BookService bookService;
	
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

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = this.getAction(request);
		switch (action) {
			case "create":
				try {
					this.create(request, response);
				} catch (Exception exception) {
					LOGGER.error(exception.getMessage());
				}
				
				break;
			case "update":
				try {
					this.update(request, response);
				} catch (Exception exception) {
					LOGGER.error(exception.getMessage());
				}
				
				break;				
			case "delete":
				try {
					this.delete(request, response);
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
		List<Book> books = this.bookService.findAll();
		request.setAttribute("books", books);
		this.render(request, response, "book/list");
	}
	
	private void findById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		long bookId = Long.parseLong(id);
		Book book = this.bookService.findById(bookId);
		request.setAttribute("book", book);
		this.render(request, response, "book/view");
	}
	
	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		long bookId = Long.parseLong(id);
		Book book = this.bookService.findById(bookId);
		request.setAttribute("book", book);
		this.render(request, response, "book/edit");
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		long bookId = Long.parseLong(id);
		Book book = this.bookService.findById(bookId);
		request.setAttribute("book", book);
		this.render(request, response, "book/edit");
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		long bookId = Long.parseLong(id);
		this.bookService.remove(bookId);
		this.redirect(response, "/book");
	}

}
