package br.gov.rj.fazenda.arr.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import br.gov.rj.fazenda.arr.controller.CancelaRestituicaoController;

public class PropertiesHelper {
	
	
	private static final Logger logger = Logger.getLogger(CancelaRestituicaoController.class.getName() );
	private static String url;
	private static String urlBD;
	private static String userBD;
	private static String passBD;
	private static String userSiafe;
	private static String passSiafe;
	
	private PropertiesHelper() {
		super();
	}

	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		PropertiesHelper.url = url;
	}
	
	
	public static String getUrlBD() {
		return urlBD;
	}

	public static void setUrlBD(String urlBD) {
		PropertiesHelper.urlBD = urlBD;
	}

	public static String getUserBD() {
		return userBD;
	}

	public static void setUserBD(String userBD) {
		PropertiesHelper.userBD = userBD;
	}

	public static String getPassBD() {
		return passBD;
	}

	public static void setPassBD(String passBD) {
		PropertiesHelper.passBD = passBD;
	}

	public static String getUserSiafe() {
		return userSiafe;
	}

	public static void setUserSiafe(String userSiafe) {
		PropertiesHelper.userSiafe = userSiafe;
	}

	public static String getPassSiafe() {
		return passSiafe;
	}

	public static void setPassSiafe(String passSiafe) {
		PropertiesHelper.passSiafe = passSiafe;
	}

	public static Logger getLogger() {
		return logger;
	}
	
	public static void loadProperties() {
		
		logger.info("Iniciando carregamento de informaçõeses de configuracão...");
		Properties properties = new Properties();
		try {		
			File propFile = new File("./config/config.properties");
    	
	    	if (!propFile.isFile()) 
	    		logger.error("Não achou a arquivo de propriedade, caminho:" + propFile.getAbsolutePath());
        
	        FileInputStream fis = new FileInputStream(propFile.getAbsolutePath());
	        properties.load(fis);
	        fis.close();  

	        url = properties.getProperty("wsdl.url");
			userSiafe = properties.getProperty("wsdl.username");
			passSiafe = properties.getProperty("wsdl.password");
			urlBD = properties.getProperty("jdbc.database");
			userBD = properties.getProperty("jdbc.username");
			passBD = properties.getProperty("jdbc.password");
		
		} catch (IOException e) {
			logger.error("Arquivo config.properties não encontrado");			
		}
	}
	
}
