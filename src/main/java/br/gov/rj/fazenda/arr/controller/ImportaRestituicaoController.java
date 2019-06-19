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

import br.gov.rj.fazenda.arr.dao.ImportaRestituicaoDAO;
import br.gov.rj.fazenda.arr.model.ImportaRestituicaoModel;
import br.gov.rj.fazenda.arr.util.FormatadorUtil;
import br.gov.rj.fazenda.arr.util.LogMessageHandler;
import br.gov.rj.fazenda.arr.ws.impl.ImportacaoReceitaWS;
import br.gov.rj.fazenda.arr.ws.impl.ImportacaoReceitaWSImplService;
import br.gov.rj.fazenda.arr.ws.interfaces.ImportaRestituicaoIn;
import br.gov.rj.fazenda.arr.ws.interfaces.ImportaRestituicaoOut;
import br.gov.rj.fazenda.arr.ws.interfaces.ObjectFactory;

public class ImportaRestituicaoController 
{
	private static final Logger logger = Logger.getLogger(ImportaRestituicaoController.class.getName() );
	
	private static final int SIAFE_PROCESSOU = 0;

	private static final int PROCESSADO_SIM = 1;
	
	private static final int REJEITADO = 1;

	private static List<ImportaRestituicaoModel> listRestituicaoModel = new LinkedList<ImportaRestituicaoModel>();	
	
    public void Enviar()  throws IOException, ParseException, DatatypeConfigurationException, SQLException {
    
    	
    	
    	getListRestituicaoModel(listRestituicaoModel);
    	
    	if(listRestituicaoModel.isEmpty()){
    		logger.info(" NÃ£o existem recolhimentos de restituição para envio ao SIAFE ");
		}else{
			
			ImportacaoReceitaWSImplService importacaoReceitaWS = new ImportacaoReceitaWSImplService();
			ImportacaoReceitaWS port1 = importacaoReceitaWS.getImportacaoReceitaWSImplPort();
			for (ImportaRestituicaoModel item : listRestituicaoModel) {
				logger.info("Iniciando contato com siafe para envio do recolhimento com sq_envio = " + item.getSqSiafeEnvioRestituicao());
				item.setQtdTentativas(item.getQtdTentativas()+1);
    			item.setInProcessado( PROCESSADO_SIM );
				
				ImportaRestituicaoIn importacaoRestituicaoIn = new ImportaRestituicaoIn();
				
				if (item.getSqSistemaOrigem() != null) {
					importacaoRestituicaoIn.setCodSistema(Integer.parseInt(item.getSqSistemaOrigem()));
				}
				if (item.getSqTipoDocumento() != null) {
					importacaoRestituicaoIn.setCodTipoDocumento(Integer.parseInt(item.getSqTipoDocumento()));
				}
				if (item.getSqSiafeEnvioRestituicao() != null) {
					importacaoRestituicaoIn.setSequencial(Integer.parseInt(item.getSqSiafeEnvioRestituicao()));
				}
				if (item.getSqRestituicao() != null) {
					importacaoRestituicaoIn.setIdRestituicao(Long.parseLong(item.getSqRestituicao()));
				}
				if (item.getSqFatoRestituicao() != null) {
					importacaoRestituicaoIn.setCodFato(Integer.parseInt(item.getSqFatoRestituicao()));
				}
				if (item.getCoReceita() != null) {
					importacaoRestituicaoIn.setCodigoReceita(item.getCoReceita());
				}
				if (item.getSqCampoFinanceiro() != null) {
					importacaoRestituicaoIn.setCodCampoFinanceiro(Integer.parseInt(item.getSqCampoFinanceiro()));
				}	
				if (item.getCoForma() != null) {
					importacaoRestituicaoIn.setCodFormaRestituicao(Integer.parseInt(item.getCoForma()));
				}		
				importacaoRestituicaoIn.setCodUnidadeGestora(item.getNuUnidadeGestora());
				importacaoRestituicaoIn.setCodigoReceita(item.getCoReceita());
				importacaoRestituicaoIn.setDataPagamento(FormatadorUtil.dateToXML(item.getDtPagamento()));
				importacaoRestituicaoIn.setDataBaseCorrecao(FormatadorUtil.dateToXML(item.getDtPagamento()));
				importacaoRestituicaoIn.setDataArrecadacao(FormatadorUtil.dateToXML(item.getDtPagamento()));
				importacaoRestituicaoIn.setDataRepasse(FormatadorUtil.dateToXML(item.getDtPagamento()));
				importacaoRestituicaoIn.setDataSinalizacao(FormatadorUtil.dateToXML(item.getDtPagamento()));
				importacaoRestituicaoIn.setDataRestituicao(FormatadorUtil.dateToXML(item.getDtPagamento()));
				
				if (item.getCoMunicipio() != null) {
					importacaoRestituicaoIn.setCodMunicipio((new ObjectFactory()).createAbstractImportaReceitaInCodMunicipio(Integer.parseInt(item.getCoMunicipio())));
				}	
				importacaoRestituicaoIn.setValor(Double.parseDouble(item.getVlRestituicao()));
				importacaoRestituicaoIn.setCodRestituido(item.getNuDocRestituido());
				importacaoRestituicaoIn.setNomeRestituido(item.getNoRestituido());
				importacaoRestituicaoIn.setCodBanco(item.getCoBanco());
				importacaoRestituicaoIn.setCodAgencia(item.getCoBanco());
				importacaoRestituicaoIn.setCodConta(item.getNuConta());
				
				 BindingProvider bindingProvider = (BindingProvider)port1;
		          Binding binding = bindingProvider.getBinding();
		          
		          @SuppressWarnings("rawtypes")
		          List<Handler> handlerChain = binding.getHandlerChain();
		          handlerChain.add(new LogMessageHandler(ImportaRestituicaoController.class));
		          binding.setHandlerChain(handlerChain);
			
				try{
					
					ImportaRestituicaoOut retornoSiafe = port1.importaRestituicao(importacaoRestituicaoIn);
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
					
					logger.info("sq_envio = " + item.getSqSiafeEnvioRestituicao() + " foi enviado com sucesso ");
				} catch (Exception e){
					item.setInEnviado(0);
					
					logger.error("sq_envio = " + item.getSqSiafeEnvioRestituicao() + ". Entrar em contato com o Administrador do sistema no SIAFE, e informar: " + e.getMessage());
					item.setTxMesagemRetorno(e.getStackTrace().toString());
					
				}
				atualizaArrecadacaoModel(item);
			}		
					
				
				
			
		}
        
    	
    	
    	
    }
    
    public static List<ImportaRestituicaoModel> getListRestituicaoModel(
			List<ImportaRestituicaoModel> listArrecadacaoModel) throws IOException {

    	ImportaRestituicaoDAO dao = new ImportaRestituicaoDAO();

		for (ImportaRestituicaoModel importaRestituicaoModel : dao.getRestituicaoModel()) {
			listArrecadacaoModel.add(importaRestituicaoModel);
		}

		return listArrecadacaoModel;
	}
    
    public static void atualizaArrecadacaoModel(
			ImportaRestituicaoModel res) throws IOException, SQLException {

    	ImportaRestituicaoDAO dao = new ImportaRestituicaoDAO();
    	dao.atualizaRegistro(res);
		

		
	}
    
   public static XMLGregorianCalendar FormatadorUtil(String date) throws ParseException, DatatypeConfigurationException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(sdf.parse(date));
		XMLGregorianCalendar xmlGregCal =  DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);

		return xmlGregCal;
   }
   
}
