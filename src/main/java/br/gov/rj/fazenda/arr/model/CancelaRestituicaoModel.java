package br.gov.rj.fazenda.arr.model;

public class CancelaRestituicaoModel {

	


	private String sqSiafeEnvioCancRestituicao;
	private String sqSistemaOrigem;
	private String sqRestituicao;
	private String coReceita;
	private String sqCampoFinanceiro;
	private Integer	inProcessado;
	private Integer inEnviado; 
	private String coRetorno;
	private String TxMesagemRetorno;
	private Integer qtdTentativas;
	private Integer inRejeitado = 0;
	
	public String getCoReceita() {
		return coReceita;
	}
	public void setCoReceita(String coReceita) {
		this.coReceita = coReceita;
	}
	public String getSqCampoFinanceiro() {
		return sqCampoFinanceiro;
	}
	public void setSqCampoFinanceiro(String sqCampoFinanceiro) {
		this.sqCampoFinanceiro = sqCampoFinanceiro;
	}

	
	public Integer getInProcessado() {
		return inProcessado;
	}
	public void setInProcessado(Integer inProcessado) {
		this.inProcessado = inProcessado;
	}
	public Integer getInEnviado() {
		return inEnviado;
	}
	public void setInEnviado(Integer inEnviado) {
		this.inEnviado = inEnviado;
	}
	public String getCoRetorno() {
		return coRetorno;
	}
	public void setCoRetorno(String coRetorno) {
		this.coRetorno = coRetorno;
	}
	public String getTxMesagemRetorno() {
		return TxMesagemRetorno;
	}
	public void setTxMesagemRetorno(String txMesagemRetorno) {
		TxMesagemRetorno = txMesagemRetorno;
	}
	public Integer getQtdTentativas() {
		return qtdTentativas;
	}
	public void setQtdTentativas(Integer qtdTentativas) {
		this.qtdTentativas = qtdTentativas;
	}
	public Integer getInRejeitado() {
		return inRejeitado;
	}
	public void setInRejeitado(Integer inRejeitado) {
		this.inRejeitado = inRejeitado;
	}
	public String getSqSiafeEnvioCancRestituicao() {
		return sqSiafeEnvioCancRestituicao;
	}
	public void setSqSiafeEnvioCancRestituicao(String sqSiafeEnvioCancRestituicao) {
		this.sqSiafeEnvioCancRestituicao = sqSiafeEnvioCancRestituicao;
	}
	public String getSqSistemaOrigem() {
		return sqSistemaOrigem;
	}
	public void setSqSistemaOrigem(String sqSistemaOrigem) {
		this.sqSistemaOrigem = sqSistemaOrigem;
	}
	public String getSqRestituicao() {
		return sqRestituicao;
	}
	public void setSqRestituicao(String sqRestituicao) {
		this.sqRestituicao = sqRestituicao;
	}
}
