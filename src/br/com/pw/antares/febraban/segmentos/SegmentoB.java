package br.com.pw.antares.febraban.segmentos;

import br.com.pw.antares.fields.DoubleField;
import br.com.pw.antares.fields.IntField;
import br.com.pw.antares.fields.StringField;
import br.com.pw.antares.baseclasses.AntaresLine;
import br.com.pw.antares.baseclasses.AntaresLineBatch;
import br.com.pw.antares.fields.DateField;

public class SegmentoB extends AntaresLine{
	
	public SegmentoB(){
		this(true, null);
	}
	
	public SegmentoB(boolean include, AntaresLineBatch batch) {
		super(240, 3, "Segmento B", include, batch);
	}
	
	public IntField CodigodoBanco = new IntField (" Código do Banco ", true, 1 , 3 , 33l, this); 
	public IntField LotedeServico = new IntField (" Lote de Serviço ", true, 4 , 7 , this);
	public IntField TipodeRegistro = new IntField (" Tipo de Registro ", true, 8 , 8 ,3l , this);
	public IntField NumeroSequencialdoRegistronoLote = new IntField (" Número Sequencial do Registro no Lote ", false, 9 , 13 , this);
	public StringField CodigoSegmentodoRegistroDetalhe = new StringField (" Código Segmento do Registro Detalhe ", true, 14 , 14 , "B" , this); 
	public StringField Filler1 = new StringField (" Filler ", false, 15 , 17 , this); 
	public IntField TipodeInscricaodoFavorecido = new IntField (" Tipo de Inscrição do Favorecido ", false, 18 , 18 , this);
	public IntField CNPJCPFdoFavorecido = new IntField (" CNPJ/CPF do Favorecido ", false, 19 , 32 , this);
	public StringField LogradourodoFavorecido = new StringField (" Logradouro do Favorecido ", false, 33 , 62 , this);
	public IntField NumerodoLocaldoFavorecido = new IntField (" Número do Local do Favorecido ", false, 63 , 67 , this);
	public StringField ComplementodoLocalFavorecido = new StringField (" Complemento do Local Favorecido ", false, 68 , 82 , this); 
	public StringField BairrodoFavorecido = new StringField (" Bairro do Favorecido ", false, 83 , 97 , this); 
	public StringField CidadedoFavorecido = new StringField (" Cidade do Favorecido ", false, 98 , 117 , this); 
	public IntField CEPdoFavorecido = new IntField (" CEP do Favorecido ", false, 118 , 125 , this); 
	public StringField EstadodoFavorecido = new StringField (" Estado do Favorecido ", false, 126 , 127 , this); 
	public DateField DatadeVencimento = new DateField (" Data de Vencimento ", false, 128 , 135 , "ddMMyyyy" , this); 
	public DoubleField ValordoDocumento = new DoubleField (" Valor do Documento ", false, 136 , 150 , 2 , this); 
	public DoubleField ValordoAbatimento = new DoubleField (" Valor do Abatimento ", false, 151 , 165 , 2 , this); 
	public DoubleField ValordoDesconto = new DoubleField (" Valor do Desconto ", false, 166 , 180 , 2 , this); 
	public DoubleField ValordaMora = new DoubleField (" Valor da Mora ", false, 181 , 195 , 2 , this); 
	public DoubleField ValordaMulta = new DoubleField (" Valor da Multa ", false, 196 , 210 , 2 , this); 
	public IntField HorariodeEnviodeTED = new IntField (" Horório de Envio de TED ", false, 211 , 214 , this); 
	public StringField Filler2 = new StringField (" Filler ", false, 215 , 225 , this); 
	public IntField CodigoHistoricoparaCredito = new IntField (" Código Histórico para Crédito ", false, 226 , 229 , this);
	public IntField EmissaodeAvisoaoFavorecido = new IntField (" Emissão de Aviso ao Favorecido ", false, 230 , 230 , this); 
	public StringField Filler3 = new StringField (" Filler ", false, 231 , 231 , this); 
	public StringField TEDparaInstituicaoFinanceira = new StringField (" TED para Instituição Financeira ", false, 232 , 232 , this); 
	public StringField IdentificacaodaIFnoSPB = new StringField (" Identificação da IF no SPB ", false, 233 , 240 , this);
}