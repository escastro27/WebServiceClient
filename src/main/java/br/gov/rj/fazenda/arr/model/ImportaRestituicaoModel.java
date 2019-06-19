package br.gov.rj.fazenda.arr.model;

public class ImportaRestituicaoModel {
	
	private String sqSiafeEnvioRestituicao;
	private String sqSistemaOrigem;
	private String sqRestituicao;
	private String sqTipoDocumento;
	private String sqFatoRestituicao;
	private String coReceita;
	private String sqCampoFinanceiro;
	private String coForma;
	private String nuUnidadeGestora;
	private String dtPagamento;
	private String dtBaseAtualMonetaria;
	private String dtArrecadacao;
	private String dtRepasse;
	private String dtSinalizaRestituicao;
	private String dtAgendaRestituicao;
	private String coMunicipio;
	private String vlRestituicao;
	private String nuDocRestituido;
	private String noRestituido;
	private String coBanco;
	private String coAgencia;
	private String nuConta;
	private Integer	inProcessado;
	private Integer inEnviado; 
	private String coRetorno;
	private String TxMesagemRetorno;
	private Integer qtdTentativas;
	private Integer inRejeitado = 0;
	
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
	
	public String getCoMunicipio() {
		return coMunicipio;
	}
	public void setCoMunicipio(String coMunicipio) {
		this.coMunicipio = coMunicipio;
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
	public String getSqSiafeEnvioRestituicao() {
		return sqSiafeEnvioRestituicao;
	}
	public void setSqSiafeEnvioRestituicao(String sqSiafeEnvioRestituicao) {
		this.sqSiafeEnvioRestituicao = sqSiafeEnvioRestituicao;
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
	public String getSqFatoRestituicao() {
		return sqFatoRestituicao;
	}
	public void setSqFatoRestituicao(String sqFatoRestituicao) {
		this.sqFatoRestituicao = sqFatoRestituicao;
	}
	public String getCoForma() {
		return coForma;
	}
	public void setCoForma(String coForma) {
		this.coForma = coForma;
	}
	public String getDtPagamento() {
		return dtPagamento;
	}
	public void setDtPagamento(String dtPagamento) {
		this.dtPagamento = dtPagamento;
	}
	public String getDtBaseAtualMonetaria() {
		return dtBaseAtualMonetaria;
	}
	public void setDtBaseAtualMonetaria(String dtBaseAtualMonetaria) {
		this.dtBaseAtualMonetaria = dtBaseAtualMonetaria;
	}
	public String getDtSinalizaRestituicao() {
		return dtSinalizaRestituicao;
	}
	public void setDtSinalizaRestituicao(String dtSinalizaRestituicao) {
		this.dtSinalizaRestituicao = dtSinalizaRestituicao;
	}
	public String getDtAgendaRestituicao() {
		return dtAgendaRestituicao;
	}
	public void setDtAgendaRestituicao(String dtAgendaRestituicao) {
		this.dtAgendaRestituicao = dtAgendaRestituicao;
	}
	public String getVlRestituicao() {
		return vlRestituicao;
	}
	public void setVlRestituicao(String vlRestituicao) {
		this.vlRestituicao = vlRestituicao;
	}
	public String getNuDocRestituido() {
		return nuDocRestituido;
	}
	public void setNuDocRestituido(String nuDocRestituido) {
		this.nuDocRestituido = nuDocRestituido;
	}
	public String getCoBanco() {
		return coBanco;
	}
	public void setCoBanco(String coBanco) {
		this.coBanco = coBanco;
	}
	public String getCoAgencia() {
		return coAgencia;
	}
	public void setCoAgencia(String coAgencia) {
		this.coAgencia = coAgencia;
	}
	public String getNuConta() {
		return nuConta;
	}
	public void setNuConta(String nuConta) {
		this.nuConta = nuConta;
	}
	public String getNoRestituido() {
		return noRestituido;
	}
	public void setNoRestituido(String noRestituido) {
		this.noRestituido = noRestituido;
	}
}
