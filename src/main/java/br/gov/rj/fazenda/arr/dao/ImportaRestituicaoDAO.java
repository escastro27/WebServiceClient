package br.gov.rj.fazenda.arr.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import br.gov.rj.fazenda.arr.jdbc.ConnectionFactory;
import br.gov.rj.fazenda.arr.model.ImportaRestituicaoModel;

public class ImportaRestituicaoDAO {
	

		private Connection connection;

		public ImportaRestituicaoDAO() throws IOException {
			this.connection = new ConnectionFactory().getConnection();
		}

		public List<ImportaRestituicaoModel> getRestituicaoModel() throws IOException {

			StringBuffer sql = new StringBuffer();

			sql.append("select ser.SQ_SIAFE_ENVIO_RESTITUICAO, ser.SQ_SISTEMA_ORIGEM, ser.SQ_RESTITUICAO, ");
			sql.append("ser.SQ_TIPO_DOCUMENTO, ser.SQ_FATO_RESTITUICAO, ser.CO_RECEITA, ser.SQ_CAMPO_FINANCEIRO, "); 
			sql.append("ser.CO_FORMA, ser.NU_UNIDADE_GESTORA, ser.DT_PAGAMENTO, ser.DT_BASE_ATUALIZ_MONETARIA, "); 
			sql.append("ser.DT_ARRECADACAO, ser.DT_REPASSE, ser.DT_SINALIZACAO_RESTITUICAO, ser.DT_AGENDA_RESTITUICAO, "); 
			sql.append("ser.CO_MUNICIPIO, ser.VL_RESTITUICAO, ser.NU_DOC_RESTITUIDO, ser.NO_RESTITUIDO, ser.CO_BANCO, "); 
			sql.append("ser.CO_AGENCIA, ser.NU_CONTA, ser.IN_ENVIADO, ser.IN_REJEITADO, ser.IN_PROCESSADO, ser.CO_RETORNO, "); 
			sql.append("ser.TX_MENSAGEM_RETORNO, ser.QT_TENTATIVA from ARR.SIAFE_ENVIO_RESTITUICAO ser "); 
			sql.append("WHERE ser.IN_ENVIADO = 0 AND ROWNUM <= 100");
			try {
				PreparedStatement stmt = connection.prepareStatement(sql.toString());
				ResultSet rs = stmt.executeQuery();
				List<ImportaRestituicaoModel> listRestituicaoModel = new LinkedList<ImportaRestituicaoModel>();

				while (rs.next()) {
					ImportaRestituicaoModel importaRestituicaoModel = new ImportaRestituicaoModel();

					importaRestituicaoModel.setSqSiafeEnvioRestituicao(rs.getString("SQ_SIAFE_ENVIO_RESTITUICAO"));
					importaRestituicaoModel.setSqSistemaOrigem(rs.getString("SQ_SISTEMA_ORIGEM"));
					importaRestituicaoModel.setSqRestituicao(rs.getString("SQ_RESTITUICAO"));
					importaRestituicaoModel.setSqTipoDocumento(rs.getString("SQ_TIPO_DOCUMENTO"));
					importaRestituicaoModel.setSqFatoRestituicao(rs.getString("SQ_FATO_RESTITUICAO"));
					importaRestituicaoModel.setCoReceita(rs.getString("CO_RECEITA"));
					importaRestituicaoModel.setSqCampoFinanceiro(rs.getString("SQ_CAMPO_FINANCEIRO"));
					importaRestituicaoModel.setCoForma(rs.getString("CO_FORMA"));
					importaRestituicaoModel.setNuUnidadeGestora(rs.getString("NU_UNIDADE_GESTORA"));
					importaRestituicaoModel.setDtPagamento(rs.getString("DT_PAGAMENTO"));
					importaRestituicaoModel.setDtBaseAtualMonetaria(rs.getString("DT_BASE_ATUALIZ_MONETARIA"));
					importaRestituicaoModel.setDtArrecadacao(rs.getString("DT_ARRECADACAO"));
					importaRestituicaoModel.setDtRepasse(rs.getString("DT_REPASSE"));
					importaRestituicaoModel.setDtSinalizaRestituicao(rs.getString("DT_SINALIZACAO_RESTITUICAO"));
					importaRestituicaoModel.setDtAgendaRestituicao(rs.getString("DT_AGENDA_RESTITUICAO"));
					importaRestituicaoModel.setCoMunicipio(rs.getString("CO_MUNICIPIO"));
					
					importaRestituicaoModel.setVlRestituicao(rs.getString("VL_RESTITUICAO"));
					importaRestituicaoModel.setNuDocRestituido(rs.getString("NU_DOC_RESTITUIDO"));
					importaRestituicaoModel.setNoRestituido(rs.getString("NO_RESTITUIDO"));
					importaRestituicaoModel.setCoBanco(rs.getString("CO_BANCO"));
					importaRestituicaoModel.setCoAgencia(rs.getString("CO_AGENCIA"));
					importaRestituicaoModel.setNuConta(rs.getString("NU_CONTA"));
					importaRestituicaoModel.setInRejeitado(rs.getInt("IN_REJEITADO"));
					importaRestituicaoModel.setInProcessado(rs.getInt("IN_PROCESSADO"));
					importaRestituicaoModel.setInEnviado(rs.getInt("IN_ENVIADO"));
					importaRestituicaoModel.setQtdTentativas(rs.getInt("QT_TENTATIVA"));
					
					listRestituicaoModel.add(importaRestituicaoModel);
				}
				rs.close();
				stmt.close();
				return listRestituicaoModel;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}

		}
		
		public void atualizaRegistro(ImportaRestituicaoModel arr) throws SQLException {
			StringBuffer sql = new StringBuffer();
			
			sql.append("UPDATE ARR.SIAFE_ENVIO_RESTITUICAO SET IN_ENVIADO = ?, IN_PROCESSADO = ?, IN_REJEITADO = ?, ");
			sql.append("CO_RETORNO = ?, TX_MENSAGEM_RETORNO = ? ");
			sql.append(" ,QT_TENTATIVA = ?");
			sql.append(" WHERE SQ_SIAFE_ENVIO_RESTITUICAO = ?");
			
			PreparedStatement stmt = connection.prepareStatement(sql.toString());
			stmt.setInt(1, arr.getInEnviado());
			stmt.setInt(2, arr.getInProcessado());
			stmt.setInt(3, arr.getInRejeitado());
			stmt.setString(4, arr.getCoRetorno());
			stmt.setString(5, arr.getTxMesagemRetorno());
			
			stmt.setInt(6, arr.getQtdTentativas());
			stmt.setString(7, arr.getSqSiafeEnvioRestituicao());

			stmt.executeUpdate();
			stmt.close();
			
		}

	}


