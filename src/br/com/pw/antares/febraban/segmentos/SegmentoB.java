package br.com.pw.antares.febraban.segmentos;

import java.util.ArrayList;
import java.util.List;

import br.com.pw.antares.febraban.interfaces.FebrabanSegmento;
import br.com.pw.antares.fields.DoubleField;
import br.com.pw.antares.fields.IntField;
import br.com.pw.antares.fields.StringField;
import br.com.santander.fields.DateField;
import br.com.santander.interfaces.AntaresField;

public class SegmentoB implements FebrabanSegmento<SegmentoB>{
	public IntField CodigodoBanco = new IntField (" Código do Banco ", true, 1 , 3 , 33); 
	public IntField LotedeServico = new IntField (" Lote de Serviço ", true, 4 , 7 );
	public IntField TipodeRegistro = new IntField (" Tipo de Registro ", true, 8 , 8 ,3 );
	public IntField NumeroSequencialdoRegistronoLote = new IntField (" Número Sequencial do Registro no Lote ", false, 9 , 13 );
	public StringField CodigoSegmentodoRegistroDetalhe = new StringField (" Código Segmento do Registro Detalhe ", true, 14 , 14 , "B" ); 
	public StringField Filler1 = new StringField (" Filler ", false, 15 , 17 ); 
	public IntField TipodeInscricaodoFavorecido = new IntField (" Tipo de Inscrição do Favorecido ", false, 18 , 18 );
	public IntField CNPJCPFdoFavorecido = new IntField (" CNPJ/CPF do Favorecido ", false, 19 , 32 );
	public StringField LogradourodoFavorecido = new StringField (" Logradouro do Favorecido ", false, 33 , 62 );
	public IntField NumerodoLocaldoFavorecido = new IntField (" Número do Local do Favorecido ", false, 63 , 67 );
	public StringField ComplementodoLocalFavorecido = new StringField (" Complemento do Local Favorecido ", false, 68 , 82 ); 
	public StringField BairrodoFavorecido = new StringField (" Bairro do Favorecido ", false, 83 , 97 ); 
	public StringField CidadedoFavorecido = new StringField (" Cidade do Favorecido ", false, 98 , 117 ); 
	public IntField CEPdoFavorecido = new IntField (" CEP do Favorecido ", false, 118 , 125 ); 
	public StringField EstadodoFavorecido = new StringField (" Estado do Favorecido ", false, 126 , 127 ); 
	public DateField DatadeVencimento = new DateField (" Data de Vencimento ", false, 128 , 135 , "ddMMyyyy" ); 
	public DoubleField ValordoDocumento = new DoubleField (" Valor do Documento ", false, 136 , 150 , 2 ); 
	public DoubleField ValordoAbatimento = new DoubleField (" Valor do Abatimento ", false, 151 , 165 , 2 ); 
	public DoubleField ValordoDesconto = new DoubleField (" Valor do Desconto ", false, 166 , 180 , 2 ); 
	public DoubleField ValordaMora = new DoubleField (" Valor da Mora ", false, 181 , 195 , 2 ); 
	public DoubleField ValordaMulta = new DoubleField (" Valor da Multa ", false, 196 , 210 , 2 ); 
	public IntField HorariodeEnviodeTED = new IntField (" Horório de Envio de TED ", false, 211 , 214 ); 
	public StringField Filler2 = new StringField (" Filler ", false, 215 , 225 ); 
	public IntField CodigoHistoricoparaCredito = new IntField (" Código Histórico para Crédito ", false, 226 , 229 );
	public IntField EmissaodeAvisoaoFavorecido = new IntField (" Emissão de Aviso ao Favorecido ", false, 230 , 230 ); 
	public StringField Filler3 = new StringField (" Filler ", false, 231 , 231 ); 
	public StringField TEDparaInstituicaoFinanceira = new StringField (" TED para Instituição Financeira ", false, 232 , 232 ); 
	public StringField IdentificacaodaIFnoSPB = new StringField (" Identificação da IF no SPB ", false, 233 , 240 );

	List<AntaresField> fields = new ArrayList<>();
	
	public SegmentoB(){
		fields.add(	CodigodoBanco	);	
		fields.add(	LotedeServico	);	
		fields.add(	TipodeRegistro	);	
		fields.add(	NumeroSequencialdoRegistronoLote	);	
		fields.add(	CodigoSegmentodoRegistroDetalhe	);	
		fields.add(	Filler1	);	
		fields.add(	TipodeInscricaodoFavorecido	);	
		fields.add(	CNPJCPFdoFavorecido	);	
		fields.add(	LogradourodoFavorecido	);	
		fields.add(	NumerodoLocaldoFavorecido	);	
		fields.add(	ComplementodoLocalFavorecido	);	
		fields.add(	BairrodoFavorecido	);	
		fields.add(	CidadedoFavorecido	);	
		fields.add(	CEPdoFavorecido	);	
		fields.add(	EstadodoFavorecido	);	
		fields.add(	DatadeVencimento	);	
		fields.add(	ValordoDocumento	);	
		fields.add(	ValordoAbatimento	);	
		fields.add(	ValordoDesconto	);	
		fields.add(	ValordaMora	);	
		fields.add(	ValordaMulta	);	
		fields.add(	HorariodeEnviodeTED	);	
		fields.add(	Filler2	);	
		fields.add(	CodigoHistoricoparaCredito	);	
		fields.add(	EmissaodeAvisoaoFavorecido	);	
		fields.add(	Filler3	);	
		fields.add(	TEDparaInstituicaoFinanceira	);	
		fields.add(	IdentificacaodaIFnoSPB	);	
	}
	@Override
	public String getAsLine() throws Exception {
		try{
			String linha = "";
			for(AntaresField f : fields){
				linha+=f.getValueAsLine();
			}
			return linha;
		}catch(Exception e){
			throw new Exception("Lote: "+LotedeServico.getValue()+" - Segmento B - "+e.getMessage());
		}
	}
	
	@Override
	public SegmentoB setFromLine(String line) throws Exception {
		try{
			for(AntaresField f : fields){
				f.setValueFromLine(line);
			}
		}catch(Exception e){
			throw new Exception("Lote: "+LotedeServico.getValue()+" - Header Lote - "+e.getMessage());
		}
		return this;
	}
}