package br.sc.senac.model.bo;

import java.awt.Event;

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
		
		if(publicoVoluntarioVO.getNomeCompleto().length() < 3) {
			JOptionPane.showMessageDialog(null, "O campo nome não possui o mínimo de 4 caracteres.\n Por favor, insira um nome com mais de 3 caracteres.");
		} else {
		JOptionPane.showMessageDialog(null, "Público ou Voluntário cadastrado com sucesso!");
		}
		 }
	}
