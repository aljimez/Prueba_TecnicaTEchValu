package com.booksproyects.books.book.dto;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="books")
public class Book {
	
	//Atributos de entidad libros
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
		
		private Long id;
		@Column(name = "title")
		private String title;
		@Column (name = "isbn")
		private Long isbn;
		@Temporal(TemporalType.TIMESTAMP)
		private Date publication_date; //Format YYYY-MM-DD
		
	
		
		
		public Book(Long isbn, String title, String author, Date publication_date, Long id) {
			super();
			this.id = id;
			this.isbn = isbn;
			this.title = title;
			this.publication_date = publication_date;
		}
		
		public Book() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "Books [id=" + isbn + ", title=" + title  + ", publication_date=" + publication_date + "]";
		}
		public Long getIsbn() {
			return isbn;
		}
		public void setIsbn(Long isbn) {
			this.isbn = isbn;
			
		}
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
	

		public Date getPublication_date() {
			return publication_date;
		}

		public void setPublication_date(Date publication_date) {
			this.publication_date = publication_date;
		}
	
	




	
}
