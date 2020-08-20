package br.sc.senac.model.vo;

import java.time.LocalDate;

public class PublicoVoluntarioVO extends PessoaVO {
	
	private boolean voluntario;

	
	//construtores
	public PublicoVoluntarioVO() {
		super();
	}

	public PublicoVoluntarioVO(String nomeCompleto, char sexo, LocalDate dataNascimento, String cpf) {
		super(nomeCompleto, sexo, dataNascimento, cpf);
	}

	
	//getters and setters
	public boolean isVoluntario() {
		return voluntario;
	}

	public void setVoluntario(boolean voluntario) {
		this.voluntario = voluntario;
	}

	
}