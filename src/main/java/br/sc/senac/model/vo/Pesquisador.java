package br.sc.senac.model.vo;

import java.time.LocalDate;

public class Pesquisador extends Pessoa {
	
	private String instituicao;

	
//CONSTRUTORES
	public Pesquisador() {
		super();
	}

	public Pesquisador(String nomeCompleto, char sexo, LocalDate dataNascimento, String cpf) {
		super(nomeCompleto, sexo, dataNascimento, cpf);
	}

	
//GETTERS AND SETTERS
	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}
	
	
	
	

}
