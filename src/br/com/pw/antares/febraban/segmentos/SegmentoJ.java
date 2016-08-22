package br.com.pw.antares.febraban.segmentos;

import java.util.ArrayList;
import java.util.List;

import br.com.pw.antares.febraban.interfaces.FebrabanSegmento;
import br.com.pw.antares.fields.DoubleField;
import br.com.pw.antares.fields.IntField;
import br.com.pw.antares.fields.StringField;
import br.com.santander.fields.DateField;
import br.com.santander.interfaces.AntaresField;

public class SegmentoJ implements FebrabanSegmento<SegmentoJ>{
	public IntField CodigodoBanco = new IntField (" Código do Banco ", true, 1 , 3 , 33); 
	public IntField LotedeServico = new IntField (" Lote de Serviço ", true, 4 , 7 ); 
	public IntField TipodeRegistro = new IntField (" Tipo de Registro ", true, 8 , 8 ,3 );
	public IntField NumeroSequencialdoRegistronoLote = new IntField (" Número Sequencial do Registro no Lote ", false, 9 , 13 ); 
	public StringField CodigoSegmentodoRegistroDetalhe = new StringField (" Código Segmento do Registro Detalhe ", true, 14 , 14 ,"J" ); 
	public IntField TipodeMovimento = new IntField (" Tipo de Movimento ", false, 15 , 15 );
	public IntField CodigodeInstrucaoparaMovimento = new IntField (" Código de Instrução para Movimento ", false, 16 , 17 ); 
	public StringField CodigodeBarras = new StringField (" Código de Barras ", true, 18 , 61 ); 
	public StringField NomedoCedente = new StringField (" Nome do Cedente ", true, 62 , 91 ); 
	public DateField DatadoVencimento = new DateField (" Data do Vencimento ", true, 92 , 99 , "ddMMyyyy" ); 
	public DoubleField ValorNominaldoTitulo = new DoubleField (" Valor Nominal do Título ", true, 100 , 114 , 2 ); 
	public DoubleField ValorDescontoAbatimento = new DoubleField (" Valor Desconto + Abatimento ", false, 115 , 129 , 2 ); 
	public DoubleField ValorMultaJuros = new DoubleField (" Valor Multa + Juros ", false, 130 , 144 , 2 );
	public DateField DatadoPagamento = new DateField (" Data do Pagamento ", true, 145 , 152 , "ddMMyyyy" ); 
	public DoubleField ValordoPagamento = new DoubleField (" Valor do Pagamento ", true, 153 , 167 , 2 ); 
	public DoubleField QuantidadedeMoeda = new DoubleField (" Quantidade de Moeda ", false, 168 , 182 , 5 ); 
	public StringField NumerodoDocumentoCliente = new StringField (" Número do Documento Cliente ", true, 183 , 202 ); 
	public StringField NumerodoDocumentoBanco = new StringField (" Número do Documento Banco ", true, 203 , 222 );
	public IntField CodigodaMoeda = new IntField (" Código da Moeda ", false, 223 , 224 ); 
	public StringField Filler = new StringField (" Filler ", false, 225 , 230 ); 
	public StringField OcorrenciasparaoRetorno = new StringField (" Ocorrências para o Retorno ", true, 231 , 240 );

	List<AntaresField> fields = new ArrayList<>();

	public SegmentoJ(){
		fields.add(	CodigodoBanco	);	
		fields.add(	LotedeServico	);	
		fields.add(	TipodeRegistro	);	
		fields.add(	NumeroSequencialdoRegistronoLote	);	
		fields.add(	CodigoSegmentodoRegistroDetalhe	);	
		fields.add(	TipodeMovimento	);	
		fields.add(	CodigodeInstrucaoparaMovimento	);	
		fields.add(	CodigodeBarras	);	
		fields.add(	NomedoCedente	);	
		fields.add(	DatadoVencimento	);	
		fields.add(	ValorNominaldoTitulo	);	
		fields.add(	ValorDescontoAbatimento	);	
		fields.add(	ValorMultaJuros	);	
		fields.add(	DatadoPagamento	);	
		fields.add(	ValordoPagamento	);	
		fields.add(	QuantidadedeMoeda	);	
		fields.add(	NumerodoDocumentoCliente	);	
		fields.add(	NumerodoDocumentoBanco	);	
		fields.add(	CodigodaMoeda	);	
		fields.add(	Filler	);	
		fields.add(	OcorrenciasparaoRetorno	);	
	}

	@Override
	public String getAsLine() throws Exception {
		String linha = "";
		for(AntaresField f : fields){
			linha+= f.getValueAsLine();
		}
		return linha;
	}
	
	@Override
	public SegmentoJ setFromLine(String line) throws Exception {
		try{
			for(AntaresField f : fields){
				f.setValueFromLine(line);
			}
		}catch(Exception e){
			throw new Exception("Lote: "+LotedeServico.getValue()+" - Header Lote - "+e.getMessage());
		}
		return this;
	}

	@Override
	public String toString() {
		return "SegmentoJ [CodigodoBanco=" + CodigodoBanco + ", LotedeServico=" + LotedeServico + ", TipodeRegistro="
				+ TipodeRegistro + ", NumeroSequencialdoRegistronoLote=" + NumeroSequencialdoRegistronoLote
				+ ", CodigoSegmentodoRegistroDetalhe=" + CodigoSegmentodoRegistroDetalhe + ", TipodeMovimento="
				+ TipodeMovimento + ", CodigodeInstrucaoparaMovimento=" + CodigodeInstrucaoparaMovimento
				+ ", CodigodeBarras=" + CodigodeBarras + ", NomedoCedente=" + NomedoCedente + ", DatadoVencimento="
				+ DatadoVencimento + ", ValorNominaldoTitulo=" + ValorNominaldoTitulo + ", ValorDescontoAbatimento="
				+ ValorDescontoAbatimento + ", ValorMultaJuros=" + ValorMultaJuros + ", DatadoPagamento="
				+ DatadoPagamento + ", ValordoPagamento=" + ValordoPagamento + ", QuantidadedeMoeda="
				+ QuantidadedeMoeda + ", NumerodoDocumentoCliente=" + NumerodoDocumentoCliente
				+ ", NumerodoDocumentoBanco=" + NumerodoDocumentoBanco + ", CodigodaMoeda=" + CodigodaMoeda
				+ ", Filler=" + Filler + ", OcorrenciasparaoRetorno=" + OcorrenciasparaoRetorno + "]";
	}
	
	
}
