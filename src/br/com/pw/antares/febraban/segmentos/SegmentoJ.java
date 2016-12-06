package br.com.pw.antares.febraban.segmentos;

import br.com.pw.antares.fields.DoubleField;
import br.com.pw.antares.fields.IntField;
import br.com.pw.antares.fields.StringField;
import br.com.pw.antares.baseclasses.AntaresLine;
import br.com.pw.antares.baseclasses.AntaresLineBatch;
import br.com.pw.antares.fields.DateField;

public class SegmentoJ extends AntaresLine{
	public SegmentoJ(){
		this(true, null);
	}
	
	public SegmentoJ(boolean include, AntaresLineBatch batch) {
		super(240, 3, "Segmento J", include, batch);
	}
	
	public IntField CodigodoBanco = new IntField (" Código do Banco ", true, 1 , 3 , 33l, this); 
	public IntField LotedeServico = new IntField (" Lote de Serviço ", true, 4 , 7 , this); 
	public IntField TipodeRegistro = new IntField (" Tipo de Registro ", true, 8 , 8 ,3l , this);
	public IntField NumeroSequencialdoRegistronoLote = new IntField (" Número Sequencial do Registro no Lote ", false, 9 , 13 , this); 
	public StringField CodigoSegmentodoRegistroDetalhe = new StringField (" Código Segmento do Registro Detalhe ", true, 14 , 14 ,"J" , this); 
	public IntField TipodeMovimento = new IntField (" Tipo de Movimento ", false, 15 , 15 , this);
	public IntField CodigodeInstrucaoparaMovimento = new IntField (" Código de Instrução para Movimento ", false, 16 , 17 , this); 
	public StringField CodigodeBarras = new StringField (" Código de Barras ", true, 18 , 61 , this); 
	public StringField NomedoCedente = new StringField (" Nome do Cedente ", true, 62 , 91 , this); 
	public DateField DatadoVencimento = new DateField (" Data do Vencimento ", true, 92 , 99 , "ddMMyyyy" , this); 
	public DoubleField ValorNominaldoTitulo = new DoubleField (" Valor Nominal do Título ", true, 100 , 114 , 2 , this); 
	public DoubleField ValorDescontoAbatimento = new DoubleField (" Valor Desconto + Abatimento ", false, 115 , 129 , 2 , this); 
	public DoubleField ValorMultaJuros = new DoubleField (" Valor Multa + Juros ", false, 130 , 144 , 2 , this);
	public DateField DatadoPagamento = new DateField (" Data do Pagamento ", true, 145 , 152 , "ddMMyyyy" , this); 
	public DoubleField ValordoPagamento = new DoubleField (" Valor do Pagamento ", true, 153 , 167 , 2 , this); 
	public DoubleField QuantidadedeMoeda = new DoubleField (" Quantidade de Moeda ", false, 168 , 182 , 5 , this); 
	public StringField NumerodoDocumentoCliente = new StringField (" Número do Documento Cliente ", true, 183 , 202 , this); 
	public StringField NumerodoDocumentoBanco = new StringField (" Número do Documento Banco ", true, 203 , 222 , this);
	public IntField CodigodaMoeda = new IntField (" Código da Moeda ", false, 223 , 224 , this); 
	public StringField Filler = new StringField (" Filler ", false, 225 , 230 , this); 
	public StringField OcorrenciasparaoRetorno = new StringField (" Ocorrências para o Retorno ", true, 231 , 240 , this);
	
	@Override
	public boolean canUnmarshal(String line) {
		
		return false;
	}
	
}
