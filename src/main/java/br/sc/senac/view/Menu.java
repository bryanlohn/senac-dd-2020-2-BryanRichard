package br.sc.senac.view;

import java.util.Scanner;

import br.sc.senac.model.dao.PesquisadorDAO;
import br.sc.senac.model.vo.PesquisadorVO;

public class Menu {

	public static void main(String[] args) {
		PesquisadorVO pesquisadorVO = new PesquisadorVO();
        Scanner s = new Scanner(System.in);

        System.out.println("Digite NOME, CPF, DATA_NASCIMENTO, SEXO, INSTITUICAO");
        pesquisadorVO.setNomeCompleto(s.nextLine());
        pesquisadorVO.setCpf(s.nextLine());
        pesquisadorVO.setDataNascimento(s.nextLine());
        pesquisadorVO.setSexo(s.nextLine());
        pesquisadorVO.setInstituicao(s.nextLine());

        PesquisadorDAO pesquisadorDAO = new PesquisadorDAO();
        pesquisadorDAO.inserir(pesquisadorVO);

	}

}
