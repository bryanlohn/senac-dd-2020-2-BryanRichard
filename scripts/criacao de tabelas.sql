drop database if exists dbexercicio;
create database dbexercicio;
use dbexercicio;

create table Pesquisador (
	  IDPESQUISADOR int not null auto_increment
	, NOME varchar(100) not null
	, CPF varchar(11) not null
	, DATA_NASCIMENTO varchar(11) not null
	, SEXO varchar(20) not null
    , INSTITUICAO varchar(100) not null
    , PRIMARY KEY (IDPESQUISADOR)
);

create table PUBLICO_VOLUNTARIO (
	  IDPUBLICOVOLUNTARIO int not null auto_increment
	, NOME varchar(100) not null
	, CPF varchar(11) not null
	, DATA_NASCIMENTO varchar(11) not null
	, SEXO varchar(20) not null
	, VOLUNTARIO boolean not null
	, PRIMARY KEY (IDPUBLICOVOLUNTARIO)
);


create table VACINA (
	  IDVACINA int not null auto_increment
	, DATA_INICIO_PESQUISA varchar(11) not null
	, PAIS_ORIGEM varchar(100) not null
	, ESTAGIO_PESQUISA varchar(40) not null
	, NOME_PESQUISADOR varchar(100) not null
	, primary key (IDVACINA)
);

select * from PUBLICO_VOLUNTARIO;