package br.com.pw.antares.febraban.segmentos;

import java.util.ArrayList;
import java.util.List;

import br.com.pw.antares.febraban.interfaces.FebrabanSegmento;
import br.com.pw.antares.fields.IntField;
import br.com.pw.antares.fields.StringField;
import br.com.pw.antares.interfaces.AntaresField;

public class Header implements FebrabanSegmento<Header>{
	public IntField CodigodoBanco = new IntField (" Código do Banco ", true, 1 , 3 , 33); 
	public IntField LotedeServico = new IntField (" Lote de Serviço ", true, 4 , 7 ); 
	public IntField TipodeRegistro = new IntField (" Tipo de Registro ", true, 8 , 8 , 1 );
	public StringField TipodaOperacao = new StringField (" Tipo da Operação ", true, 9 , 9 ); 
	public IntField TipodeServico = new IntField (" Tipo de Serviço ", true, 10 , 11 ); 
	public IntField FormadeLancamento = new IntField (" Forma de Lançamento ", true, 12 , 13 ); 
	public IntField NumerodaVersaodoLote = new IntField (" Número da Versão do Lote ", true, 14 , 16 ); 
	public StringField Filler1 = new StringField (" Filler ", false, 17 , 17 ); 
	public IntField TipodeInscricaodaEmpresa = new IntField (" Tipo de Inscrição da Empresa ", false, 18 , 18, 2 ); 
	public IntField NumerodeInscricaodaEmpresa = new IntField (" Número de Inscrição da Empresa ", true, 19 , 32, 11274077000176l ); 
	public StringField CodigodoConvenionoBanco = new StringField (" Código do Convenio no Banco ", true, 33 , 52, "00333044004902599853" ); 
	public IntField AgenciaMantenedoradaConta = new IntField (" Agência Mantenedora da Conta ", true, 53 , 57, 3044 ); 
	public StringField DigitoVerificadordaAgencia = new StringField (" Dígito Verificador da Agência ", false, 58 , 58 );
	public IntField NumerodaContaCorrente = new IntField (" Número da Conta Corrente ", true, 59 , 70, 13003935); 
	public IntField DigitoVerificadordaConta = new IntField (" Dígito Verificador da Conta ", true, 71 , 71, 7 ); 
	public StringField DigitoVerificadordaAgenciaConta = new StringField (" Dígito Verificador da Agência/Conta ", false, 72 , 72 ); 
	public StringField NomedaEmpresa = new StringField (" Nome da Empresa ", true, 73 , 102 ); 
	public StringField Informacao1Mensagem = new StringField (" Informação 1 - Mensagem ", false, 103 , 142 ); 
	public StringField Endereco = new StringField (" Endereço ", false, 143 , 172 );
	public IntField Numero = new IntField (" Número ", false, 173 , 177 ); 
	public StringField ComplementodoEndereco = new StringField (" Complemento do Endereço ", false, 178 , 192 ); 
	public StringField Cidade = new StringField (" Cidade ", false, 193 , 212 );
	public IntField CEP = new IntField (" CEP ", false, 213 , 217 );
	public IntField ComplementodoCEP = new IntField (" Complemento do CEP ", false, 218 , 220 );
	public StringField UF = new StringField (" UF ", false, 221 , 222 ); 
	public StringField Filler2 = new StringField (" Filler ", false, 223 , 230 ); 
	public StringField OcorrenciasparaoRetorno = new StringField (" Ocorrências para o Retorno ", false, 231 , 240 );

	List<AntaresField> fields = new ArrayList<>();

	public Header(){
		fields.add(CodigodoBanco);	
		fields.add(LotedeServico);	
		fields.add(TipodeRegistro);	
		fields.add(TipodaOperacao);	
		fields.add(TipodeServico);	
		fields.add(FormadeLancamento);	
		fields.add(NumerodaVersaodoLote);	
		fields.add(Filler1);	
		fields.add(TipodeInscricaodaEmpresa);	
		fields.add(NumerodeInscricaodaEmpresa);	
		fields.add(CodigodoConvenionoBanco);	
		fields.add(AgenciaMantenedoradaConta);	
		fields.add(DigitoVerificadordaAgencia);	
		fields.add(NumerodaContaCorrente);	
		fields.add(DigitoVerificadordaConta);	
		fields.add(DigitoVerificadordaAgenciaConta);	
		fields.add(NomedaEmpresa);	
		fields.add(Informacao1Mensagem);	
		fields.add(Endereco);	
		fields.add(Numero);	
		fields.add(ComplementodoEndereco);	
		fields.add(Cidade);	
		fields.add(CEP);	
		fields.add(ComplementodoCEP);	
		fields.add(UF);	
		fields.add(Filler2);	
		fields.add(OcorrenciasparaoRetorno);	
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
			throw new Exception("Lote: "+LotedeServico.getValue()+" - Header Lote - "+e.getMessage());
		}
	}

	@Override
	public Header setFromLine(String line) throws Exception {
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