package com.booksproyects.books.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.booksproyects.books.book.dao.IBookDAO;
import com.booksproyects.books.book.dto.Book;

@Service
public class BookServiceImpl implements IBookService{
	
//Usamos los métodos de IBookService
	@Autowired
	IBookDAO iBookDAO;
	
	@Override
	public List<Book> listAllBooks() {
		
		return iBookDAO.findAll();
	}

	@Override
	public Book saveBook(Book book) {
		
		return iBookDAO.save(book);
	}

	@Override
	public Book BookXID(Long id) {
		
		return iBookDAO.findById(id).get();
	}
	

	@Override
	public Book updateBook(Book book) {
		
		return iBookDAO.save(book);
	}

	@Override
	public void deleteBook(Long id) {
		
		iBookDAO.deleteById(id);
		
	}


	@Override
	public List<Book> listBookByTitle(String title) {
		
		return iBookDAO.findByTitle(title);
	}

	public List<Book> listAllBooksISBNSortedAsc() {
		// TODO Auto-generated method stub
		return iBookDAO.findAll(Sort.by("isbn").ascending());
	}

	public List<Book> listAllBooksISBNSortedDesc() {
		// TODO Auto-generated method stub
		return iBookDAO.findAll(Sort.by("isbn").descending());
	}

}
