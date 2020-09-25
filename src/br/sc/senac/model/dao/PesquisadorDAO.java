package br.sc.senac.model.dao;





import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
	
	public boolean alterar(PesquisadorVO pesquisadorVO) {
		String sql = " UPDATE PESQUISADOR "
				+ " SET NOME=?, CPF=?, DATA_NASCIMENTO=?, SEXO=?, INSTITUICAO=? " 
				+ " WHERE IDPESQUISADOR=? ";
		
		boolean alterou = false;
		
		//Exemplo usando try-with-resources (similar ao bloco finally)
		try (Connection conexao = Banco.getConnection();
			PreparedStatement query = Banco.getPreparedStatement(conexao, sql);) {
			query.setString(1, pesquisadorVO.getNomeCompleto());
			query.setString(2, pesquisadorVO.getCpf());
			query.setString(3, pesquisadorVO.getDataNascimento());
			query.setString(4, pesquisadorVO.getSexo());
			query.setString(5, pesquisadorVO.getInstituicao());
			query.setInt(6, pesquisadorVO.getId());
			
			int codigoRetorno = query.executeUpdate();
			alterou = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);
		} catch (SQLException e) {
			System.out.println("Erro ao alterar pesquisador.\nCausa: " + e.getMessage());
		}
				
		return alterou;
	}
	
	public PesquisadorVO pesquisarPorId(int id) {
		String sql = " SELECT * FROM PESQUISADOR WHERE IDPESQUISADOR=? ";
		PesquisadorVO pesquisadorBuscado = null;
		
		//Exemplo usando try-with-resources (similar ao bloco finally)
		try (Connection conexao = Banco.getConnection();
			PreparedStatement consulta = Banco.getPreparedStatement(conexao, sql);) {
			consulta.setInt(1, id);
			ResultSet conjuntoResultante = consulta.executeQuery();
			
			if(conjuntoResultante.next()) {
				pesquisadorBuscado = construirPesquisadorDoResultSet(conjuntoResultante);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar cliente por Id (id: " + id + ") .\nCausa: " + e.getMessage());
		}
		
		return pesquisadorBuscado;
	}
	
	public List<PesquisadorVO> pesquisarTodos() {
		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM PESQUISADOR ";
		
		
		PreparedStatement consulta = Banco.getPreparedStatement(conexao, sql);
		List<PesquisadorVO> pesquisadoresBuscados = new ArrayList<PesquisadorVO>();
		
		try {
			ResultSet conjuntoResultante = consulta.executeQuery();
			while(conjuntoResultante.next()) {
				PesquisadorVO pesquisadorBuscado = construirPesquisadorDoResultSet(conjuntoResultante);
				pesquisadoresBuscados.add(pesquisadorBuscado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar todos os pesquisadores .\nCausa: " + e.getMessage());
		}finally {
			Banco.closeStatement(consulta);
			Banco.closeConnection(conexao);
		}
		
		return pesquisadoresBuscados;
	}
	
	
	
	private PesquisadorVO construirPesquisadorDoResultSet(ResultSet conjuntoResultante) throws SQLException {
		PesquisadorVO pesquisadorBuscado = new PesquisadorVO();
		pesquisadorBuscado.setId(conjuntoResultante.getInt("id"));
		pesquisadorBuscado.setNomeCompleto(conjuntoResultante.getString("nome"));
		pesquisadorBuscado.setCpf(conjuntoResultante.getString("cpf"));
		pesquisadorBuscado.setDataNascimento(conjuntoResultante.getString("DATA_NASCIMENTO"));
		pesquisadorBuscado.setSexo(conjuntoResultante.getString("SEXO"));
		pesquisadorBuscado.setInstituicao(conjuntoResultante.getString("INSTITUICAO"));
		
		/*NOME=?, CPF=?, DATA_NASCIMENTO=?, SEXO=?, INSTITUICAO=?*/
		
		return pesquisadorBuscado;
	}
	
	
}
