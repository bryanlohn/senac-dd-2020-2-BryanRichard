package br.sc.senac.model.vo;

import java.time.LocalDate;

public class PublicoVoluntarioVO extends PessoaVO {
	
	private boolean voluntario;

	public PublicoVoluntarioVO() {
		super();
	}

	public PublicoVoluntarioVO(int id, String nomeCompleto, String sexo, String dataNascimento, String cpf) {
		super(id, nomeCompleto, sexo, dataNascimento, cpf);
	}

	public boolean getVoluntario() {
		return voluntario;
	}

	public void setVoluntario(boolean b) {
		this.voluntario = b;
	}

	
	//construtores

	
}