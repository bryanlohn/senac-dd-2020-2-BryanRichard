package br.sc.senac.model.bo;

import javax.swing.JOptionPane;

import br.sc.senac.model.dao.VacinaDAO;
import br.sc.senac.model.vo.VacinaVO;

public class VacinaBO {

	VacinaDAO vacinaDAO = new VacinaDAO();
	VacinaVO vacinaVO = new VacinaVO();
	
	public void cadastrarVacina(VacinaVO vacinaVO) {
		vacinaDAO.inserir(vacinaVO);
		JOptionPane.showMessageDialog(null, "Vacina cadastrada com sucesso!");

	}

}
