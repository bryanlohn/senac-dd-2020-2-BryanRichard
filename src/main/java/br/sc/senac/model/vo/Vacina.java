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
	
}
