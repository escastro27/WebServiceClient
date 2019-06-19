package br.gov.rj.fazenda.arr.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;

import org.apache.log4j.Logger;

import br.gov.rj.fazenda.arr.dao.ImportaReceitaDAO;
import br.gov.rj.fazenda.arr.model.ImportaReceitaModel;
import br.gov.rj.fazenda.arr.util.FormatadorUtil;
import br.gov.rj.fazenda.arr.util.LogMessageHandler;
import br.gov.rj.fazenda.arr.ws.impl.ImportacaoReceitaWS;
import br.gov.rj.fazenda.arr.ws.impl.ImportacaoReceitaWSImplService;
import br.gov.rj.fazenda.arr.ws.interfaces.ImportaReceitaIn;
import br.gov.rj.fazenda.arr.ws.interfaces.ImportaReceitaOut;
import br.gov.rj.fazenda.arr.ws.interfaces.ObjectFactory;




public class ImportaReceitaController 
{
	private static final Logger logger = Logger.getLogger(ImportaReceitaController.class.getName() );

	private static final int SIAFE_PROCESSOU = 0;

	private static final int PROCESSADO_SIM = 1;
	
	private static final int REJEITADO = 1;

	private static List<ImportaReceitaModel> listArrecadacaoModel = new LinkedList<ImportaReceitaModel>();	
	
    public void Enviar()  throws IOException, ParseException, DatatypeConfigurationException, SQLException {
    
    	
    	getListArrecadacaoModel(listArrecadacaoModel);
    	
    	if(listArrecadacaoModel.isEmpty()){
    		logger.info(" Nãoo existem recolhimentos de arrecadação para envio ao SIAFE ");
		}else{
			Boolean apostilar = false;
			
			ImportacaoReceitaWSImplService importacaoReceitaWS = new ImportacaoReceitaWSImplService();
			ImportacaoReceitaWS port1 = importacaoReceitaWS.getImportacaoReceitaWSImplPort();
			for (ImportaReceitaModel item : listArrecadacaoModel) {
				logger.info("Iniciando contato com siafe para envio do recolhimento com sq_envio = " + item.getSqSiafeEnvioArrecadacao());
				item.setQtdTentativas(item.getQtdTentativas()+1);
    			item.setInProcessado( PROCESSADO_SIM );
				apostilar = item.getInApostilamento().equals("1"); 
				ImportaReceitaIn importacaoReceitaIn = new ImportaReceitaIn();
				
				if (item.getSqSistema() != null) {
					importacaoReceitaIn.setCodSistema(Integer.parseInt(item.getSqSistema())); 
				}
				if (item.getSqTipoDocumento() != null) {
					importacaoReceitaIn.setCodTipoDocumento(Integer.parseInt(item.getSqTipoDocumento()));
				}
				if (item.getSqSiafeEnvioArrecadacao() != null) {
					importacaoReceitaIn.setSequencial(Integer.parseInt(item.getSqSiafeEnvioArrecadacao()));
				}
			
				
				importacaoReceitaIn.setDataArrecadacao(FormatadorUtil.dateToXML(item.getDtArrecadacao()));
				importacaoReceitaIn.setDataRepasse(FormatadorUtil.dateToXML(item.getDtRepasse()));
				importacaoReceitaIn.setValor(Double.parseDouble(item.getVlTotal()));
				if (item.getSqCampoFinanceiro() != null) {
					importacaoReceitaIn.setCodCampoFinanceiro(Integer.parseInt(item.getSqCampoFinanceiro()));
				}
				importacaoReceitaIn.setCodUnidadeGestora(item.getNuUnidadeGestora());
				importacaoReceitaIn.setCodigoReceita(item.getCoReceita());
				importacaoReceitaIn.setApostilamento(apostilar);
				if(apostilar && item.getDtApostilamento() != null){
					importacaoReceitaIn.setDataApostilamento(FormatadorUtil.dateToXML(item.getDtApostilamento()));
				}
				if (item.getCoMunicipio() != null) {
					importacaoReceitaIn.setCodMunicipio((new ObjectFactory()).createAbstractImportaReceitaInCodMunicipio(Integer.parseInt(item.getCoMunicipio())));
				}	
				
				importacaoReceitaIn.setNomeDepositante( item.getNoDepositante());
				importacaoReceitaIn.setCodDepositante( item.getNuCnpjCpfDepositante() );
				
				 BindingProvider bindingProvider = (BindingProvider)port1;
		          Binding binding = bindingProvider.getBinding();
		          
		          @SuppressWarnings("rawtypes")
		          List<Handler> handlerChain = binding.getHandlerChain();
		          handlerChain.add(new LogMessageHandler(ImportaReceitaController.class));
		          binding.setHandlerChain(handlerChain);
					

				try{
					ImportaReceitaOut retornoSiafe = port1.importaReceita(importacaoReceitaIn);
					item.setInEnviado(1);
					item.setCoRetorno(retornoSiafe.getCodigoRetorno().toString() );
					String mensagemRetorno = retornoSiafe.getMensagemRetorno();
					if(retornoSiafe.getCodigoRetorno() != SIAFE_PROCESSOU){
						item.setInRejeitado(REJEITADO);
						for ( String excessao : retornoSiafe.getExcecoes().getExcecao()){
							mensagemRetorno += " - ";
							mensagemRetorno += excessao;
						}
					}
					item.setTxMesagemRetorno(mensagemRetorno);
					
					logger.info("sq_envio = " + item.getSqSiafeEnvioArrecadacao() + " foi enviado com sucesso ");
				} catch (Exception e){
					item.setInEnviado(0);
					logger.error("sq_envio = " + item.getSqSiafeEnvioArrecadacao() + ". Entrar em contato com o Administrador do sistema no SIAFE, e informar: " + e.getMessage());
					item.setTxMesagemRetorno(e.getMessage());
					
				}
				atualizaArrecadacaoModel(item);
			}		
		}
        
    	
    	
    	
    }
    
    public static List<ImportaReceitaModel> getListArrecadacaoModel(
			List<ImportaReceitaModel> listArrecadacaoModel) throws IOException {

    	ImportaReceitaDAO dao = new ImportaReceitaDAO();

		for (ImportaReceitaModel importaReceitaModel : dao.getArrecadacaoModel()) {
			listArrecadacaoModel.add(importaReceitaModel);
		}

		return listArrecadacaoModel;
	}
    
    public static void atualizaArrecadacaoModel(
			ImportaReceitaModel arr) throws IOException, SQLException {

    	ImportaReceitaDAO dao = new ImportaReceitaDAO();
    	dao.atualizaRegistro(arr);
		

		
	}
    
   public static XMLGregorianCalendar FormatadorUtil(String date) throws ParseException, DatatypeConfigurationException {
		
	   SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(sdf.parse(date));
		XMLGregorianCalendar xmlGregCal =  DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);

		return xmlGregCal;
   }
  
    
}
