
DROP table IF EXISTS books;

create table books(
	id int auto_increment,
	title varchar(250),
	author varchar(250),
	isbn integer,
	publication_date date
);

insert into books (title,author,isbn,publication_date)values('Python para principiantes','Alejandro',123456789, NOW());
insert into books (title,author,isbn,publication_date)values('El italiano','Arturo Pérez Reverte',122222222, NOW());
insert into books (title,author,isbn,publication_date)values('El archivo de las tormentas','Brandon Sanderson',123333333, NOW());
insert into books (title,author,isbn,publication_date)values('Victus','Arbert Sánchez Piñol',123444444, NOW());
insert into books (title,author,isbn,publication_date)values('El código da vinci','Dan Brown',123455555, NOW());