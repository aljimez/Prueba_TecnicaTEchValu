package com.booksproyects.books.book.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.booksproyects.books.book.dto.Book;


public interface IBookDAO extends JpaRepository<Book, Long>{
	
	//Listar clientes or campo nombre
	public List<Book> findByTitle(String title);
	
	
}