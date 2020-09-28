package br.sc.senac.controller;

import br.sc.senac.model.bo.PesquisadorBO;
import br.sc.senac.model.vo.PesquisadorVO;

public class ControladorPesquisador {

	public void cadastrarPesquisador(PesquisadorVO pesquisadorVO) {
		PesquisadorBO pesquisadorBO = new PesquisadorBO();
		pesquisadorBO.cadastrarPesquisador(pesquisadorVO);
		
	}
	
}
