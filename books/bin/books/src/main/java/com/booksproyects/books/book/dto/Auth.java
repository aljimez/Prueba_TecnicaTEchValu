package com.booksproyects.books.book.dto;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="author")
public class Auth {
	
	//Atributos de entidad libros
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
		private Long id;
		@Column(name = "name")
		private String name;
		@Column (name = "second_name")
		private Long second_name;
		@Column (name = "nationality")
		private String nationality;
		@Temporal(TemporalType.TIMESTAMP)
		private Date birth_day; //Format YYYY-MM-DD
		
		
		@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST})
		@JoinColumn(name = "books_id")
		private Book books;
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Long getSecond_name() {
			return second_name;
		}
		public void setSecond_name(Long second_name) {
			this.second_name = second_name;
		}
		public String getNationality() {
			return nationality;
		}
		public void setNationality(String nationality) {
			this.nationality = nationality;
		}
		public Date getBirth_day() {
			return birth_day;
		}
		public void setBirth_day(Date birth_day) {
			this.birth_day = birth_day;
		}
		@Override
		public String toString() {
			return "Auth [id=" + id + ", name=" + name + ", second_name=" + second_name + ", nationality=" + nationality
					+ ", birth_day=" + birth_day + "]";
		}
		public Auth(Long id, String name, Long second_name, String nationality, Date birth_day) {
			super();
			this.id = id;
			this.name = name;
			this.second_name = second_name;
			this.nationality = nationality;
			this.birth_day = birth_day;
		}
		public Auth() {
			// TODO Auto-generated constructor stub
		}
		
	
		

	
}
