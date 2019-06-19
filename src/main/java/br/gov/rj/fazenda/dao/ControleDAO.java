package br.gov.rj.fazenda.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;


public class ControleDAO 
{
	private ConexaoDAO ConexaoDAO;
	private static final Logger LOGGER = Logger.getLogger(ControleDAO.class.getName() );
	
	/**
	 * 
	 */
	public ControleDAO()
	{
		ConexaoDAO = new ConexaoDAO();
	}
	
	/*
	 * Realiza um teste de conexao com o banco de dados de controle
	 * @return
	 */
	public Boolean testaConexaoControle() throws Exception
	{
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement psU = null;
		

		try
		{
			// Obtem a conexao
			conn = ConexaoDAO.getConnection();
	
			// Query para resgatar as solicitacoes que nao estao associadas a
			// nenhuma instancia
			pst = conn.prepareStatement("SELECT SYSDATE FROM DUAL");
			rs = pst.executeQuery();
	
			if (rs.next()) 
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(SQLException ex)
		{
			throw new Exception(ex.getMessage());	
		} 
		catch (Exception e) 
		{
			throw new Exception(e.getMessage());
		}
		finally
		{
			if(pst != null)
				pst.close();
		
			if(rs != null)
				rs.close();
		}
	}
	
	/**
	 * Realiza a execucao do SQL
	 * @return
	 * @throws Exception 
	 */
	public void executaSQL(String procedure) throws Exception
	{
		//Atributos
		Connection conn = null;
		PreparedStatement pst = null;
		StringBuilder stb = new StringBuilder();
		
		try
		{
			conn = ConexaoDAO.getConnection();
			CallableStatement stmt = conn.prepareCall("{call " + procedure + "}");
			stmt.execute(); 	
		}
		finally
		{
			ConexaoDAO.fechaConnection(conn);
			ConexaoDAO.fechaPreparedStatement(pst);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public ConexaoDAO getConexaoDAO() {
		return ConexaoDAO;
	}

	/**
	 * 
	 * @param conexaoDAO
	 */
	public void setConexaoDAO(ConexaoDAO conexaoDAO) {
		ConexaoDAO = conexaoDAO;
	}
}
