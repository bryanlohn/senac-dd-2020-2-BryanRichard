package br.sc.senac.model.bo;

import javax.swing.JOptionPane;

import br.sc.senac.model.dao.PesquisadorDAO;
import br.sc.senac.model.vo.PesquisadorVO;


public class PesquisadorBO {

	PesquisadorDAO pesquisadorDAO = new PesquisadorDAO();
	PesquisadorVO pesquisadorVO = new PesquisadorVO();
	
	public void cadastrarPesquisador(PesquisadorVO pesquisadorVO) {
		pesquisadorDAO.inserir(pesquisadorVO);
		JOptionPane.showMessageDialog(null, "Pesquisador cadastrado com sucesso!");
		
		
	}

}
