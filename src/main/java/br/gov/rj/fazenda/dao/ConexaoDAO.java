package br.gov.rj.fazenda.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.gov.rj.fazenda.util.IPropertiesLoader;

public class ConexaoDAO
{
	private Connection connection = null;     
	  
	public ConexaoDAO()
	{
		//Nada
	}
	
	/**
	 * Abre e realiza a conexao com o banco de dados
	 * @return
	 * @throws Exception 
	 */
	public Connection getConnection() throws Exception
	{
		try 
		{                  
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(IPropertiesLoader.getValor("DB_URL"), IPropertiesLoader.getValor("DB_USER"), IPropertiesLoader.getValor("DB_PASS"));
			return connection; 
		} 
		catch (ClassNotFoundException e) 
		{ 
			throw new Exception(e.getMessage());
		} 
		catch (SQLException e) 
		{
			if(e.getErrorCode() == 1017)
			{
				throw new Exception("ORA-01017: invalid username/password; logon denied");
			}
			else
			{
				throw new Exception(e.getMessage(), e);
			}
		}	 
	}
	
	/**
	 * Fecha a conexao com o banco de dados
	 * @param con
	 * @return
	 */
	public Boolean fechaConnection(Connection con)
	{
		Boolean status = Boolean.TRUE;
		
		if(con != null)
		{
			try 
			{
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
				status = Boolean.FALSE;
			}
		}
		
		return status;
	}
	
	/**
	 * Encerra o PreparedStatement
	 * @param pst
	 * @return
	 */
	public Boolean fechaPreparedStatement(PreparedStatement pst)
	{
		Boolean status = Boolean.TRUE;
		
		try 
		{
			if(pst != null)
			{
				pst.close();
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			status = Boolean.FALSE;
		}
		
		return status;
	}
}
