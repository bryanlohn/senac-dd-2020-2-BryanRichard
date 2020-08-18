package br.sc.senac.model.vo;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Vacina {

	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private LocalDate dataInicioPesquisa;
	private String paisOrigem;
	private int estagioPesquisa;
	private String nomePesquisador;
	
	//Construtores
	public Vacina(DateTimeFormatter dataFormatter, LocalDate dataInicioPesquisa, String paisOrigem, int estagioPesquisa,
			String nomePesquisador) {
		super();
		this.dataFormatter = dataFormatter;
		this.dataInicioPesquisa = dataInicioPesquisa;
		this.paisOrigem = paisOrigem;
		this.estagioPesquisa = estagioPesquisa;
		this.nomePesquisador = nomePesquisador;
	}
	
	public Vacina() {
		super();
	}

	
	// GETTERS AND SETTERS
	public DateTimeFormatter getDataFormatter() {
		return dataFormatter;
	}

	public void setDataFormatter(DateTimeFormatter dataFormatter) {
		this.dataFormatter = dataFormatter;
	}

	public LocalDate getDataInicioPesquisa() {
		return dataInicioPesquisa;
	}

	public void setDataInicioPesquisa(LocalDate dataInicioPesquisa) {
		this.dataInicioPesquisa = dataInicioPesquisa;
	}

	public String getPaisOrigem() {
		return paisOrigem;
	}

	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}

	public int getEstagioPesquisa() {
		return estagioPesquisa;
	}

	public void setEstagioPesquisa(int estagioPesquisa) {
		this.estagioPesquisa = estagioPesquisa;
	}

	public String getNomePesquisador() {
		return nomePesquisador;
	}

	public void setNomePesquisador(String nomePesquisador) {
		this.nomePesquisador = nomePesquisador;
	}
	
	
}
