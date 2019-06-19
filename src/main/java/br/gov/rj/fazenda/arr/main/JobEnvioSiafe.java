package br.gov.rj.fazenda.arr.main;


import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.xml.datatype.DatatypeConfigurationException;

import org.apache.log4j.Logger;


import br.gov.rj.fazenda.arr.controller.CancelaRestituicaoController;
import br.gov.rj.fazenda.arr.controller.ImportaReceitaController;
import br.gov.rj.fazenda.arr.controller.ImportaRestituicaoController;
import br.gov.rj.fazenda.arr.util.PropertiesHelper;

public class JobEnvioSiafe 
{
	

	
	private static final Logger logger = Logger.getLogger(JobEnvioSiafe.class.getName() );
	
    public static void main( String[] args )  throws IOException, ParseException, DatatypeConfigurationException, SQLException {
    	
    	logger.info("Iniciando processamento de envio para o Siafe");
    	ImportaReceitaController iArrecadacaoControl = new ImportaReceitaController();
    	ImportaRestituicaoController iRestituicaoControl = new ImportaRestituicaoController();
    	CancelaRestituicaoController iCancelaRestituicaoControl = new CancelaRestituicaoController();
    	
    	
    	try {
	    	PropertiesHelper.loadProperties();
	    	
	    	iArrecadacaoControl.Enviar();
	    	iRestituicaoControl.Enviar();	
	    	iCancelaRestituicaoControl.Enviar();    	
	    	logger.info("Finalizando processamento de envio para o Siafe");
    	
    	}catch (Exception e){
			logger.error("Erro no JobEnvioSiafe, motivo: " + e.getMessage());

			
		}
    }
    
    
    
}
