package br.sc.senac.model.vo;

import java.time.LocalDate;

public class PessoaVO {
	
	private String nomeCompleto;
	private char sexo;
	private LocalDate dataNascimento;
	private String cpf;
	
	// CONSTRUTORES
	public PessoaVO(String nomeCompleto, char sexo, LocalDate dataNascimento, String cpf) {
		super();
		this.nomeCompleto = nomeCompleto;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
	}

	public PessoaVO() {
		super();
	}

	
	//GETTERS AND SETTERS
	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
	
}
