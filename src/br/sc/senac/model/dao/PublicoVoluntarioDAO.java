package br.sc.senac.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.sc.senac.model.vo.PesquisadorVO;
import br.sc.senac.model.vo.PublicoVoluntarioVO;


public class PublicoVoluntarioDAO {

	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public PublicoVoluntarioVO inserir (PublicoVoluntarioVO publicoVoluntarioVO) {
		Connection conn = Banco.getConnection();
		
		String sql = "INSERT INTO PUBLICO_VOLUNTARIO (NOME, CPF, DATA_NASCIMENTO, SEXO, VOLUNTARIO) "
				+ "VALUES (?,?,?,?,?)";
		
		
		PreparedStatement query = Banco.getPreparedStatement (conn, sql);
		
		try {
			/*java.sql.Date date = java.sql.Date.valueOf(publicoVoluntarioVO.getDataNascimento());*/
			query.setString(1, publicoVoluntarioVO.getNomeCompleto());
			query.setString(2, publicoVoluntarioVO.getCpf());
			query.setString(3, publicoVoluntarioVO.getDataNascimento());
			query.setString(4, publicoVoluntarioVO.getSexo());
			query.setBoolean(5, publicoVoluntarioVO.getVoluntario());
			
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
	
	public boolean alterar(PublicoVoluntarioVO publicoVoluntarioVO) {
		String sql = " UPDATE PUBLICO_VOLUNTARIO "
				+ " SET NOME=?, CPF=?, DATA_NASCIMENTO=?, SEXO=?, VOLUNTARIO=? " 
				+ " WHERE IDPUBLICOVOLUNTARIO=? ";
		
		boolean alterou = false;
		
		//Exemplo usando try-with-resources (similar ao bloco finally)
		try (Connection conexao = Banco.getConnection();
			PreparedStatement query = Banco.getPreparedStatement(conexao, sql);) {
			/*java.sql.Date date = java.sql.Date.valueOf(publicoVoluntarioVO.getDataNascimento());*/
			query.setString(1, publicoVoluntarioVO.getNomeCompleto());
			query.setString(2, publicoVoluntarioVO.getCpf());
			query.setString(3, publicoVoluntarioVO.getDataNascimento());
			query.setString(4, publicoVoluntarioVO.getSexo());
			query.setBoolean(5, publicoVoluntarioVO.getVoluntario());
			query.setInt(6, publicoVoluntarioVO.getId());
			
			int codigoRetorno = query.executeUpdate();
			alterou = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);
		} catch (SQLException e) {
			System.out.println("Erro ao alterar pessoa Publica ou Voluntária.\nCausa: " + e.getMessage());
		}
				
		return alterou;
	}
	
	public PublicoVoluntarioVO pesquisarPorId(int id) {
		String sql = " SELECT * FROM PUBLICO_VOLUNTARIO WHERE IDPUBLICOVOLUNTARIO=? ";
		PublicoVoluntarioVO publicoVoluntarioBuscado = null;
		
		//Exemplo usando try-with-resources (similar ao bloco finally)
		try (Connection conexao = Banco.getConnection();
			PreparedStatement consulta = Banco.getPreparedStatement(conexao, sql);) {
			consulta.setInt(1, id);
			ResultSet conjuntoResultante = consulta.executeQuery();
			
			if(conjuntoResultante.next()) {
				publicoVoluntarioBuscado = construirPublicoVoluntarioDoResultSet(conjuntoResultante);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar pessoa Publica ou Voluntária por Id (id: " + id + ") .\nCausa: " + e.getMessage());
		}
		
		return publicoVoluntarioBuscado;
	}
	
	public List<PublicoVoluntarioVO> pesquisarTodos() {
		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM PUBLICO_VOLUNTARIO ";
		
		
		PreparedStatement consulta = Banco.getPreparedStatement(conexao, sql);
		List<PublicoVoluntarioVO> publicoVoluntarioBuscados = new ArrayList<PublicoVoluntarioVO>();
		
		try {
			ResultSet conjuntoResultante = consulta.executeQuery();
			while(conjuntoResultante.next()) {
				PublicoVoluntarioVO publicoVoluntarioBuscado = construirPublicoVoluntarioDoResultSet(conjuntoResultante);
				publicoVoluntarioBuscados.add(publicoVoluntarioBuscado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar todos os pesquisadores .\nCausa: " + e.getMessage());
		}finally {
			Banco.closeStatement(consulta);
			Banco.closeConnection(conexao);
		}
		
		return publicoVoluntarioBuscados;
	}
	
	
	
	private PublicoVoluntarioVO construirPublicoVoluntarioDoResultSet(ResultSet conjuntoResultante) throws SQLException {
		PublicoVoluntarioVO publicoVoluntarioBuscado = new PublicoVoluntarioVO();
		publicoVoluntarioBuscado.setId(conjuntoResultante.getInt("id"));
		publicoVoluntarioBuscado.setNomeCompleto(conjuntoResultante.getString("nome"));
		publicoVoluntarioBuscado.setCpf(conjuntoResultante.getString("cpf"));
		publicoVoluntarioBuscado.setDataNascimento(conjuntoResultante.getString("DATA_NASCIMENTO"));
		publicoVoluntarioBuscado.setSexo(conjuntoResultante.getString("SEXO"));
		publicoVoluntarioBuscado.setVoluntario(conjuntoResultante.getBoolean("VOLUNTARIO"));
		
		/*SET NOME=?, CPF=?, DATA_NASCIMENTO=?, SEXO=?, VOLUNTARIO=? " */
		
		return publicoVoluntarioBuscado;
	}

	public boolean existeRegistroPorCpf(String cpf) {
		return false;
	}
	
}
