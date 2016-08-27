package br.com.pw.antares.febraban.segmentos;

import br.com.pw.antares.fields.IntField;
import br.com.pw.antares.fields.StringField;
import br.com.pw.antares.baseclasses.AntaresLine;
import br.com.pw.antares.baseclasses.AntaresLineBatch;
import br.com.pw.antares.fields.DateField;

public class HeaderArquivo extends AntaresLine{
	public HeaderArquivo(){
		this(true, null);
	}
	
	public HeaderArquivo(boolean include, AntaresLineBatch batch) {
		super(240, 0, "Header de arquivo", include, batch);
	}
	
	public IntField CodigodoBanco = new IntField (" Código do Banco ", true, 1 , 3 , 33l, this);
	public IntField LotedeServico = new IntField (" Lote de Serviço ", false, 4 , 7 );
	public IntField TipodeRegistro = new IntField (" Tipo de Registro ", false, 8 , 8, 0l );
	public StringField Filler1 = new StringField (" Filler ", false, 9 , 17 , this);
	public IntField TipodeInscricaodaEmpresa = new IntField (" Tipo de Inscrição da Empresa ", true, 18 , 18, 2l , this);
	public IntField NumeroInscricaodaEmpresa = new IntField (" Número Inscrição da Empresa ", true, 19 , 32, 11274077000176l , this);
	public StringField CodigodoConvenionoBanco = new StringField (" Código do Convenio no Banco ", true, 33 , 52 , "00333044004902599853", this);
	public IntField AgenciaMantenedoradaConta = new IntField (" Agência Mantenedora da Conta ", true, 53 , 57, 3044l , this);
	public StringField DigitoVerificadordaAgencia = new StringField (" Dígito Verificador da Agência ", false, 58 , 58);
	public IntField NumerodaContaCorrente = new IntField (" Número da Conta Corrente ", true, 59 , 70, 13003935l , this);
	public StringField DigitoVerificadordaConta = new StringField (" Dígito Verificador da Conta ", true, 71 , 71 ,"7", this);
	public StringField DigitoVerificadordaAgenciaConta = new StringField (" Dígito Verificador da Agência / Conta ", false, 72 , 72 , this);
	public StringField NomedaEmpresa = new StringField (" Nome da Empresa ", true, 73 , 102 , this);
	public StringField NomedoBanco = new StringField (" Nome do Banco ", true, 103 , 132 , "Banco Santander ", this);
	public StringField Filler2 = new StringField (" Filler ", false, 133 , 142 , this);
	public IntField CodigoRemessaRetorno = new IntField (" Código Remessa / Retorno ", true, 143 , 143, 1l , this);
	public DateField DatadaGeracaodoArquivo = new DateField (" Data da Geração do Arquivo ", true, 144 , 151 , "ddMMyyyy" , this);
	public DateField HoradaGeracaodoArquivo = new DateField (" Hora da Geração do Arquivo ", true, 152 , 157 , "HHmmss" , this);
	public IntField NumeroSequencialdoArquivo = new IntField (" Número Sequencial do Arquivo ", true, 158 , 163 , this);
	public IntField NumerodaVersaodoLayout = new IntField (" Número da Versão do Layout ", false, 164 , 166 );
	public IntField DensidadedeGravacaoArquivo = new IntField (" Densidade de Gravação Arquivo ", false, 167 , 171 , this);
	public StringField UsoReservadodoBanco = new StringField (" Uso Reservado do Banco ", false, 172 , 191 , this);
	public StringField UsoReservadodaEmpresa = new StringField (" Uso Reservado da Empresa ", false, 192 , 211 );
	public StringField Filler3 = new StringField (" Filler ", false, 212 , 230 , this);
	public StringField OcorrenciasparaoRetorno = new StringField (" Ocorrências para o Retorno ", false, 231 , 240 );
}
