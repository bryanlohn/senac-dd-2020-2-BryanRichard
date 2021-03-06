package br.sc.senac.model.vo;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;

public class VacinaVO {

	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private int idVacina;
	private String dataInicioPesquisa;
	private String paisOrigem;
	private String estagioPesquisa;
	private String pesquisadorVO;
	
	//CONSTRUTORES
	public VacinaVO(DateTimeFormatter dataFormatter, int idVacina, String dataInicioPesquisa, String paisOrigem,
			String estagioPesquisa, String pesquisadorVO) {
		super();
		this.dataFormatter = dataFormatter;
		this.idVacina = idVacina;
		this.dataInicioPesquisa = dataInicioPesquisa;
		this.paisOrigem = paisOrigem;
		this.estagioPesquisa = estagioPesquisa;
		this.pesquisadorVO = pesquisadorVO;
	}
	public VacinaVO() {
		super();
	}
	
	// GETTERS AND SETTERS
	public DateTimeFormatter getDataFormatter() {
		return dataFormatter;
	}
	public void setDataFormatter(DateTimeFormatter dataFormatter) {
		this.dataFormatter = dataFormatter;
	}
	public int getIdVacina() {
		return idVacina;
	}
	public void setIdVacina(int idVacina) {
		this.idVacina = idVacina;
	}
	public String getDataInicioPesquisa() {
		return dataInicioPesquisa;
	}
	public void setDataInicioPesquisa(String dataInicioPesquisa) {
		this.dataInicioPesquisa = dataInicioPesquisa;
	}
	public String getPaisOrigem() {
		return paisOrigem;
	}
	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}
	public String getEstagioPesquisa() {
		return estagioPesquisa;
	}
	public void setEstagioPesquisa(String estagioPesquisa) {
		this.estagioPesquisa = estagioPesquisa;
	}
	public String getPesquisadorVO() {
		return pesquisadorVO;
	}
	public void setPesquisadorVO(String string) {
		this.pesquisadorVO = string;
	}
	
	
}
