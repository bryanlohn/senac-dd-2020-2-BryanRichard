package br.sc.senac.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.sc.senac.model.vo.PublicoVoluntarioVO;
import br.sc.senac.model.vo.VacinaVO;

public class VacinaDAO  {

	
	public VacinaVO inserir(VacinaVO vacinaVO) {
Connection conn = Banco.getConnection();
		
		String sql = "INSERT INTO VACINA (IDPESQUISADOR, DATA_INICIO_PESQUISA, PAIS_ORIGEM, ESTAGIO_PESQUISA, NOME_PESQUISADOR) "
				+ "VALUES (?,?,?,?,?)";
		
		PreparedStatement query = Banco.getPreparedStatement (conn, sql);
		
		try {
			query.setInt(1, vacinaVO.getPesquisadorVO().getId());
			query.setString(2, vacinaVO.getDataInicioPesquisa());
			query.setString(3, vacinaVO.getPaisOrigem());
			query.setInt(4, vacinaVO.getEstagioPesquisa());
			query.setString(5, vacinaVO.getPesquisadorVO().getNomeCompleto());
			
			int codigoRetorno = query.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir Vacina.\nCausa: " + e.getMessage());
		}finally {
			Banco.closeStatement(query);
			Banco.closeConnection(conn);
		}
				
		return vacinaVO;
		
	}

	
	public boolean alterar(VacinaVO vacinaVO) {
		String sql = " UPDATE VACINA "
				+ " SET IDPESQUISADOR=?, DATA_INICIO_PESQUISA=?, PAIS_ORIGEM=?, ESTAGIO_PESQUISA=?, NOME_PESQUISADOR=? " 
				+ " WHERE IDVACINA=? ";
		
		boolean alterou = false;
		
		//Exemplo usando try-with-resources (similar ao bloco finally)
		try (Connection conexao = Banco.getConnection();
			PreparedStatement query = Banco.getPreparedStatement(conexao, sql);) {
			query.setInt(1, vacinaVO.getPesquisadorVO().getId());
			query.setString(2, vacinaVO.getDataInicioPesquisa());
			query.setString(3, vacinaVO.getPaisOrigem());
			query.setInt(4, vacinaVO.getEstagioPesquisa());
			query.setString(5, vacinaVO.getPesquisadorVO().getNomeCompleto());
			query.setInt(6, vacinaVO.getIdVacina());
			
			int codigoRetorno = query.executeUpdate();
			alterou = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);
		} catch (SQLException e) {
			System.out.println("Erro ao alterar Vacina.\nCausa: " + e.getMessage());
		}
				
		return alterou;
	}

	
	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
	    String sql = " DELETE FROM VACINA WHERE IDVACINA=? ";

	    PreparedStatement query = Banco.getPreparedStatement(conn, sql);
	    boolean excluiu = false;
	    		
	    try {
	        query.setInt(1, id);

	        int codigoRetorno = query.executeUpdate();
	        excluiu = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);
	    } catch (SQLException e) {
	        System.out.println("Erro ao excluir Vacina (id: " + id + ") .\nCausa: " + e.getMessage());
	    }finally {
	        Banco.closeStatement(query);
	        Banco.closeConnection(conn);
	    }

	    return excluiu;
	}

	
	public List<VacinaVO> pesquisarTodos() {
		Connection conn = Banco.getConnection();
		ResultSet result = null;
		VacinaVO vacina = new VacinaVO();
		String sql = "SELECT * FROM VACINA";
		List<VacinaVO> vacinasBuscadas = new ArrayList<VacinaVO>();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		
		try {
			result = stmt.executeQuery();
			while (result.next()) {
				vacina = construirVacinaDoResultSet(result);
				vacinasBuscadas.add(vacina);
			}
		} catch (Exception e) {
			System.out.println("Erro ao pesquisar Todas as vacinas\nErro: [" + e.getMessage() + "]");
		} finally {
			Banco.closeResultSet(result);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		return vacinasBuscadas;
	}

	
	public VacinaVO pesquisarPorId(int id) {
		String sql = " SELECT * FROM VACINA WHERE IDVACINA=? ";
		VacinaVO vacinaBuscada = null;
		
		//Exemplo usando try-with-resources (similar ao bloco finally)
		try (Connection conexao = Banco.getConnection();
			PreparedStatement consulta = Banco.getPreparedStatement(conexao, sql);) {
			consulta.setInt(1, id);
			ResultSet conjuntoResultante = consulta.executeQuery();
			
			if(conjuntoResultante.next()) {
				vacinaBuscada = construirVacinaDoResultSet(conjuntoResultante);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao pesquisar vacina por Id (id: " + id + ") .\nCausa: " + e.getMessage());
		}
		
		return vacinaBuscada;
	}

	
	private VacinaVO construirVacinaDoResultSet(ResultSet conjuntoResultante) throws SQLException {
		VacinaVO vacinaBuscada = new VacinaVO();
		vacinaBuscada.setIdVacina(conjuntoResultante.getInt("IDVACINA"));
		vacinaBuscada.setDataInicioPesquisa(conjuntoResultante.getString("DATA_INICIO_PESQUISA"));
		vacinaBuscada.setPaisOrigem(conjuntoResultante.getString("PAIS_ORIGEM"));
		vacinaBuscada.setEstagioPesquisa(conjuntoResultante.getInt("ESTAGIO_PESQUISA"));
		
		/*DATA_INICIO_PESQUISA, PAIS_ORIGEM, ESTAGIO_PESQUISA, NOME_PESQUISADOR */
		return vacinaBuscada;
	}

	
}
