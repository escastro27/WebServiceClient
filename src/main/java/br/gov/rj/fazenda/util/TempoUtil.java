package br.gov.rj.fazenda.util;

import java.util.Calendar;

/**
 * Classe responsavel por calcular tempo de execucao do JOB
 * @author gcarneiro
 *
 */
public class TempoUtil 
{
	 static long inicio, fim;
	 
	/**
	 * Define o inicio da execucao do JOB
	 */
	public static void defineInicio()
	{
		Calendar data = Calendar.getInstance();
		inicio = data.getTimeInMillis();
	}
	
	/**
	 * Define o fim da execucao do JOB
	 */
	public static void defineFim()
	{
		Calendar data = Calendar.getInstance();
		fim = data.getTimeInMillis();
	}
	
	/**
	 * Metodo que calcula o tempo usado para a execucao do JOB
	 * @return
	 */
	public static String calculaTempoProcessamento()
	{
		long diferenca = fim - inicio;
		long diferencaSeg = diferenca / 1000;    //DIFERENCA EM SEGUNDOS   
		long diferencaMin = diferenca / (60 * 1000);    //DIFERENCA EM MINUTOS   
		long diferencaHoras = diferenca / (60 * 60 * 1000);    // DIFERENCA EM HORAS 
		return diferencaHoras + ":" + diferencaMin + ":" + diferencaSeg;
	}
}
