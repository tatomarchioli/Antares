package br.com.pw.antares.febraban.segmentos;

import java.util.ArrayList;
import java.util.List;

import br.com.pw.antares.febraban.interfaces.FebrabanSegmento;
import br.com.pw.antares.fields.IntField;
import br.com.pw.antares.fields.StringField;
import br.com.santander.fields.DateField;
import br.com.santander.interfaces.AntaresField;

public class HeaderArquivo implements FebrabanSegmento<HeaderArquivo>{

	public IntField CodigodoBanco = new IntField (" Código do Banco ", true, 1 , 3 , 33); 
	public IntField LotedeServico = new IntField (" Lote de Serviço ", false, 4 , 7 );
	public IntField TipodeRegistro = new IntField (" Tipo de Registro ", false, 8 , 8, 0 );
	public StringField Filler1 = new StringField (" Filler ", false, 9 , 17 ); 
	public IntField TipodeInscricaodaEmpresa = new IntField (" Tipo de Inscrição da Empresa ", true, 18 , 18, 2 ); 
	public IntField NumeroInscricaodaEmpresa = new IntField (" Número Inscrição da Empresa ", true, 19 , 32, 11274077000176l ); 
	public StringField CodigodoConvenionoBanco = new StringField (" Código do Convenio no Banco ", true, 33 , 52 , "00333044004902599853"); 
	public IntField AgenciaMantenedoradaConta = new IntField (" Agência Mantenedora da Conta ", true, 53 , 57, 3044 ); 
	public StringField DigitoVerificadordaAgencia = new StringField (" Dígito Verificador da Agência ", false, 58 , 58);
	public IntField NumerodaContaCorrente = new IntField (" Número da Conta Corrente ", true, 59 , 70, 13003935 ); 
	public StringField DigitoVerificadordaConta = new StringField (" Dígito Verificador da Conta ", true, 71 , 71 ,"7"); 
	public StringField DigitoVerificadordaAgenciaConta = new StringField (" Dígito Verificador da Agência / Conta ", false, 72 , 72 ); 
	public StringField NomedaEmpresa = new StringField (" Nome da Empresa ", true, 73 , 102 ); 
	public StringField NomedoBanco = new StringField (" Nome do Banco ", true, 103 , 132 , "Banco Santander "); 
	public StringField Filler2 = new StringField (" Filler ", false, 133 , 142 ); 
	public IntField CodigoRemessaRetorno = new IntField (" Código Remessa / Retorno ", true, 143 , 143, 1 ); 
	public DateField DatadaGeracaodoArquivo = new DateField (" Data da Geração do Arquivo ", true, 144 , 151 , "ddMMyyyy" ); 
	public DateField HoradaGeracaodoArquivo = new DateField (" Hora da Geração do Arquivo ", true, 152 , 157 , "HHmmss" ); 
	public IntField NumeroSequencialdoArquivo = new IntField (" Número Sequencial do Arquivo ", true, 158 , 163 ); 
	public IntField NumerodaVersaodoLayout = new IntField (" Número da Versão do Layout ", false, 164 , 166 );
	public IntField DensidadedeGravacaoArquivo = new IntField (" Densidade de Gravação Arquivo ", false, 167 , 171 ); 
	public StringField UsoReservadodoBanco = new StringField (" Uso Reservado do Banco ", false, 172 , 191 ); 
	public StringField UsoReservadodaEmpresa = new StringField (" Uso Reservado da Empresa ", false, 192 , 211 );
	public StringField Filler3 = new StringField (" Filler ", false, 212 , 230 ); 
	public StringField OcorrenciasparaoRetorno = new StringField (" Ocorrências para o Retorno ", false, 231 , 240 );

	List<AntaresField> fields = new ArrayList<>();

	public HeaderArquivo(){
		fields.add(CodigodoBanco);
		fields.add(LotedeServico);
		fields.add(TipodeRegistro);
		fields.add(Filler1);
		fields.add(TipodeInscricaodaEmpresa);
		fields.add(NumeroInscricaodaEmpresa);
		fields.add(CodigodoConvenionoBanco);
		fields.add(AgenciaMantenedoradaConta);
		fields.add(DigitoVerificadordaAgencia);
		fields.add(NumerodaContaCorrente);
		fields.add(DigitoVerificadordaConta);
		fields.add(DigitoVerificadordaAgenciaConta);
		fields.add(NomedaEmpresa);
		fields.add(NomedoBanco);
		fields.add(Filler2);
		fields.add(CodigoRemessaRetorno);
		fields.add(DatadaGeracaodoArquivo);
		fields.add(HoradaGeracaodoArquivo);
		fields.add(NumeroSequencialdoArquivo);
		fields.add(NumerodaVersaodoLayout);
		fields.add(DensidadedeGravacaoArquivo);
		fields.add(UsoReservadodoBanco);
		fields.add(UsoReservadodaEmpresa);
		fields.add(Filler3);
		fields.add(OcorrenciasparaoRetorno);
	}


	@Override
	public String getAsLine() throws Exception {
		try{
			String linha = "";
			for(AntaresField f : fields){
				linha+= f.getValueAsLine();
			}
			return linha;
		}catch(Exception e){
			throw new Exception("Header de arquivo - "+e.getMessage());
		}
	}
	
	@Override
	public HeaderArquivo setFromLine(String line) throws Exception {
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
