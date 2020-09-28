package br.sc.senac.model.bo;

import javax.swing.JOptionPane;

import br.sc.senac.model.dao.PesquisadorDAO;
import br.sc.senac.model.dao.PublicoVoluntarioDAO;
import br.sc.senac.model.vo.PesquisadorVO;
import br.sc.senac.model.vo.PublicoVoluntarioVO;

public class PublicoVoluntarioBO {
	
	PublicoVoluntarioDAO publicoVoluntarioDAO = new PublicoVoluntarioDAO();
	PublicoVoluntarioVO publicoVoluntarioVO = new PublicoVoluntarioVO();
	
	public void cadastrarPublicoVoluntario(PublicoVoluntarioVO publicoVoluntarioVO) {
		publicoVoluntarioDAO.inserir(publicoVoluntarioVO);
		JOptionPane.showMessageDialog(null, "P�blico ou Volunt�rio cadastrado com sucesso!");
		
		 }
	}
