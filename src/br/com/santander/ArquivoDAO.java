package br.com.santander;


public class ArquivoDAO {

//	public static void main(String[]args){
////		gerarArquivo();
//		lerArquivo();
//	}
//
//	public static void gerarArquivo(){
//		Connection con  = null;
//		PreparedStatement stmt = null;
//		ResultSet res = null;
//		try{
//			con = ConnectionFactory.getConection(Defines.BANCO_LOGIN, Defines.USUARIO_LOGIN, Defines.SENHA_LOGIN);
//		    con.setAutoCommit(false);
//			
//		    //Cria��o do arquivo
//		    int mId = 11;
//			try{
//				String query = "select id_arq from arquivo_remessa order by id_arq desc limit 1 ";
//				stmt = con.prepareStatement(query);
//				res = stmt.executeQuery();
//				mId = 11;
//				if(res.next()){
//					mId = res.getInt(1)+1;
//				}
//			}catch(Exception e){
//				e.printStackTrace();
//				return;
//			}finally{
//				stmt.close();
//			}
//
//			List<Boleto> boletos = BoletoDAO.boletosHoje();
//			Arquivo arq = Arquivo.criar(mId, boletos);
//			File file = arq.write();
//			
//			
//			//Gravar no banco
//			try{
//				String query = "INSERT INTO `arquivo_remessa` "
//						+ "(`id_arq`, `data_arq`, `arquivo_arq`, `status_arq`) "
//						+ "VALUES (?, ?, ?, 1);";
//				stmt = con.prepareStatement(query);
//				stmt.setInt(1, arq.getId());
//				stmt.setDate(2, new Date(Tools.now().getMillis()));
//				FileInputStream fis = new FileInputStream(file);
//				stmt.setBinaryStream(3, fis, (int) file.length());
//								
//				int re = stmt.executeUpdate();
//				if(re == 0){
//					con.rollback();
//					System.out.println("Erro desconhecido ao inserir arquivo");
//					return;
//				}
//			}catch(Exception e){
//				e.printStackTrace();
//				return;
//			}finally{
//				stmt.close();
//			}
//			
//			
//			//Alterar os boletos
//			for(Boleto boleto : boletos){
//				boleto.setIdArquivo(arq.getId());
//			}
//			
//			MareResponse resBoleto = BoletoDAO.registrarPagamento(boletos, con);
//			if(resBoleto.getStatus() != 201){
//				con.rollback();
//				System.out.println("Erro ao registrar boletos");
//				return;
//			}
//			
//			
//			boolean bol = MailManager
//					.mailTo("otavio.marchioli@prompweb.com.br")
//					.withSubject("Arquivo remessa - "+file.getName())
//					.withMessage("Arquivo de remessa - "+Tools.now().toString("dd/MM/yyyy"))
//					.attatch(file.getPath(), file.getName())
//					.send();
//			
//			if (bol){
//				con.commit();
//				return;
//			}
//			
//			con.rollback();
//
//		}catch(Exception e){
//			e.printStackTrace();
//			return;
//		}finally{
//			ConnectionFactory.close(con, stmt, null);
//		}
//	}
//
//
//	public static void lerArquivo(){
//		try {
//			FileInputStream f = new FileInputStream("C:/Users/Administrador/Desktop/arq/FORN_TTC5_02_030816P_MOV_00333044004902599853.txt");
//			Arquivo arq = Arquivo.ler(f);
//			for(SantanderLote<?> l : arq.getLotes()){
//				if(l instanceof TitulosBancarios){
//					TitulosBancarios tt = (TitulosBancarios)l;
//					if(tt.getSegmentoZ() == null || tt.getSegmentoJ() == null)continue;
//					Boleto boleto = Boleto.ler(tt.getSegmentoJ().CodigodeBarras.getValue());
//					boleto.setDataConfirmacao(Tools.now());
//					boleto.setAutenticacaoPagamento(tt.getSegmentoZ().AutenticacaodoPagamento.getValue());
//					boleto.setProtocoloPagamento(tt.getSegmentoZ().ProtocolodoPagamento.getValue());
//					boleto.setOcorrenciasPagamento(tt.getSegmentoZ().OcorrenciasparaoRetorno.getValue());
////					MareResponse res = BoletoDAO.darBaixa(boleto);
//					
//					System.out.println(boleto);
//					
//				}
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//
}
