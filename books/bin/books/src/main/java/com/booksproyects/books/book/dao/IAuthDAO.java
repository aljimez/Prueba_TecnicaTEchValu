package com.booksproyects.books.book.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booksproyects.books.book.dto.Auth;


public interface IAuthDAO extends JpaRepository<Auth, Long>{
	
	//Listar clientes or campo nombre

	public List<Auth> findByName(String name);

	public Auth save(Auth auth);
	
	
}