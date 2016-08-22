package br.com.santander.lotes;

import java.util.ArrayList;
import java.util.List;

import br.com.pw.antares.febraban.interfaces.FebrabanSegmento;
import br.com.pw.antares.febraban.segmentos.Header;
import br.com.pw.antares.febraban.segmentos.SegmentoA;
import br.com.pw.antares.febraban.segmentos.SegmentoB;
import br.com.pw.antares.febraban.segmentos.SegmentoZ;
import br.com.pw.antares.febraban.segmentos.Trailer;
import br.com.santander.interfaces.FebrabanLote;

public class CreditoEmConta implements FebrabanLote<CreditoEmConta>{
	private Header header;
	private SegmentoA segmentoA;
	private SegmentoB segmentoB;
	private SegmentoZ segmentoZ;
	private Trailer trailer;
	private int sequencia;

	public static CreditoEmConta criarLote(int sequencia){
		CreditoEmConta r = new CreditoEmConta();

		r.sequencia = sequencia;

		Header h = new Header();
		h.LotedeServico.setValue(sequencia);
		h.TipodaOperacao.setValue("C");
		h.TipodeServico.setValue(20);
		h.FormadeLancamento.setValue(1);
		h.NumerodaVersaodoLote.setValue(31);
		h.NomedaEmpresa.setValue("Banco Digital Maré");

		SegmentoB b = new SegmentoB();
		b.LotedeServico.setValue(sequencia);

		r.setSegmentoB(b);

		r.setHeader(h);

		return r;
	}

	public void setSegmentoA(Boleto boleto){
		SegmentoA a = new SegmentoA();
		a.LotedeServico.setValue(sequencia);
		a.CodigodoBancoFavorecido.setValue(Integer.parseInt(boleto.getBanco().getCodigo()));//TODO Arrumar este campo
		a.CodigodaAgenciaFavorecido.setValue(Integer.parseInt(boleto.getAgencia()));//TODO Arrumar este campo
		a.ContaCorrentedoFavorecido.setValue(Integer.parseInt(boleto.getConta()));//TODO Arrumar este campo
		a.NomedoFavorecido.setValue(boleto.getBanco().getNome());//TODO Arrumar este campo
		a.NrodoDocumentoCliente.setValue("111");//TODO Arrumar este campo
		a.DatadoPagamento.setValue(boleto.getPagamento());
		a.FinalidadedoDOC.setValue("07");
		setSegmentoA(a);
	}


	public void fecharLote(){
		Trailer t = new Trailer();
		t.LotedeServico.setValue(sequencia);
		t.QuantidadedeRegistrosdoLote.setValue(contadorRegistros());
		setTrailer(t);
	}

	@Override
	public boolean validate() throws Exception {
		return getLinhas().size() > 0;
	}

	@Override
	public int contadorRegistros() {
		return 4;
	}

	@Override
	public List<String> getLinhas() throws Exception{

		if(header == null){
			throw new Exception("Credito em conta: Header inválido");
		}

		if(segmentoA == null){
			throw new Exception("Credito em conta: Segmento A inválido");
		}

		if(trailer == null){
			throw new Exception("Credito em conta: Trailer inválido");
		}

		List<String> list = new ArrayList<>();
		list.add(header.getAsLine());
		list.add(segmentoA.getAsLine());
		if(segmentoB != null)
			list.add(segmentoB.getAsLine());
		list.add(trailer.getAsLine());
		return list;
	}


	@SuppressWarnings("incomplete-switch")
	@Override
	public CreditoEmConta setLinhas(List<String> linhas) throws Exception {
		header = new Header().setFromLine(linhas.get(0));
		trailer = new Trailer().setFromLine(linhas.get(linhas.size()-1));
		linhas.remove(0);
		linhas.remove(linhas.size()-1);
		
		for(String linha : linhas){
			FebrabanSegmento.TipoSegmento tipoSegmento = 
					FebrabanSegmento.TipoSegmento.getByValue(linha.substring(13,14));
			switch (tipoSegmento) {
			case A:
				segmentoA = new SegmentoA().setFromLine(linha);
				break;
			case B:
				segmentoB = new SegmentoB().setFromLine(linha);
				break;
			case Z:
				segmentoZ = new SegmentoZ().setFromLine(linha);
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

	public SegmentoA getSegmentoA() {
		return segmentoA;
	}

	public void setSegmentoA(SegmentoA segmentoA) {
		this.segmentoA = segmentoA;
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


}
