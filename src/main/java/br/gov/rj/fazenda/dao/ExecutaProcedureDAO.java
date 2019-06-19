package br.gov.rj.fazenda.dao;
import org.apache.log4j.Logger;

public class ExecutaProcedureDAO implements Runnable
{
	private static final Logger LOGGER = Logger.getLogger(ExecutaProcedureDAO.class.getName() );
	ControleDAO controle;
	String procedure;
	
	public ExecutaProcedureDAO(String _procedure, ControleDAO _controleDao)
	{
		controle = _controleDao;
		procedure = _procedure;
	}
	
	@Override
	public void run() 
	{
		try
		{
			LOGGER.info("INFO0001 - EXECUTANDO [" + procedure + "]");
			controle.executaSQL(procedure);
			LOGGER.info("INFO0001 - [" + procedure + "] COM SUCESSO");
		}
		catch(Exception ex)
		{
			LOGGER.error("PROC0002 - OCORREU UM ERRO NA EXECUCAO DA PROCEDURE [" + procedure+ "] - [" + ex.getMessage() + "]");
		}
	}
}
