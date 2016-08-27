package br.com.pw.antares.febraban.lotes;

import java.util.List;

import br.com.pw.antares.baseclasses.AntaresLineBatch;
import br.com.pw.antares.febraban.enums.TipoRegistro;
import br.com.pw.antares.febraban.enums.TipoSegmento;
import br.com.pw.antares.febraban.segmentos.Header;
import br.com.pw.antares.febraban.segmentos.SegmentoB;
import br.com.pw.antares.febraban.segmentos.SegmentoJ;
import br.com.pw.antares.febraban.segmentos.SegmentoJ52;
import br.com.pw.antares.febraban.segmentos.SegmentoZ;
import br.com.pw.antares.febraban.segmentos.Trailer;

public class TitulosBancarios extends AntaresLineBatch{

	protected TitulosBancarios(boolean include, int sequence) {
		super(1, "Titulos Bancários",sequence, include);
	}

	private Header header = new Header(true, this);
	private SegmentoJ segmentoJ = new SegmentoJ(true, this);
	private SegmentoJ52 segmentoJ52 = new SegmentoJ52(false, this);
	private SegmentoB segmentoB = new SegmentoB(true, this);
	private SegmentoZ segmentoZ = new SegmentoZ(false, this);
	private Trailer trailer = new Trailer(true, this);

	//	public static TitulosBancarios criarLote(Boleto boleto, int sequencia) throws Exception{
	//		TitulosBancarios r = new TitulosBancarios();
	//		r.sequencia = sequencia;
	//
	//		Header h = new Header();
	//		h.LotedeServico.setValue((long)sequencia);
	//		h.TipodaOperacao.setValue("C");
	//		h.TipodeServico.setValue((long)20);
	//		h.FormadeLancamento.setValue(boleto.getBanco().getCodigo().equals("033") ? 30 : 31);
	//		h.NumerodaVersaodoLote.setValue((long)31);
	//		h.NomedaEmpresa.setValue("Banco Digital Maré");
	//		r.setHeader(h);
	//		
	//		r.setSegmentoJ(boleto);
	//		
	//		r.fecharLote();
	//		
	//
	//		return r;
	//	}
	//	
	//
	//	private void setSegmentoJ(Boleto boleto){
	//		SegmentoJ a = new SegmentoJ();
	//		a.LotedeServico.setValue(sequencia);
	//		a.TipodeMovimento.setValue(0);
	//		a.CodigodeInstrucaoparaMovimento.setValue(0);
	//		a.CodigodeBarras.setValue(boleto.getCodigoDeBarras());
	//		a.NomedoCedente.setValue("Não identificado");//TODO arrumar nome cedente
	//		a.DatadoVencimento.setValue(boleto.getVencimento());
	//		a.ValorNominaldoTitulo.setValue(boleto.getValor());
	//		a.DatadoPagamento.setValue(boleto.getPagamento());
	//		a.ValordoPagamento.setValue(boleto.getValorPago());
	//		a.NumerodoDocumentoCliente.setValue("1");//TODO arrumar este campo
	//		a.NumerodoDocumentoBanco.setValue(boleto.getTipo() == Boleto.Tipo.COMUM ? 
	//				boleto.getNossoNumero() : boleto.getIdentProduto());
	//		a.OcorrenciasparaoRetorno.setValue("BRANCOS");
	//		a.DatadoPagamento.setValue(boleto.getPagamento());
	//		
	//		setSegmentoJ(a);
	//	}
	//	
	//
	//
	//	private void fecharLote() throws Exception{
	//
	//		Trailer t = new Trailer();
	//		t.LotedeServico.setValue(sequencia);
	//		t.QuantidadedeRegistrosdoLote.setValue(contadorRegistros());
	//		try{
	//			t.SomatoriadosValores.setValue(getSegmentoJ().ValordoPagamento.getValue());
	//		}catch(Exception e){
	//			e.printStackTrace();
	//			throw new Exception("Erro ao fechar lote: Segmento J inválido");
	//		}
	//		setTrailer(t);
	//
	//	}

	@Override
	public void fromLines(List<String> linhas) throws Exception {

		for(String line : linhas){
			TipoRegistro tipoLinha = TipoRegistro.getByValue(Integer.parseInt(line.substring(7,8)));
			switch (tipoLinha) {
			case HEADER:{
				header.fromLinha(line);
				break;
			}
			case SEGMENTO:{
				TipoSegmento tipoSegmento = TipoSegmento.getByValue(line.substring(13,14));

				switch (tipoSegmento) {
				case J:{
					segmentoJ.fromLinha(line);
					segmentoJ.setInclude(true);
					break;
				}
				case J52:{
					segmentoJ52.fromLinha(line);
					segmentoJ52.setInclude(true);
					break;
				}
				case B:{
					segmentoB.fromLinha(line);
					segmentoB.setInclude(true);
					break;
				}
				case Z:{
					segmentoZ.fromLinha(line);
					segmentoZ.setInclude(true);
					break;
				}
				default: break;

				}
				break;
			}
			case TRAILER:{
				trailer.fromLinha(line);
				break;
			}
			default: break;
			}
		}
	}
}
