package br.com.pw.antares.febraban.segmentos;

import br.com.pw.antares.fields.DoubleField;
import br.com.pw.antares.fields.IntField;
import br.com.pw.antares.fields.StringField;
import br.com.pw.antares.baseclasses.AntaresLine;
import br.com.pw.antares.baseclasses.AntaresLineBatch;
import br.com.pw.antares.fields.DateField;

public class SegmentoA extends AntaresLine{
	public SegmentoA(){
		this(true, null);
	}
	
	public SegmentoA(boolean include, AntaresLineBatch batch) {
		super(240, 3, "Segmento A", include, batch);
	}
	
	public IntField CodigodoBanco = new IntField (" Código do Banco ", true, 1 , 3 , 33l, this);
	public IntField LotedeServico = new IntField (" Lote de Serviço ", true, 4 , 7 , this);
	public IntField TipodeRegistro = new IntField (" Tipo de Registro ", true, 8 , 8 , 3l , this);
	public IntField NumeroSequencialdoRegistronoLote = new IntField (" Número Sequencial do Registro no Lote ", false, 9 , 13   , this);
	public StringField CodigoSegmentodoRegistroDetalhe = new StringField (" Código Segmento do Registro Detalhe ", true, 14 , 14, "A" , this);
	public IntField TipodeMovimento = new IntField (" Tipo de Movimento ", false, 15 , 15   , this);
	public IntField CodigodaInstrucaoparaMovimento = new IntField (" Código da Instrução para Movimento ", false, 16 , 17 , this); 
	public IntField CodigoCamaraCompensacao = new IntField (" Código Câmara Compensação ", false, 18 , 20 , this); 
	public IntField CodigodoBancoFavorecido = new IntField (" Código do Banco Favorecido ", true, 21 , 23 , this); 
	public IntField CodigodaAgenciaFavorecido = new IntField (" Código da Agência Favorecido ", true, 24 , 28 , this);
	public StringField DigitoVerificadordaAgencia = new StringField (" Dígito Verificador da Agência ", false, 29 , 29 , this);
	public IntField ContaCorrentedoFavorecido = new IntField (" Conta Corrente do Favorecido ", true, 30 , 41 , this);
	public StringField DigitoVerificadordaConta = new StringField (" Dígito Verificador da Conta ", false, 42 , 42 , this); 
	public StringField DigitoVerificadordaAgenciaConta = new StringField (" Dígito Verificador da Agência/Conta ", false, 43 , 43 , this); 
	public StringField NomedoFavorecido = new StringField (" Nome do Favorecido ", true, 44 , 73 , this);
	public StringField NrodoDocumentoCliente = new StringField (" Nro. do Documento Cliente ", true, 74 , 93 , this);
	public DateField DatadoPagamento = new DateField (" Data do Pagamento ", true, 94 , 101 , "ddMMyyyy" , this); 
	public StringField TipodaMoeda = new StringField (" Tipo da Moeda ", true, 102 , 104, "BRL" , this); 
	public DoubleField QuantidadedeMoeda = new DoubleField (" Quantidade de Moeda ", false, 105 , 119 , 5 , this); 
	public DoubleField ValordoPagamento = new DoubleField (" Valor do Pagamento ", false, 120 , 134 , 2 , this); 
	public StringField NrodoDocumentoBanco = new StringField (" Nro. do Documento Banco ", false, 135 , 154 , this); 
	public DateField DataRealdoPagamentoRetorno = new DateField (" Data Real do Pagamento (Retorno) ", false, 155 , 162 , "ddMMyyyy" , this); 
	public DoubleField ValorRealdoPagamento = new DoubleField (" Valor Real do Pagamento ", false, 163 , 177 , 2 , this);
	public StringField Informacao2Mensagem = new StringField (" Informação 2 - Mensagem ", false, 178 , 217 , this); 
	public StringField FinalidadedoDOC = new StringField (" Finalidade do DOC ", true, 218 , 219 , this); 
	public StringField FinalidadedeTED = new StringField (" Finalidade de TED ", false, 220 , 224 , this); 
	public StringField CodigoFinalidadeComplementar = new StringField (" Código Finalidade Complementar ", false, 225 , 226 , this); 
	public StringField Filler = new StringField (" Filler ", false, 227 , 229 , this);
	public StringField EmissaodeAvisoaoFavorecido = new StringField (" Emissão de Aviso ao Favorecido ", false, 230 , 230 , this); 
	public StringField OcorrenciasparaoRetorno = new StringField (" Ocorrências para o Retorno ", false, 231 , 240 , this);
}
