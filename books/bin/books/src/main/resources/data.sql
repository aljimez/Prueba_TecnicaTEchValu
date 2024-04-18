
DROP table IF EXISTS books;
DROP table IF EXISTS author;

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

create table author(
	id int auto_increment,
	name varchar(250),
		second_name varchar(250),
	nationality varchar(250),
	birth_day varchar
);

insert into author (name, second_name,nationality, birth_day) values ('Alejandro','Jiménez','Spain','2001-08-06');
insert into author (name,second_name,nationality,birth_day ) values('Arturo','Perez-Reverte','Spain','1980-09-02');
insert into author (name,second_name,nationality,birth_day ) values('Pablo','Neruda','Chile','1680-03-10');
insert into author (name,second_name,nationality,birth_day ) values('Pedro','Calderón de la Barca','Spain','1670-09-02');
