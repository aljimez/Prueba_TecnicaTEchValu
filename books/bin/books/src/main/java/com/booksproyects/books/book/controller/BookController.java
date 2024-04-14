package com.booksproyects.books.book.controller;

import java.util.List;

import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.booksproyects.books.book.service.BookServiceImpl;

import com.booksproyects.books.book.dto.Book;
import com.booksproyects.books.book.exception.BadRequestException;

@RestController
@RequestMapping("/api")
public class BookController{
	
	@Autowired
	BookServiceImpl bookserviceimpl;
	
	
	@GetMapping("/books")
	public List<Book> listBooks(){
		return bookserviceimpl.listAllBooks();
	}
	
	//listar Clientes por campo nombre
	@GetMapping("/books/title/{title}")
	public List<Book> listBookByTitle(@PathVariable(name="title") String title) {
		try {
	    return bookserviceimpl.listBookByTitle(title);
		}catch(DataAccessException exDt){
            throw  new BadRequestException(exDt.getMessage());

		}
	}
	
		
		
		
	
	
	@PostMapping("/books")
	public Book saveBook(@RequestBody Book book) {
		try {

		return bookserviceimpl.saveBook(book);
		}catch(DataAccessException exDt){
            throw  new BadRequestException(exDt.getMessage());

		}
	}
	
	
	@GetMapping("/books/{isbn}")
	public Book bookXID(@PathVariable(name="isbn") Long isbn) {
		try {

		Book book_xid = new Book();
		
		book_xid=bookserviceimpl.BookXID(isbn);
		
		System.out.println("Book XID: "+book_xid);
		
		return book_xid;
		}catch(DataAccessException exDt){
            throw  new BadRequestException(exDt.getMessage());

		}
	}
	
	@PutMapping("/books/{isbn}")
	public Book updateBook(@PathVariable(name="isbn")Long isbn,@RequestBody Book book) {
		try {
		Book book_selected= new Book();
		Book book_updated= new Book();
		
		book_selected= bookserviceimpl.BookXID(isbn);
		
		book_selected.setTitle(book.getTitle());
		book_selected.setAuthor(book.getAuthor());
		book_selected.setId(book.getId());
		book_selected.setpublicationDate(book.getpublicationDate());
		
		book_updated = bookserviceimpl.updateBook(book_selected);
		
		System.out.println("El libro actualizado es: "+ book_updated);
		
		return book_updated;
		}catch(DataAccessException exDt){
            throw  new BadRequestException(exDt.getMessage());

		}
	}
	
	@DeleteMapping("/books/{isbn}")
	public void deleteBook(@PathVariable(name="isbn")Long isbn) {
		try {
		bookserviceimpl.deleteBook(isbn);
		}catch(DataAccessException exDt){
            throw  new BadRequestException(exDt.getMessage());

		}
	}
	
	
}
		
		
