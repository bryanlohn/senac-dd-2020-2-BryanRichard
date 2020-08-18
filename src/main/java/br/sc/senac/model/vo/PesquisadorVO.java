package br.sc.senac.model.vo;

import java.time.LocalDate;

public class PesquisadorVO extends PessoaVO {
	
	private String instituicao;

	
//CONSTRUTORES
	public PesquisadorVO() {
		super();
	}

	public PesquisadorVO(String nomeCompleto, char sexo, LocalDate dataNascimento, String cpf) {
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
