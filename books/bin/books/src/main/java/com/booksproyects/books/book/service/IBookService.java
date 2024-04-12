package com.booksproyects.books.book.service;

import java.util.List;

import com.booksproyects.books.book.dto.Book;

public interface IBookService {
//Funciones CRUD
	void deleteBook(Long id);


	Book updateBook(Book book);

	Book BookXID(Long id);

	Book saveBook(Book book);

	List<Book> listAllBooks();

	List<Book> listBookByTitle(String title);

}
