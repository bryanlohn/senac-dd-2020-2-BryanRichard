package br.sc.senac.controller;

import br.sc.senac.model.vo.PublicoVoluntarioVO;
import br.sc.senac.model.bo.PublicoVoluntarioBO;

public class ControladorPublicoVoluntario {

	
	
	public void cadastrarPublicoVoluntario(PublicoVoluntarioVO publicoVoluntarioVO) {
		PublicoVoluntarioBO publicoVoluntarioBO = new PublicoVoluntarioBO();
		publicoVoluntarioBO.cadastrarPublicoVoluntario(publicoVoluntarioVO);
		
	}
	/*public void cadastrarPublicoVoluntario(PublicoVoluntarioVO publicoVoluntarioVO) {
		PublicoVoluntarioBO = publicoVoluntarioBO = new PublicoVoluntarioBO();
		PublicoVoluntarioBO.CadastrarPublicoVoluntario(publicoVoluntarioVO);
		/*public void cadastrarUsuarioController(UsuarioVO usuarioVO) {
			UsuarioBO usuarioBO = new UsuarioBO();
			usuarioBO.cadastrarUsuario(usuarioVO);*/
			
}