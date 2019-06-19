package br.gov.rj.fazenda.util;

public class IPropertiesLoader 
{
    private static PropertiesLoader loader;
    
    public static void defineConfiguracao(String _nomeDoProperties)
    {
    	loader = new PropertiesLoader(_nomeDoProperties);
    }
    
    public static String getValor(String chave)
    {
    	return (String)loader.getValor(chave);
    }
}