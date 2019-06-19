package br.gov.rj.fazenda.arr.model;

public class ImportaReceitaModel {
	
	private String sqSiafeEnvioArrecadacao;
	private String sqSistema;
	private String sqTipoDocumento;
	private String coReceita;
	private String sqCampoFinanceiro;
	private String inApostilamento;
	private String nuUnidadeGestora;
	private String dtArrecadacao;
	private String dtRepasse;
	private String dtApostilamento;
	private String coMunicipio;
	private String vlTotal;
	private String nuCnpjCpfDepositante;
	private String noDepositante;
	private String inCredito;
	private Integer	inProcessado;
	private Integer inEnviado; 
	private String coRetorno;
	private String TxMesagemRetorno;
	private Integer qtdTentativas;
	private Integer inRejeitado = 0;
	
	public String getSqSiafeEnvioArrecadacao() {
		return sqSiafeEnvioArrecadacao;
	}
	public void setSqSiafeEnvioArrecadacao(String sqSiafeEnvioArrecadacao) {
		this.sqSiafeEnvioArrecadacao = sqSiafeEnvioArrecadacao;
	}
	public String getSqSistema() {
		return sqSistema;
	}
	public void setSqSistema(String sqSistema) {
		this.sqSistema = sqSistema;
	}
	public String getSqTipoDocumento() {
		return sqTipoDocumento;
	}
	public void setSqTipoDocumento(String sqTipoDocumento) {
		this.sqTipoDocumento = sqTipoDocumento;
	}
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
	public String getInApostilamento() {
		return inApostilamento;
	}
	public void setInApostilamento(String inApostilamento) {
		this.inApostilamento = inApostilamento;
	}
	public String getNuUnidadeGestora() {
		return nuUnidadeGestora;
	}
	public void setNuUnidadeGestora(String nuUnidadeGestora) {
		this.nuUnidadeGestora = nuUnidadeGestora;
	}
	public String getDtArrecadacao() {
		return dtArrecadacao;
	}
	public void setDtArrecadacao(String dtArrecadacao) {
		this.dtArrecadacao = dtArrecadacao;
	}
	public String getDtRepasse() {
		return dtRepasse;
	}
	public void setDtRepasse(String dtRepasse) {
		this.dtRepasse = dtRepasse;
	}
	public String getDtApostilamento() {
		return dtApostilamento;
	}
	public void setDtApostilamento(String dtApostilamento) {
		this.dtApostilamento = dtApostilamento;
	}
	public String getCoMunicipio() {
		return coMunicipio;
	}
	public void setCoMunicipio(String coMunicipio) {
		this.coMunicipio = coMunicipio;
	}
	public String getVlTotal() {
		return vlTotal;
	}
	public void setVlTotal(String vlTotal) {
		this.vlTotal = vlTotal;
	}
	public String getNuCnpjCpfDepositante() {
		return nuCnpjCpfDepositante;
	}
	public void setNuCnpjCpfDepositante(String nuCnpjCpfDepositante) {
		this.nuCnpjCpfDepositante = nuCnpjCpfDepositante;
	}
	public String getNoDepositante() {
		return noDepositante;
	}
	public void setNoDepositante(String noDepositante) {
		this.noDepositante = noDepositante;
	}
	public String getInCredito() {
		return inCredito;
	}
	public void setInCredito(String inCredito) {
		this.inCredito = inCredito;
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
}
