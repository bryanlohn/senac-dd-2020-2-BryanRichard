package br.sc.senac.model.vo;

import java.time.LocalDate;

public class PublicoVoluntarioVO extends PessoaVO {
	
	private char voluntario;

	
// CONSTRUTORES
	public PublicoVoluntarioVO() {
		super();
	}

	public PublicoVoluntarioVO(String nomeCompleto, char sexo, LocalDate dataNascimento, String cpf) {
		super(nomeCompleto, sexo, dataNascimento, cpf);
	}

	
//GETTERS AND SETTERS
	public char getVoluntario() {
		return voluntario;
	}

	public void setVoluntario(char voluntario) {
		this.voluntario = voluntario;
	}
	
	
}
