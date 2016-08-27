package br.com.pw.antares.febraban.segmentos;

import br.com.pw.antares.baseclasses.AntaresLine;
import br.com.pw.antares.baseclasses.AntaresLineBatch;
import br.com.pw.antares.fields.IntField;
import br.com.pw.antares.fields.StringField;

public class Header extends AntaresLine{
	
	public Header(){
		this(true, null);
	}
	
	public Header(boolean include, AntaresLineBatch batch) {
		super(240, 1, "Header", include, batch);
	}
	
	public IntField CodigodoBanco = new IntField ("Código do Banco", true, 1 , 3 , 33l, this); 
	public IntField LotedeServico = new IntField ("Lote de Serviço", true, 4 , 7 , this); 
	public IntField TipodeRegistro = new IntField ("Tipo de Registro", true, 8 , 8 , 1l , this);
	public StringField TipodaOperacao = new StringField ("Tipo da Operação", true, 9 , 9 , this); 
	public IntField TipodeServico = new IntField ("Tipo de Serviço", true, 10 , 11 , this); 
	public IntField FormadeLancamento = new IntField ("Forma de Lançamento", true, 12 , 13 , this); 
	public IntField NumerodaVersaodoLote = new IntField ("Número da Versão do Lote", true, 14 , 16 , this); 
	public StringField Filler1 = new StringField ("Filler", false, 17 , 17 , this); 
	public IntField TipodeInscricaodaEmpresa = new IntField ("Tipo de Inscrição da Empresa", false, 18 , 18, 2l , this); 
	public IntField NumerodeInscricaodaEmpresa = new IntField ("Número de Inscrição da Empresa", true, 19 , 32, 11274077000176l, this); 
	public StringField CodigodoConvenionoBanco = new StringField ("Código do Convenio no Banco", true, 33 , 52,"00333044004902599853", this); 
	public IntField AgenciaMantenedoradaConta = new IntField ("Agência Mantenedora da Conta", true, 53 , 57, 3044l , this); 
	public StringField DigitoVerificadordaAgencia = new StringField ("Dígito Verificador da Agência", false, 58 , 58 , this);
	public IntField NumerodaContaCorrente = new IntField ("Número da Conta Corrente", true, 59 , 70, 13003935l, this); 
	public IntField DigitoVerificadordaConta = new IntField ("Dígito Verificador da Conta", true, 71 , 71, 7l , this); 
	public StringField DigitoVerificadordaAgenciaConta = new StringField ("Dígito Verificador da Agência/Conta", false, 72 , 72 , this); 
	public StringField NomedaEmpresa = new StringField ("Nome da Empresa", true, 73 , 102 , this); 
	public StringField Informacao1Mensagem = new StringField ("Informação 1 - Mensagem", false, 103 , 142 , this); 
	public StringField Endereco = new StringField ("Endereço", false, 143 , 172 , this);
	public IntField Numero = new IntField ("Número", false, 173 , 177 , this); 
	public StringField ComplementodoEndereco = new StringField ("Complemento do Endereço", false, 178 , 192 , this); 
	public StringField Cidade = new StringField ("Cidade", false, 193 , 212 , this);
	public IntField CEP = new IntField ("CEP", false, 213 , 217 , this);
	public IntField ComplementodoCEP = new IntField ("Complemento do CEP", false, 218 , 220 , this);
	public StringField UF = new StringField ("UF", false, 221 , 222 , this); 
	public StringField Filler2 = new StringField ("Filler", false, 223 , 230 , this); 
	public StringField OcorrenciasparaoRetorno = new StringField ("Ocorrências para o Retorno", false, 231 , 240 , this);
	
}