package br.gov.rj.fazenda.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import br.gov.rj.fazenda.dao.ControleDAO;
import br.gov.rj.fazenda.dao.ExecutaProcedureDAO;
import br.gov.rj.fazenda.util.CheckList;
import br.gov.rj.fazenda.util.IPropertiesLoader;
import br.gov.rj.fazenda.util.PropertiesUtil;
import br.gov.rj.fazenda.util.TempoUtil;

public class IniciaProcedures 
{	
	private static final Logger LOGGER = Logger.getLogger(IniciaProcedures.class.getName());
	private ControleDAO dao;
	private String configuracao;
	
	/**
	 * Construtor da classe IniciaProcedures que recebe como parametro o arquivo de configuracao a ser carregado
	 * @param _config
	 */
	public IniciaProcedures(String _config)
	{
		configuracao = _config;
		
		//Define o arquivo de configuracao para ser lido
		IPropertiesLoader.defineConfiguracao(configuracao);
	}

	/**
	 * Incia o processo de execucao das procedures definidas no banco de dados
	 */
	public Boolean IniciaProcedures()
	{
		try 
		{
			//Define o inicio do processo do JOB
			TempoUtil.defineInicio();
	
			LOGGER.info("-----------------------------------------------------------------");
			LOGGER.info("SUBSECRETARIA ADJUNTA DE TECNOLOGIA DA INFORMACAO - SATI");
			LOGGER.info("-----------------------------------------------------------------");
			LOGGER.info("INICIANDO O JOB DE EXECUCAO DE PROCEDURES");
			
			//Imprime os dados de compilacao do projeto
			PropertiesUtil.print();
			
			LOGGER.info("INFO0001 - CONFIGURACAO: " + configuracao);

			if(Boolean.valueOf(IPropertiesLoader.getValor("JOB_ATIVADO")))
			{
				LOGGER.info("-----------------------------------------------------------------");
				
				LOGGER.info("INFO0001 - BD_HOST: " + IPropertiesLoader.getValor("DB_URL"));
				LOGGER.info("INFO0001 - BD_USER: " + IPropertiesLoader.getValor("DB_USER"));
				LOGGER.info("INFO0001 - BD_PROCEDURES: " + IPropertiesLoader.getValor("DB_PROCEDURE"));
				
				LOGGER.info("-----------------------------------------------------------------");
				
				//Realiza o CheckList do sistema
				CheckList.checkList(configuracao);
				
				//Instancia o DAO
				dao = new ControleDAO();
				
				//Verifica se a execucao sera realizada via thread
				if(Boolean.valueOf(IPropertiesLoader.getValor("DB_THEREAD")))
				{
					LOGGER.info("INFO0001 - EXECUTANDO EM THEREAD");
					
					ExecutorService executor = Executors.newFixedThreadPool(10);
					executor = Executors.newFixedThreadPool(IPropertiesLoader.getValor("DB_PROCEDURE").split(";").length);
		
					for (String procedure : IPropertiesLoader.getValor("DB_PROCEDURE").split(";")) 
					{
						try 
						{
							Runnable worker = new ExecutaProcedureDAO(procedure, dao);
							executor.execute(worker);
						} 
						catch (Exception ex)
						{
							LOGGER.error("PROC0002 - OCORREU UM ERRO NA EXECUCAO DA PROCEDURE [" + procedure + "] - [" + ex.getMessage() + "]");
						}
					}
	
					// Desliga o executor em pool
					executor.shutdown();
	
					// Aguarda a execucao do threads
					while (!executor.isTerminated()) {
						esperarThread();
					}
					
				}
				else
				{
					LOGGER.info("INFO0001 - EXECUTANDO EM SEQUENCIA");
					
					for (String procedure : IPropertiesLoader.getValor("DB_PROCEDURE").split(";")) 
					{
						LOGGER.info("INFO0001 - EXECUTANDO [" + procedure + "]");
						dao.executaSQL(procedure);
						LOGGER.info("INFO0001 - [" + procedure + "] COM SUCESSO"); 
					}	
				}
			}
			else
			{
				LOGGER.info("INFO0001 - JOB DESATIVADO NO ARQUIVO DE CONFIGURACAO");
			}
			
			return Boolean.TRUE;
			
		}
		catch(Exception ex)
		{
			LOGGER.error(ex.getMessage(), ex);	
			return Boolean.FALSE;
		}	
		finally
		{
			// Define o inicio do processo do JOB
			TempoUtil.defineFim();

			// Apresenta tempo de execucao
			LOGGER.info("-----------------------------------------------------------------");
			LOGGER.info("INFO0001 - TEMPO DE PROCESSAMENTO GASTO: " + TempoUtil.calculaTempoProcessamento());
			LOGGER.info("-----------------------------------------------------------------");
		}
	}	
	
	/**
	 * Agaurda a execucao da Theread de processamento
	 */
	private static void esperarThread() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}
