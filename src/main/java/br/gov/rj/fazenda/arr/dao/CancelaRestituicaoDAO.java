package br.gov.rj.fazenda.arr.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import br.gov.rj.fazenda.arr.jdbc.ConnectionFactory;
import br.gov.rj.fazenda.arr.model.CancelaRestituicaoModel;

public class CancelaRestituicaoDAO {
	
	

		private Connection connection;

		public CancelaRestituicaoDAO() throws IOException {
			this.connection = new ConnectionFactory().getConnection();
		}

		public List<CancelaRestituicaoModel> getCancelaRestituicaoModel() throws IOException {

			StringBuffer sql = new StringBuffer();

			sql.append("select secr.SQ_SIAFE_ENVIO_CANCELA_RESTIT, secr.SQ_SISTEMA_ORIGEM, secr.SQ_RESTITUICAO, ");
			sql.append("secr.CO_RECEITA, secr.SQ_CAMPO_FINANCEIRO, secr.IN_REJEITADO, secr.IN_PROCESSADO, secr.IN_ENVIADO, secr.QT_TENTATIVA   	from ARR.SIAFE_ENVIO_CANCELA_RESTIT secr "); 
			sql.append("where secr.IN_ENVIADO = 0 AND ROWNUM <= 100 ");
			try {
				PreparedStatement stmt = connection.prepareStatement(sql.toString());
				ResultSet rs = stmt.executeQuery();
				List<CancelaRestituicaoModel> listCancelaRestituicaooModel = new LinkedList<CancelaRestituicaoModel>();

				while (rs.next()) {
					CancelaRestituicaoModel cancelaRestituicaoModel = new CancelaRestituicaoModel();

					cancelaRestituicaoModel.setSqSiafeEnvioCancRestituicao(rs.getString("SQ_SIAFE_ENVIO_CANCELA_RESTIT"));
					cancelaRestituicaoModel.setSqSistemaOrigem(rs.getString("SQ_SISTEMA_ORIGEM"));
					cancelaRestituicaoModel.setSqRestituicao(rs.getString("SQ_RESTITUICAO"));
					cancelaRestituicaoModel.setCoReceita(rs.getString("CO_RECEITA"));
					cancelaRestituicaoModel.setSqCampoFinanceiro(rs.getString("SQ_CAMPO_FINANCEIRO"));
					
					cancelaRestituicaoModel.setInRejeitado(rs.getInt("IN_REJEITADO"));
					cancelaRestituicaoModel.setInProcessado(rs.getInt("IN_PROCESSADO"));
					cancelaRestituicaoModel.setInEnviado(rs.getInt("IN_ENVIADO"));
					cancelaRestituicaoModel.setQtdTentativas(rs.getInt("QT_TENTATIVA"));
					
					listCancelaRestituicaooModel.add(cancelaRestituicaoModel);
				}
				rs.close();
				stmt.close();
				return listCancelaRestituicaooModel;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}

		}
		
		public void atualizaRegistro(CancelaRestituicaoModel canRest) throws SQLException {
			StringBuffer sql = new StringBuffer();
			
			sql.append("UPDATE ARR.SIAFE_ENVIO_CANCELA_RESTIT SET IN_ENVIADO = ?, IN_PROCESSADO = ?, IN_REJEITADO = ?, ");
			sql.append("CO_RETORNO = ?, TX_MENSAGEM_RETORNO = ? ");
			sql.append(" ,QT_TENTATIVA = ?");
			sql.append(" WHERE SQ_SIAFE_ENVIO_CANCELA_RESTIT = ?");
			
			PreparedStatement stmt = connection.prepareStatement(sql.toString());
			stmt.setInt(1, canRest.getInEnviado());
			stmt.setInt(2, canRest.getInProcessado());
			stmt.setInt(3, canRest.getInRejeitado());
			stmt.setString(4, canRest.getCoRetorno());
			stmt.setString(5, canRest.getTxMesagemRetorno());
			stmt.setInt(6, canRest.getQtdTentativas());
			stmt.setString(7, canRest.getSqSiafeEnvioCancRestituicao());

			stmt.executeUpdate();
			stmt.close();
			
		}

	}


