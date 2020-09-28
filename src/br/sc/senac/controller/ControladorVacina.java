package br.sc.senac.controller;

import br.sc.senac.model.bo.VacinaBO;
import br.sc.senac.model.vo.VacinaVO;

public class ControladorVacina {

	public void cadastrarVacina(VacinaVO vacinaVO) {
		VacinaBO vacinaBO = new VacinaBO();
		vacinaBO.cadastrarVacina(vacinaVO);
		
		
	}

}
