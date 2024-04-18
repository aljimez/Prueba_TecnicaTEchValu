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

import com.booksproyects.books.book.service.AuthServiceImpl;
import com.booksproyects.books.book.service.BookServiceImpl;
import com.booksproyects.books.book.dto.Auth;
import com.booksproyects.books.book.dto.Book;
import com.booksproyects.books.book.exception.BadRequestException;

@RestController
@RequestMapping(value = "/api")
public class AuthController{
	
	@Autowired
	AuthServiceImpl authserviceimpl;
	
	
	@GetMapping("/auth")
	public  List<Auth> listAuth(){
		return authserviceimpl.listAllAuth();
	}
	
	//listar Libro por campo nombre
	@GetMapping("/auth/name/{name}")
	public List<Auth> listAuthByName(@PathVariable(name="name") String name) {
		try {
	    return authserviceimpl.listAuthByName(name);
		}catch(DataAccessException exDt){
            throw  new BadRequestException(exDt.getMessage());

		}
	}
	

		
	
	@PostMapping("/auth")
	public Auth saveAuth(@RequestBody Auth auth) {
		try {
		return authserviceimpl.saveAuth(auth);
		}catch(BadRequestException exDt){
            throw  new BadRequestException(exDt.getMessage());

		}
	}
	
	
	@GetMapping("/auth/{id}")
	public Auth authXID(@PathVariable(name="id") Long id) {
		try {
			Auth auth_xid = new Auth();
		
		auth_xid=authserviceimpl.AuthXID(id);
		
		System.out.println("Auth XID: "+auth_xid);
		
		return auth_xid;
		}catch(DataAccessException exDt){
            throw  new BadRequestException(exDt.getMessage());

		}
	}
	
	@PutMapping("/auth/{id}")
	public Auth updateAuth(@PathVariable(name="id")Long id,@RequestBody Auth auth) {
		try {
		Auth auth_selected= new Auth();
		Auth auth_updated= new Auth();
		
		auth_selected= authserviceimpl.AuthXID(id);
		auth_selected.setId(auth.getId());
		auth_selected.setName(auth.getName());
		auth_selected.setNationality(auth.getNationality());
		auth_selected.setBirth_day(auth.getBirth_day());
		
		auth_updated = authserviceimpl.updateAuth(auth_selected);
		
		System.out.println("El Autor actualizado es: "+ auth_updated);
		
		return auth_updated;
		}catch(DataAccessException exDt){
            throw  new BadRequestException(exDt.getMessage());

		}
	}
	
	@DeleteMapping("/auth/{id}")
	public void deleteAuth(@PathVariable(name="id")Long id) {
		try {
			authserviceimpl.deleteAuth(id);
		}catch(DataAccessException exDt){
            throw  new BadRequestException(exDt.getMessage());

		}
	}
	
	
}
		
		
