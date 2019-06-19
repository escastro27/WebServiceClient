package br.gov.rj.fazenda.util;

import java.io.IOException;

import org.apache.log4j.Logger;

import br.gov.rj.fazenda.dao.ControleDAO;
import br.gov.rj.fazenda.main.ExecutaProcedures;


/**
 * Classe que realiza o checklist no ambiente a ser usado pelo JOB.
 * 
 * @author gcarneiro
 *
 */
public class CheckList {
	private static final Logger LOGGER = Logger.getLogger(ExecutaProcedures.class.getName() );
	
	/**
	 * Metodo principal a ser chamado para realizar o checklist no ambiente.
	 * 
	 * @return
	 * @throws IOException 
	 */
	public static void checkList(String _config) throws IOException {
		// Status padrao
		Boolean status = Boolean.TRUE;

		// Mensagem no console
		defineMensagem("INFO0001 - REALIZANDO O CHECK-LIST PARA A EXECUCAO DO JOB");


		// Verifica se ja existe alguma instancia do projeto em execucao
		if (verificaExecucao(_config)) {
			status = Boolean.FALSE;
		}

		// Verifica a conectividade com o banco de controle
		if (!checkDBControle()) {
			status = Boolean.FALSE;
		}

		// Verifoca a situacao do checklist
		if (status) {
			defineMensagem("INFO0001 - CHECKLIST COMPLETO - NENHUM ERRO ENCONTRADO");
		} else {
			defineMensagem("[FALHA] CHEK0001 - FALHAS IDENTIFICADAS NO CHECKLIST, FINALIZANDO PROCESSO DO JOB.");
			System.exit(1);
		}
	}

	
	/**
	 * Verifica a conectividade com o controle.
	 * 
	 * @return
	 */
	private static boolean checkDBControle() {
		Boolean status = Boolean.TRUE;
		ControleDAO controleDAO;
		try {
			// Tenta realizar a conexao com o banco de dados
			controleDAO = new ControleDAO();
			
			if(controleDAO.testaConexaoControle())
			{
				defineMensagem("[OK] INFO0001 - CONEXAO COM SUCESSO AO BANCO DE DADOS DO CONTROLE");
			}
			else
			{
				defineMensagem("[FALHA] CHEK0002 - OCORREU UM ERRO AO COENCTAR NO BANCO DE DADOS DE CONTROLE");
			}

			
		} catch (Exception ex) {
			// Apresenta mensagem
			defineMensagem("[FALHA] CHEK0002 - OCORREU UM ERRO AO COENCTAR NO BANCO DE DADOS DE CONTROLE [" + ex.getMessage() + "]");

			// Retorno de status
			status = Boolean.FALSE;
		}

		return status;
	}

	/**
	 * Verifica se ja existe alguma instancia do projeto em execucao
	 * 
	 * @return
	 * @throws IOException 
	 */
	private static boolean verificaExecucao(String _config) throws IOException {
		Boolean status = Boolean.TRUE;

		// Define o nome do arquivo look
		String name = "travaInstancia_" + _config + ".look".replaceAll("[//\\.]", "_");

		// Verifica se arquivo encontra-se travado
		if (Util.verificaExecucao(name)) {
			defineMensagem(
					"[FALHA] CHEK0003 - JA EXISTE UMA INSTANCIA EM EXECUCAO PARA A CONFIGURACAO [" + _config + "], FINALIZE A MENSMA OU TENTE MAIS TARDE.");
		} else {
			defineMensagem("[OK] INFO0001 - NENHUMA INSTANCIA NO SERVIDOR EM EXECUCAO.");
			status = Boolean.FALSE;
		}

		return status;
	}

	/**
	 * Define a saida de uma mensagem
	 * 
	 * @param mensagem
	 */
	private static void defineMensagem(String mensagem) {
		LOGGER.info(mensagem);
	}
}
