package com.booksproyects.books.book.dto;

import java.util.Date;



import jakarta.persistence.*;

@Entity
@Table(name="books")//en caso que la tabala sea diferente
public class Book {
	
	//Atributos de entidad cliente
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
		private Long id;
		@Column(name = "title")
		private String title;
		@Column(name = "author")
		private String author;
		@Column (name = "isbn")
		private Long isbn;
		@Temporal(TemporalType.TIMESTAMP)
		private Date publication_date;
		
		
		
		public Book(Long id, String title, String author, Date publication_date) {
			super();
			this.id = id;
			this.title = title;
			this.author = author;
			this.publication_date = publication_date;
		}
		
		public Book() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "Books [id=" + id + ", title=" + title + ", address=" + author + ", publication_date=" + publication_date + "]";
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
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public Date getpublicationDate() {
			return publication_date;
		}
		public void setpublicationDate(Date publicationDate) {
			this.publication_date = publicationDate;
		}

		public Long getIsbn() {
			return isbn;
		}

		public void setIsbn(Long isbn) {
			this.isbn = isbn;
		}
		
	
}
