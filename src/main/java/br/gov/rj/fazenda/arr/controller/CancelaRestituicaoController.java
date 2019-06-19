package br.gov.rj.fazenda.arr.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;

import org.apache.log4j.Logger;

import br.gov.rj.fazenda.arr.dao.CancelaRestituicaoDAO;
import br.gov.rj.fazenda.arr.model.CancelaRestituicaoModel;
import br.gov.rj.fazenda.arr.util.LogMessageHandler;
import br.gov.rj.fazenda.arr.ws.impl.ImportacaoReceitaWS;
import br.gov.rj.fazenda.arr.ws.impl.ImportacaoReceitaWSImplService;
import br.gov.rj.fazenda.arr.ws.interfaces.CancelaRestituicaoIn;
import br.gov.rj.fazenda.arr.ws.interfaces.CancelaRestituicaoOut;




public class CancelaRestituicaoController 
{
	private static final Logger logger = Logger.getLogger(CancelaRestituicaoController.class.getName() );
	
	private static final int SIAFE_PROCESSOU = 0;

	private static final int REJEITADO_SIM = 1;
	
	private static final int PROCESSADO_SIM = 1;

	private static List<CancelaRestituicaoModel> listCancelaRestituicaoModel = new LinkedList<CancelaRestituicaoModel>();	
	
    public void Enviar()  throws IOException, ParseException, DatatypeConfigurationException, SQLException {
    
    	getListCancelaRestituicaoModel(listCancelaRestituicaoModel);
    	
    	if(listCancelaRestituicaoModel.isEmpty()){
    		logger.info(" Não existe recolhimentos para cancelamento de restituição para envio ao SIAFE ");
		}else{
			
			ImportacaoReceitaWSImplService importacaoReceitaWS = new ImportacaoReceitaWSImplService();
			ImportacaoReceitaWS port1 = importacaoReceitaWS.getImportacaoReceitaWSImplPort();
			for (CancelaRestituicaoModel item : listCancelaRestituicaoModel) {
				logger.info("Iniciando contato com siafe para envio do recolhimento com sq_envio = " + item.getSqSiafeEnvioCancRestituicao());
				item.setQtdTentativas(item.getQtdTentativas()+1);
    			item.setInProcessado( PROCESSADO_SIM );
				
    			CancelaRestituicaoIn cancelaRestituicaoIn = new CancelaRestituicaoIn();
				
				if (item.getSqSistemaOrigem() != null) {
					cancelaRestituicaoIn.setCodSistema(Integer.parseInt(item.getSqSistemaOrigem()));
				}
			
				if (item.getSqSiafeEnvioCancRestituicao() != null) {
					cancelaRestituicaoIn.setSequencial(Integer.parseInt(item.getSqSiafeEnvioCancRestituicao()));
				}
				if (item.getSqRestituicao() != null) {
					cancelaRestituicaoIn.setIdRestituicao(Long.parseLong(item.getSqRestituicao()));
				}
				
				if (item.getSqCampoFinanceiro() != null) {
					cancelaRestituicaoIn.setCodCampoFinanceiro(Integer.parseInt(item.getSqCampoFinanceiro()));
				}	
				
				 BindingProvider bindingProvider = (BindingProvider)port1;
		          Binding binding = bindingProvider.getBinding();
		          
		          @SuppressWarnings("rawtypes")
				  List<Handler> handlerChain = binding.getHandlerChain();
		          handlerChain.add(new LogMessageHandler(CancelaRestituicaoController.class));
		          binding.setHandlerChain(handlerChain);
				
				try{
					CancelaRestituicaoOut retornoSiafe = port1.cancelaRestituicao(cancelaRestituicaoIn);
					item.setInEnviado(1);
					item.setCoRetorno(retornoSiafe.getCodigoRetorno().toString() );
					String mensagemRetorno = retornoSiafe.getMensagemRetorno();
					if(retornoSiafe.getCodigoRetorno() != SIAFE_PROCESSOU){
						
						item.setInRejeitado(REJEITADO_SIM);
						for ( String excessao : retornoSiafe.getExcecoes().getExcecao()){
							mensagemRetorno += " - ";
							mensagemRetorno += excessao;
						}
					}
					item.setTxMesagemRetorno(mensagemRetorno);
					
					logger.info("sq_envio = " + item.getSqSiafeEnvioCancRestituicao() + " foi enviado com sucesso ");
				} catch (Exception e){
					item.setInEnviado(0);
					logger.error("sq_envio = " + item.getSqSiafeEnvioCancRestituicao() + ". Entrar em contato com o Administrador do sistema no SIAFE, e informar: " + e.getMessage());
					item.setTxMesagemRetorno(e.getStackTrace().toString());
				}
				atualizaCancelaRestituicaoModel(item);
			}		
		}
    }
    
    public static List<CancelaRestituicaoModel> getListCancelaRestituicaoModel(
			List<CancelaRestituicaoModel> listCancelaRestituicaoModel) throws IOException {

    	CancelaRestituicaoDAO dao = new CancelaRestituicaoDAO();

		for (CancelaRestituicaoModel cancelaRestituicaoModel : dao.getCancelaRestituicaoModel()) {
			listCancelaRestituicaoModel.add(cancelaRestituicaoModel);
		}

		return listCancelaRestituicaoModel;
	}
    
    public static void atualizaCancelaRestituicaoModel(
			CancelaRestituicaoModel res) throws IOException, SQLException {

    	CancelaRestituicaoDAO dao = new CancelaRestituicaoDAO();
    	dao.atualizaRegistro(res);
	}
    
  
	
}
