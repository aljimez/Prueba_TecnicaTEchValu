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
@RequestMapping(value = "/api")
public class BookController{
	
	@Autowired
	BookServiceImpl bookserviceimpl;
	
	
	@GetMapping("/books")
	public  List<Book> listBooks(){
		return bookserviceimpl.listAllBooks();
	}
	
	//listar Libro por campo nombre
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
		}catch(BadRequestException exDt){
            throw  new BadRequestException(exDt.getMessage());

		}
	}
	
	
	@GetMapping("/books/{id}")
	public Book bookXID(@PathVariable(name="id") Long id) {
		try {
		Book book_xid = new Book();
		
		book_xid=bookserviceimpl.BookXID(id);
		
		System.out.println("Book XID: "+book_xid);
		
		return book_xid;
		}catch(DataAccessException exDt){
            throw  new BadRequestException(exDt.getMessage());

		}
	}
	
	@PutMapping("/books/{id}")
	public Book updateBook(@PathVariable(name="id")Long id,@RequestBody Book book) {
		try {
		Book book_selected= new Book();
		Book book_updated= new Book();
		book_selected= bookserviceimpl.BookXID(id);
		book_selected.setId(book.getId());
		book_selected.setTitle(book.getTitle());
		book_selected.setAuthor(book.getAuthor());
		book_selected.setIsbn(book.getIsbn());
		book_selected.setPublication_date(book.getPublication_date());
		
		book_updated = bookserviceimpl.updateBook(book_selected);
		
		System.out.println("El libro actualizado es: "+ book_updated);
		
		return book_updated;
		}catch(DataAccessException exDt){
            throw  new BadRequestException(exDt.getMessage());

		}
	}
	
	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable(name="id")Long id) {
		try {
		bookserviceimpl.deleteBook(id);
		}catch(DataAccessException exDt){
            throw  new BadRequestException(exDt.getMessage());

		}
	}
	
	
}
		
		
