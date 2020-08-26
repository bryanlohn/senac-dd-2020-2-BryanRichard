package br.sc.senac.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import br.sc.senac.model.vo.PublicoVoluntarioVO;


public class PublicoVoluntarioDAO {

	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public PublicoVoluntarioVO inserir (PublicoVoluntarioVO publicoVoluntarioVO) {
		Connection conn = Banco.getConnection();
		
		String sql = "INSERT INTO PUBLICO_VOLUNTARIO (NOME, CPF, DATA_NASCIMENTO, SEXO, VOLUNTARIO) "
				+ "VALUES (?,?,?,?,?)";
		
		PreparedStatement query = Banco.getPreparedStatement (conn, sql);
		
		try {
			query.setString(1, publicoVoluntarioVO.getNomeCompleto());
			query.setString(2, publicoVoluntarioVO.getCpf());
			query.setString(3, publicoVoluntarioVO.getDataNascimento());
			query.setString(4, publicoVoluntarioVO.getSexo());
			query.setString(5, publicoVoluntarioVO.getVoluntario());
			
			int codigoRetorno = query.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir pessoa Publica ou Voluntária.\nCausa: " + e.getMessage());
		}finally {
			Banco.closeStatement(query);
			Banco.closeConnection(conn);
		}
				
		return publicoVoluntarioVO;
		
	}
	
	public boolean excluir(int id) {
	Connection conn = Banco.getConnection();
    String sql = " DELETE FROM PUBLICO_VOLUNTARIO WHERE IDPUBLICOVOLUNTARIO=? ";

    PreparedStatement query = Banco.getPreparedStatement(conn, sql);
    boolean excluiu = false;
    		
    try {
        query.setInt(1, id);

        int codigoRetorno = query.executeUpdate();
        excluiu = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);
    } catch (SQLException e) {
        System.out.println("Erro ao excluir pessoa Publica ou Voluntária (id: " + id + ") .\nCausa: " + e.getMessage());
    }finally {
        Banco.closeStatement(query);
        Banco.closeConnection(conn);
    }

    return excluiu;
}
	
	
}
