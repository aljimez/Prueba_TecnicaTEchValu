package com.booksproyects.books.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booksproyects.books.book.service.BookServiceImpl;

import com.booksproyects.books.book.dto.Book;

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
	    return bookserviceimpl.listBookByTitle(title);
	}
	
	
	@PostMapping("/books")
	public Book saveBook(@RequestBody Book book) {
		
		return bookserviceimpl.saveBook(book);
	}
	
	
	@GetMapping("/books/{id}")
	public Book bookXID(@PathVariable(name="id") Long id) {
		
		Book book_xid = new Book();
		
		book_xid=bookserviceimpl.BookXID(id);
		
		System.out.println("Book XID: "+book_xid);
		
		return book_xid;
	}
	
	@PutMapping("/books/{id}")
	public Book updateBook(@PathVariable(name="id")Long id,@RequestBody Book book) {
		
		Book book_selected= new Book();
		Book book_updated= new Book();
		
		book_selected= bookserviceimpl.BookXID(id);
		
		book_selected.setTitle(book.getTitle());
		book_selected.setAuthor(book.getAuthor());
		book_selected.setId(book.getId());
		book_selected.setpublicationDate(book.getpublicationDate());
		
		book_updated = bookserviceimpl.updateBook(book_selected);
		
		System.out.println("El libro actualizado es: "+ book_updated);
		
		return book_updated;
	}
	
	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable(name="id")Long id) {
		bookserviceimpl.deleteBook(id);
	}
}
		
		
