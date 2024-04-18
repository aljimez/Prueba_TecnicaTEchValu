package com.booksproyects.books.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booksproyects.books.book.dao.IAuthDAO;
import com.booksproyects.books.book.dto.Auth;

@Service
public class AuthServiceImpl implements IAuthService{
	
//Usamos los métodos de IAuthService
	@Autowired
	IAuthDAO iAuthDAO;
	
	@Override
	public List<Auth> listAllAuth() {
		
		return iAuthDAO.findAll();
	}

	@Override
	public Auth saveAuth(Auth auth) {
		
		return iAuthDAO.save(auth);
	}

	@Override
	public Auth AuthXID(Long id) {
		return iAuthDAO.findById(id).get();
	}
	

	@Override
	public Auth updateAuth(Auth auth) {
		
		return iAuthDAO.save(auth);
	}

	@Override
	public void deleteAuth(Long id) {
		
		iAuthDAO.deleteById(id);
		
	}


	@Override
	public List<Auth> listAuthByName(String name) {
		
		return iAuthDAO.findByName(name);
	}



}
