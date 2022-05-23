create database CrudUsuario;
use CrudUsuario;
create table Usuario(
id int auto_increment not null,
cpf char(11) not null,
email varchar(255) not null,
senha varchar(55)not null,
sexo varchar(9),
dataRegistro datetime,
primary key (id)
);
create table Admin(
idAdmin int auto_increment not null,
Usuario varchar(255),
senha varchar(255),
dataRegistro datetime,
primary key (idAdmin)
);
insert into usuario(cpf,email,senha,sexo,dataRegistro) value('14124469969','masterdudu123@hotmai.com','D#dumaster12','masculino',now());
select *from Admin;
drop table Admin;
select *from Usuario;
drop table Usuario;
SELECT * FROM Usuario WHERE email = '14124469969' or cpf = 'masterdudu123@hotmail.com';
