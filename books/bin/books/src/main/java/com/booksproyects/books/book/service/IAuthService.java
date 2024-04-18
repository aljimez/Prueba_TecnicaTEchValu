package com.booksproyects.books.book.service;

import java.util.List;

import com.booksproyects.books.book.dto.Auth;

public interface IAuthService {

	List<Auth> listAllAuth();
//Funciones CRUD

	Auth saveAuth(Auth auth);

	Auth AuthXID(Long id);

	Auth updateAuth(Auth auth);

	void deleteAuth(Long id);

	List<Auth> listAuthByName(String name);


}
