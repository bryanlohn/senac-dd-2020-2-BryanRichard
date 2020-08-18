create database dbexercicio;
use dbexercicio;

create table Pesquisador (
	  IDPESQUISADOR int not null auto_increment
	, NOME varchar(100) not null
	, CPF varchar(11) not null
	, DATA_NASCIMENTO date not null
	, SEXO ENUM ('M', 'F') not null
    , INSTITUICAO varchar(100) not null
    , PRIMARY KEY (IDPESQUISADOR)
);

create table PUBLICO_VOLUNTARIO (
	  IDPUBLICOVOLUNTARIO int not null auto_increment
	, NOME varchar(100) not null
	, CPF varchar(11) not null
	, DATA_NASCIMENTO date not null
	, SEXO ENUM ('M', 'F') not null
	, VOLUNTARIO char not null
	, PRIMARY KEY (IDPUBLICOVOLUNTARIO)
);


create table VACINA (
	  IDVACINA int not null auto_increment
	, IDPESQUISADOR int not null
	, DATA_INICIO_PESQUISA date not null
	, PAIS_ORIGEM varchar(100) not null
	, ESTAGIO_PESQUISA ENUM('INICIAL', 'TESTES', 'APLICAÇÃO') not null
	, NOME_PESQUISADOR varchar(100) not null
	, primary key (IDVACINA)
	, foreign key (IDPESQUISADOR) references PESQUISADOR (IDPESQUISADOR)
);