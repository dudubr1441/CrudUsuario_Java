create database CrudUsuario;
use CrudUsuario;
create table Usuario(
id int auto_increment not null,
cpf char(11) not null,
email varchar(255) not null,
senha varchar(55)not null,
sexo varchar(9),
dataRegistro date,
primary key (id)
);
create table Admin(
idAdmin int auto_increment not null,
Usuario varchar(255),
senha varchar(255),
dataRegistro datetime,
primary key (idAdmin)
);
insert into usuario(cpf,email,senha,sexo,dataRegistro) value('14124469969','masterdudu123@hotmail.com','D#dumaster12','masculino',curdate());
insert into admin(Usuario,senha,dataRegistro) value ('dudubr1441','10092003',now());
drop table Admin;
select * from admin;
select * from usuario;
drop table usuario;
SELECT * FROM admin WHERE usuario = 'dudubr1441' and senha = '10092003';
drop table Usuario;
SELECT * FROM Usuario WHERE email = '14124469969' or cpf = 'masterdudu123@hotmail.com';
