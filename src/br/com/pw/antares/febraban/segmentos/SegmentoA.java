package br.com.pw.antares.febraban.segmentos;

import java.util.ArrayList;
import java.util.List;

import br.com.pw.antares.febraban.interfaces.FebrabanSegmento;
import br.com.pw.antares.fields.DoubleField;
import br.com.pw.antares.fields.IntField;
import br.com.pw.antares.fields.StringField;
import br.com.santander.fields.DateField;
import br.com.santander.interfaces.AntaresField;

public class SegmentoA implements FebrabanSegmento<SegmentoA>{
	public IntField CodigodoBanco = new IntField (" Código do Banco ", true, 1 , 3 , 33);
	public IntField LotedeServico = new IntField (" Lote de Serviço ", true, 4 , 7 );
	public IntField TipodeRegistro = new IntField (" Tipo de Registro ", true, 8 , 8 , 3 );
	public IntField NumeroSequencialdoRegistronoLote = new IntField (" Número Sequencial do Registro no Lote ", false, 9 , 13   );
	public StringField CodigoSegmentodoRegistroDetalhe = new StringField (" Código Segmento do Registro Detalhe ", true, 14 , 14, "A" );
	public IntField TipodeMovimento = new IntField (" Tipo de Movimento ", false, 15 , 15   );
	public IntField CodigodaInstrucaoparaMovimento = new IntField (" Código da Instrução para Movimento ", false, 16 , 17 ); 
	public IntField CodigoCamaraCompensacao = new IntField (" Código Câmara Compensação ", false, 18 , 20 ); 
	public IntField CodigodoBancoFavorecido = new IntField (" Código do Banco Favorecido ", true, 21 , 23 ); 
	public IntField CodigodaAgenciaFavorecido = new IntField (" Código da Agência Favorecido ", true, 24 , 28 );
	public StringField DigitoVerificadordaAgencia = new StringField (" Dígito Verificador da Agência ", false, 29 , 29 );
	public IntField ContaCorrentedoFavorecido = new IntField (" Conta Corrente do Favorecido ", true, 30 , 41 );
	public StringField DigitoVerificadordaConta = new StringField (" Dígito Verificador da Conta ", false, 42 , 42 ); 
	public StringField DigitoVerificadordaAgenciaConta = new StringField (" Dígito Verificador da Agência/Conta ", false, 43 , 43 ); 
	public StringField NomedoFavorecido = new StringField (" Nome do Favorecido ", true, 44 , 73 );
	public StringField NrodoDocumentoCliente = new StringField (" Nro. do Documento Cliente ", true, 74 , 93 );
	public DateField DatadoPagamento = new DateField (" Data do Pagamento ", true, 94 , 101 , "ddMMyyyy" ); 
	public StringField TipodaMoeda = new StringField (" Tipo da Moeda ", true, 102 , 104, "BRL" ); 
	public DoubleField QuantidadedeMoeda = new DoubleField (" Quantidade de Moeda ", false, 105 , 119 , 5 ); 
	public DoubleField ValordoPagamento = new DoubleField (" Valor do Pagamento ", false, 120 , 134 , 2 ); 
	public StringField NrodoDocumentoBanco = new StringField (" Nro. do Documento Banco ", false, 135 , 154 ); 
	public DateField DataRealdoPagamentoRetorno = new DateField (" Data Real do Pagamento (Retorno) ", false, 155 , 162 , "ddMMyyyy" ); 
	public DoubleField ValorRealdoPagamento = new DoubleField (" Valor Real do Pagamento ", false, 163 , 177 , 2 );
	public StringField Informacao2Mensagem = new StringField (" Informação 2 - Mensagem ", false, 178 , 217 ); 
	public StringField FinalidadedoDOC = new StringField (" Finalidade do DOC ", true, 218 , 219 ); 
	public StringField FinalidadedeTED = new StringField (" Finalidade de TED ", false, 220 , 224 ); 
	public StringField CodigoFinalidadeComplementar = new StringField (" Código Finalidade Complementar ", false, 225 , 226 ); 
	public StringField Filler = new StringField (" Filler ", false, 227 , 229 );
	public StringField EmissaodeAvisoaoFavorecido = new StringField (" Emissão de Aviso ao Favorecido ", false, 230 , 230 ); 
	public StringField OcorrenciasparaoRetorno = new StringField (" Ocorrências para o Retorno ", false, 231 , 240 );

	List<AntaresField> fields = new ArrayList<>();
	
	public SegmentoA(){
		fields.add(CodigodoBanco	);
		fields.add(LotedeServico	);
		fields.add(TipodeRegistro	);
		fields.add(NumeroSequencialdoRegistronoLote	);
		fields.add(CodigoSegmentodoRegistroDetalhe	);
		fields.add(TipodeMovimento	);
		fields.add(CodigodaInstrucaoparaMovimento	);
		fields.add(CodigoCamaraCompensacao	);
		fields.add(CodigodoBancoFavorecido	);
		fields.add(CodigodaAgenciaFavorecido	);
		fields.add(DigitoVerificadordaAgencia	);
		fields.add(ContaCorrentedoFavorecido	);
		fields.add(DigitoVerificadordaConta	);
		fields.add(DigitoVerificadordaAgenciaConta	);
		fields.add(NomedoFavorecido	);
		fields.add(NrodoDocumentoCliente	);
		fields.add(DatadoPagamento	);
		fields.add(TipodaMoeda	);
		fields.add(QuantidadedeMoeda	);
		fields.add(ValordoPagamento	);
		fields.add(NrodoDocumentoBanco	);
		fields.add(DataRealdoPagamentoRetorno	);
		fields.add(ValorRealdoPagamento	);
		fields.add(Informacao2Mensagem	);
		fields.add(FinalidadedoDOC	);
		fields.add(FinalidadedeTED	);
		fields.add(CodigoFinalidadeComplementar	);
		fields.add(Filler	);
		fields.add(EmissaodeAvisoaoFavorecido	);
		fields.add(OcorrenciasparaoRetorno	);
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
			throw new Exception("Lote: "+LotedeServico.getValue()+" - Segmento A - "+e.getMessage());
		}
	}

	@Override
	public SegmentoA setFromLine(String line) throws Exception {
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
