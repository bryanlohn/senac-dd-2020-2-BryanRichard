package br.sc.senac.model.vo;

import java.time.LocalDate;

public class PesquisadorVO extends PessoaVO {
	
	private String instituicao;

	
//CONSTRUTORES
	
	public PesquisadorVO() {
		super();
	}

	
	public PesquisadorVO(int id, String nomeCompleto, String sexo, String dataNascimento, String cpf) {
		super(id, nomeCompleto, sexo, dataNascimento, cpf);
	}





	//GETTERS AND SETTERS
	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}
	
	
	
	

}
