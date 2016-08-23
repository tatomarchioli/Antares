package br.com.santander.lotes;

import java.util.ArrayList;
import java.util.List;

import br.com.mare.model.Boleto;
import br.com.pw.antares.febraban.interfaces.FebrabanSegmento;
import br.com.pw.antares.febraban.segmentos.Header;
import br.com.pw.antares.febraban.segmentos.SegmentoB;
import br.com.pw.antares.febraban.segmentos.SegmentoJ;
import br.com.pw.antares.febraban.segmentos.SegmentoJ52;
import br.com.pw.antares.febraban.segmentos.SegmentoZ;
import br.com.pw.antares.febraban.segmentos.Trailer;
import br.com.pw.antares.interfaces.FebrabanLote;

public class TitulosBancarios implements FebrabanLote<TitulosBancarios>{
	private Header header;
	private SegmentoJ segmentoJ;
	private SegmentoJ52 segmentoJ52;
	private SegmentoB segmentoB;
	private SegmentoZ segmentoZ;
	private Trailer trailer;
	private int sequencia;

	public static TitulosBancarios criarLote(Boleto boleto, int sequencia) throws Exception{
		TitulosBancarios r = new TitulosBancarios();
		r.sequencia = sequencia;

		Header h = new Header();
		h.LotedeServico.setValue(sequencia);
		h.TipodaOperacao.setValue("C");
		h.TipodeServico.setValue(20);
		h.FormadeLancamento.setValue(boleto.getBanco().getCodigo().equals("033") ? 30 : 31);
		h.NumerodaVersaodoLote.setValue(31);
		h.NomedaEmpresa.setValue("Banco Digital Maré");
		r.setHeader(h);
		
		r.setSegmentoJ(boleto);
		
		r.fecharLote();
		

		return r;
	}
	

	private void setSegmentoJ(Boleto boleto){
		SegmentoJ a = new SegmentoJ();
		a.LotedeServico.setValue(sequencia);
		a.TipodeMovimento.setValue(0);
		a.CodigodeInstrucaoparaMovimento.setValue(0);
		a.CodigodeBarras.setValue(boleto.getCodigoDeBarras());
		a.NomedoCedente.setValue("Não identificado");//TODO arrumar nome cedente
		a.DatadoVencimento.setValue(boleto.getVencimento());
		a.ValorNominaldoTitulo.setValue(boleto.getValor());
		a.DatadoPagamento.setValue(boleto.getPagamento());
		a.ValordoPagamento.setValue(boleto.getValorPago());
		a.NumerodoDocumentoCliente.setValue("1");//TODO arrumar este campo
		a.NumerodoDocumentoBanco.setValue(boleto.getTipo() == Boleto.Tipo.COMUM ? 
				boleto.getNossoNumero() : boleto.getIdentProduto());
		a.OcorrenciasparaoRetorno.setValue("BRANCOS");
		a.DatadoPagamento.setValue(boleto.getPagamento());
		
		setSegmentoJ(a);
	}
	


	private void fecharLote() throws Exception{

		Trailer t = new Trailer();
		t.LotedeServico.setValue(sequencia);
		t.QuantidadedeRegistrosdoLote.setValue(contadorRegistros());
		try{
			t.SomatoriadosValores.setValue(getSegmentoJ().ValordoPagamento.getValue());
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("Erro ao fechar lote: Segmento J inválido");
		}
		setTrailer(t);

	}

	@Override
	public boolean validate() throws Exception {
		return getLinhas().size() > 0;
	}

	@Override
	public int contadorRegistros() {
		int c = 3;
		if(segmentoJ52 != null)c++;
		if(segmentoB != null) c++;
		return c;
	}

	@Override
	public List<String> getLinhas() throws Exception{
		List<String> list = new ArrayList<>();
		list.add(header.toLinha());
		if(segmentoJ != null)list.add(segmentoJ.toLinha());
		if(segmentoJ52 != null)list.add(segmentoJ52.toLinha());
		if(segmentoB != null)list.add(segmentoB.toLinha());
		//		list.add(segmentoZ.getLinha());
		list.add(trailer.toLinha());
		return list;
	}
	
	@SuppressWarnings("incomplete-switch")
	@Override
	public TitulosBancarios setLinhas(List<String> linhas) throws Exception {
		
		header = new Header().fromLinha(linhas.get(0));
		trailer = new Trailer().fromLinha(linhas.get(linhas.size()-1));
		linhas.remove(0);
		linhas.remove(linhas.size()-1);
		
		for(String linha : linhas){
			FebrabanSegmento.TipoSegmento tipoSegmento = 
					FebrabanSegmento.TipoSegmento.getByValue(linha.substring(13,14));
			switch (tipoSegmento) {
			case J:
				segmentoJ = new SegmentoJ().fromLinha(linha);
				break;
			case J52:
				segmentoJ52 = new SegmentoJ52().fromLinha(linha);
				break;
			case B:
				segmentoB = new SegmentoB().fromLinha(linha);
				break;
			case Z:
				segmentoZ = new SegmentoZ().fromLinha(linha);
				break;
			}
		}
		return this;
	}


	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public SegmentoJ getSegmentoJ() {
		return segmentoJ;
	}

	public void setSegmentoJ(SegmentoJ segmentoJ) {
		this.segmentoJ = segmentoJ;
	}

	public SegmentoJ52 getSegmentoJ52() {
		return segmentoJ52;
	}

	public void setSegmentoJ52(SegmentoJ52 segmentoJ52) {
		this.segmentoJ52 = segmentoJ52;
	}

	public SegmentoB getSegmentoB() {
		return segmentoB;
	}

	public void setSegmentoB(SegmentoB segmentoB) {
		this.segmentoB = segmentoB;
	}

	public SegmentoZ getSegmentoZ() {
		return segmentoZ;
	}

	public void setSegmentoZ(SegmentoZ segmentoZ) {
		this.segmentoZ = segmentoZ;
	}

	public Trailer getTrailer() {
		return trailer;
	}

	public void setTrailer(Trailer trailer) {
		this.trailer = trailer;
	}


	@Override
	public String toString() {
		return "TitulosBancarios [header=" + header + ", segmentoJ=" + segmentoJ + ", segmentoJ52=" + segmentoJ52
				+ ", segmentoB=" + segmentoB + ", segmentoZ=" + segmentoZ + ", trailer=" + trailer + ", sequencia="
				+ sequencia + "]";
	}

	
	
}
