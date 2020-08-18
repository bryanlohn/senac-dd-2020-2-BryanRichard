drop database if exists exercicio;
create database exercicio;
use exercicio;

create table Pesquisador (
	  idPesquisador int not null primary key auto_increment
	, nomeCompleto varchar(100) not null
	, cpf varchar(11) not null
	, dataNascimento date not null
	, sexo char not null
    , instituicao varchar(100) not null
);

create table PublicoVoluntario (
	  idPublicoVoluntario int not null primary key auto_increment
	, nomeCompleto varchar(100) not null
	, cpf varchar(11) not null
	, dataNascimento date not null
	, sexo char not null
	, voluntario char not null
);


create table Vacina (
	  idVacina int not null primary key auto_increment
	, dataInicioPesquisa date not null
	, paisOrigem varchar(100) not null
	, estagioPesquisa int not null
	, nomePesquisador varchar(100) not null
);