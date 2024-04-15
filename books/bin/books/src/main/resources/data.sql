
DROP table IF EXISTS books;

create table books(
	id int auto_increment,
	title varchar(250),
	author varchar(250),
	isbn integer,
	publication_date varchar
);

insert into books (title,author,isbn,publication_date)values('Python para principiantes','Alejandro',123456789, '2002-02-08');
insert into books (title,author,isbn,publication_date)values('El italiano','Arturo Pérez Reverte',122222222, '1985-06-02');
insert into books (title,author,isbn,publication_date)values('El archivo de las tormentas','Brandon Sanderson',123333333, '2022-01-31');
insert into books (title,author,isbn,publication_date)values('Victus','Arbert Sánchez Piñol',123444444, '1890-11-20');
insert into books (title,author,isbn,publication_date)values('El código da vinci','Dan Brown',123455555, '1678-07-09');

