package br.gov.rj.fazenda.util;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public final class Util {
	private Util() {

	}

	/**
	 * Verifica se a instancia do projeto ja se encontra executando<br/>True caso esteja em exeucao<br/>False para nao em execucao
	 * @param filename
	 * @return
	 * @throws IOException 
	 */
	public static boolean verificaExecucao(String filename) throws IOException
	{
		RandomAccessFile randomFile = null;
		
		try 
		{
			randomFile = new RandomAccessFile(filename,"rw");
			FileChannel channel=randomFile.getChannel();
			if(channel.tryLock()==null)
			{
				return true;
			}
			else
			{
				return false;
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			return true;
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			return true;
		}
		finally
		{
			
		}
	}
	
	/**
	 * Realiza a leitura de um arquivo .txt
	 * @param file
	 * @return
	 * @throws IOException 
	 */
	public static String leituraTXT(File file) throws IOException
	{

		BufferedReader br = null;
		String linha = null;
		try
		{
			br = new BufferedReader(new FileReader(file)); 
			
			while(br.ready())
			{ 
				if(linha == null)
					linha = br.readLine(); 
				else 
					linha += br.readLine(); 
			}
		}
		finally
		{
			br.close(); 
		}
		
		return linha;
	}
}
