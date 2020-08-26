package br.sc.senac.model.dao;





import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

import br.sc.senac.model.vo.PesquisadorVO;

public class PesquisadorDAO {
	
	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public PesquisadorVO inserir (PesquisadorVO pesquisadorVO) {
		Connection conn = Banco.getConnection();
		
		String sql = "INSERT INTO PESQUISADOR (NOME, CPF, DATA_NASCIMENTO, SEXO, INSTITUICAO) "
				+ "VALUES (?,?,?,?,?)";
		
		PreparedStatement query = Banco.getPreparedStatementWithGeneratedKeys (conn, sql);
		
		try {
			query.setString(1, pesquisadorVO.getNomeCompleto());
			query.setString(2, pesquisadorVO.getCpf());
			query.setString(3, pesquisadorVO.getDataNascimento());
			query.setString(4, pesquisadorVO.getSexo());
			query.setString(5, pesquisadorVO.getInstituicao());
			
			int codigoRetorno = query.executeUpdate();
			
			/*if(codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO) {
				ResultSet resultado = query.getGeneratedKeys();
				int chaveGerada = resultado.getInt("ID");
				
				pesquisadorVO.setId(chaveGerada);
			}*/
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir cliente.\nCausa: " + e.getMessage());
		}finally {
			Banco.closeStatement(query);
			Banco.closeConnection(conn);
		}
				
		return pesquisadorVO;
		
	}
	
	public boolean excluir(int id) {
	Connection conn = Banco.getConnection();
    String sql = " DELETE FROM PESQUISADOR WHERE IDPESQUISADOR=? ";

    PreparedStatement query = Banco.getPreparedStatement(conn, sql);
    boolean excluiu = false;
    		
    try {
        query.setInt(1, id);

        int codigoRetorno = query.executeUpdate();
        excluiu = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);
    } catch (SQLException e) {
        System.out.println("Erro ao excluir pesquisador (id: " + id + ") .\nCausa: " + e.getMessage());
    }finally {
        Banco.closeStatement(query);
        Banco.closeConnection(conn);
    }

    return excluiu;
}
	
	
}
