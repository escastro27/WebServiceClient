package br.gov.rj.fazenda.arr.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import br.gov.rj.fazenda.arr.jdbc.ConnectionFactory;
import br.gov.rj.fazenda.arr.model.ImportaReceitaModel;

public class ImportaReceitaDAO {
	
		private Connection connection;

		public ImportaReceitaDAO() throws IOException {
			this.connection = new ConnectionFactory().getConnection();
		}

		public List<ImportaReceitaModel> getArrecadacaoModel() throws IOException {

			StringBuffer sql = new StringBuffer();

			sql.append("SELECT sea.SQ_SIAFE_ENVIO_ARRECADACAO, sea.SQ_SISTEMA, sea.SQ_TIPO_DOCUMENTO, ");
			sql.append("sea.CO_RECEITA, sea.SQ_CAMPO_FINANCEIRO, sea.IN_APOSTILAMENTO, sea.NU_UNIDADE_GESTORA, sea.DT_ARRECADACAO, ");
			sql.append("sea.DT_REPASSE, sea.DT_APOSTILAMENTO, sea.CO_MUNICIPIO, sea.VL_TOTAL, sea.NU_CNPJ_CPF_DEPOSITANTE, ");
			sql.append("sea.NO_DEPOSITANTE, sea.IN_CREDITO, sea.IN_PROCESSADO, sea.IN_ENVIADO, nvl(sea.qt_tentativa,0) QT_TENTATIVA ");
			sql.append("FROM ARR.SIAFE_ENVIO_ARRECADACAO sea WHERE sea.IN_ENVIADO = 0 AND ROWNUM <= 100 ");
			try {
				PreparedStatement stmt = connection.prepareStatement(sql.toString());
				ResultSet rs = stmt.executeQuery();
				List<ImportaReceitaModel> listArrecadacaoModel = new LinkedList<ImportaReceitaModel>();

				while (rs.next()) {
					ImportaReceitaModel importaReceitaModel = new ImportaReceitaModel();

					importaReceitaModel.setSqSiafeEnvioArrecadacao(rs.getString("SQ_SIAFE_ENVIO_ARRECADACAO"));
					importaReceitaModel.setSqSistema(rs.getString("SQ_SISTEMA"));
					importaReceitaModel.setSqTipoDocumento(rs.getString("SQ_TIPO_DOCUMENTO"));
					importaReceitaModel.setCoReceita(rs.getString("CO_RECEITA"));
					importaReceitaModel.setSqCampoFinanceiro(rs.getString("SQ_CAMPO_FINANCEIRO"));
					importaReceitaModel.setInApostilamento(rs.getString("IN_APOSTILAMENTO"));
					importaReceitaModel.setNuUnidadeGestora(rs.getString("NU_UNIDADE_GESTORA"));
					importaReceitaModel.setDtArrecadacao(rs.getString("DT_ARRECADACAO"));
					importaReceitaModel.setDtRepasse(rs.getString("DT_REPASSE"));
					importaReceitaModel.setDtApostilamento(rs.getString("DT_APOSTILAMENTO"));
					importaReceitaModel.setCoMunicipio(rs.getString("CO_MUNICIPIO"));
					importaReceitaModel.setVlTotal(rs.getString("VL_TOTAL"));
					importaReceitaModel.setNuCnpjCpfDepositante(rs.getString("NU_CNPJ_CPF_DEPOSITANTE"));
					importaReceitaModel.setNoDepositante(rs.getString("NO_DEPOSITANTE"));
					importaReceitaModel.setInCredito(rs.getString("IN_CREDITO"));
					importaReceitaModel.setInProcessado(rs.getInt("IN_PROCESSADO"));
					importaReceitaModel.setInEnviado(rs.getInt("IN_ENVIADO"));
					importaReceitaModel.setQtdTentativas(rs.getInt("QT_TENTATIVA"));
					
					listArrecadacaoModel.add(importaReceitaModel);
				}
				rs.close();
				stmt.close();
				return listArrecadacaoModel;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}

		}
		
		public void atualizaRegistro(ImportaReceitaModel arr) throws SQLException {
			StringBuffer sql = new StringBuffer();
			
			sql.append("UPDATE ARR.SIAFE_ENVIO_ARRECADACAO SET IN_ENVIADO = ?, IN_PROCESSADO = ?, IN_REJEITADO = ?, ");
			sql.append("CO_RETORNO = ?, TX_MENSAGEM_RETORNO = ? ");
			sql.append(" ,QT_TENTATIVA = ?");
			sql.append(" WHERE SQ_SIAFE_ENVIO_ARRECADACAO = ?");
			
			PreparedStatement stmt = connection.prepareStatement(sql.toString());
			stmt.setInt(1, arr.getInEnviado());
			stmt.setInt(2, arr.getInProcessado());
			stmt.setInt(3, arr.getInRejeitado());
			stmt.setString(4, arr.getCoRetorno());
			stmt.setString(5, arr.getTxMesagemRetorno());
			stmt.setInt(6, arr.getQtdTentativas());
			stmt.setString(7, arr.getSqSiafeEnvioArrecadacao());

			stmt.executeUpdate();
			stmt.close();
			
		}

	}


