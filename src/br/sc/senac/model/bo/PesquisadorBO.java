package br.sc.senac.model.bo;

import br.sc.senac.model.dao.PesquisadorDAO;
import br.sc.senac.model.vo.PesquisadorVO;


public class PesquisadorBO {

	PesquisadorDAO pesquisadorDAO = new PesquisadorDAO();
	PesquisadorVO pesquisadorVO = new PesquisadorVO();
	
	public void cadastrarPesquisador(PesquisadorVO pesquisadorVO) {
		pesquisadorDAO.inserir(pesquisadorVO);
		
		
		
	}

}
