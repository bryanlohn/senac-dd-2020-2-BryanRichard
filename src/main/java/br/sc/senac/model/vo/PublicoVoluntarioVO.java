package br.sc.senac.model.vo;

import java.time.LocalDate;

public class PublicoVoluntarioVO extends PessoaVO {
	
	private String voluntario;

	public PublicoVoluntarioVO() {
		super();
	}

	public PublicoVoluntarioVO(int id, String nomeCompleto, String sexo, String dataNascimento, String cpf) {
		super(id, nomeCompleto, sexo, dataNascimento, cpf);
	}

	public String getVoluntario() {
		return voluntario;
	}

	public void setVoluntario(String voluntario) {
		this.voluntario = voluntario;
	}

	
	//construtores

	
}