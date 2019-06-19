package br.gov.rj.fazenda.main;

import org.apache.log4j.Logger;

public class ExecutaProcedures {
	private static final Logger LOGGER = Logger.getLogger(ExecutaProcedures.class.getName());

	/**
	 * Contrutor da classe
	 */
	public ExecutaProcedures() {

	}

	/**
	 * Metodo main
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		int status = 0;
		String configuracao = null;
		IniciaProcedures inicia;
		
		if((args != null) && (args.length > 0))
		{
			for(int a = 0; a < args.length; a++)
			{
				if(args[a].contains("config"))
				{
					configuracao = args[a].split("=")[1];
				}
			}
			
			if(configuracao == null)
			{
				LOGGER.info("INFO0001 - PARAMETRO DE CONFIGURACAO NAO INFORMADO");
				LOGGER.info("           INFORME -config=arquivo.conf ONDE arquivo.conf REPRESENTA O ARQUIVO A SER CARREGADO");
			}
			else
			{
				inicia = new IniciaProcedures(configuracao);
				
				if(inicia.IniciaProcedures())
				{
					LOGGER.info("INFO0001 - FIM DO PROCESSAMENTO COM A SAIDA [0]");
					System.exit(0);
				}
				else
				{
					LOGGER.info("INFO0001 - FIM DO PROCESSAMENTO COM A SAIDA [1]");
					System.exit(1);
				}
			}
		}
		else
		{
			LOGGER.info("INFO0001 - PARAMETRO DE CONFIGURACAO NAO INFORMADO");
			LOGGER.info("           INFORME -config=arquivo.conf ONDE arquivo.conf REPRESENTA O ARQUIVO A SER CARREGADO");
		}
	}
}
