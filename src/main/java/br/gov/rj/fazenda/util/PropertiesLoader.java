package br.gov.rj.fazenda.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader
{
    private Properties props;
    
    public void defineConfiguracao()
    {
    	
    }
    
    protected PropertiesLoader(String _nomeDoProperties)
    {
        props = new Properties();

        try
        {
        	 InputStream in =new FileInputStream("config" + File.separator + _nomeDoProperties);
             props.load(in);
             in.close();
        }
        catch(FileNotFoundException e)
        {
        	e.printStackTrace();
        }
        catch(IOException e)
        {
        	e.printStackTrace();
        }
    }
    protected String getValor(String chave)
    {
    	return (String)props.getProperty(chave);
    }
}