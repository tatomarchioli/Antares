package br.com.pw.antares.febraban.segmentos;

import java.util.ArrayList;
import java.util.List;

import br.com.pw.antares.febraban.interfaces.FebrabanSegmento;
import br.com.pw.antares.fields.IntField;
import br.com.pw.antares.fields.StringField;
import br.com.santander.interfaces.AntaresField;

public class SegmentoZ implements FebrabanSegmento<SegmentoZ>{
	public IntField CodigodoBanco = new IntField (" Código do Banco ", false, 1 , 3 , 033); 
	public IntField LotedeServico = new IntField (" Lote de Serviço ", false, 4 , 7 );
	public IntField TipodeRegistro = new IntField (" Tipo de Registro ", false, 8 , 8 ,3 );
	public IntField NumeroSequencialdoRegistronoLote = new IntField (" Número Sequencial do Registro no Lote ", false, 9 , 13 ); 
	public StringField CodigoSegmentonoRegistroDetalhe = new StringField (" Código Segmento no Registro Detalhe ", false, 14 , 14 , "Z" );
	public StringField AutenticacaodoPagamento = new StringField (" Autenticação do Pagamento ", false, 15 , 78 ); 
	public StringField ProtocolodoPagamento = new StringField (" Protocolo do Pagamento ", false, 79 , 103 ); 
	public StringField Filler = new StringField (" Filler ", false, 104 , 230 );
	public StringField OcorrenciasparaoRetorno = new StringField (" Ocorrências para o Retorno ", false, 231 , 240 );

	List<AntaresField> fields = new ArrayList<>();

	public SegmentoZ(){
		fields.add(	CodigodoBanco	);	
		fields.add(	LotedeServico	);	
		fields.add(	TipodeRegistro	);	
		fields.add(	NumeroSequencialdoRegistronoLote	);	
		fields.add(	CodigoSegmentonoRegistroDetalhe	);	
		fields.add(	AutenticacaodoPagamento	);	
		fields.add(	ProtocolodoPagamento	);	
		fields.add(	Filler	);	
		fields.add(	OcorrenciasparaoRetorno	);	
	}
	@Override
	public String getAsLine() throws Exception {
		String linha = "";
		for(AntaresField f : fields){
			linha+=f.getValueAsLine();
		}
		return linha;
	}
	
	@Override
	public SegmentoZ setFromLine(String line) throws Exception {
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
		return "SegmentoZ [CodigodoBanco=" + CodigodoBanco + ", LotedeServico=" + LotedeServico + ", TipodeRegistro="
				+ TipodeRegistro + ", NumeroSequencialdoRegistronoLote=" + NumeroSequencialdoRegistronoLote
				+ ", CodigoSegmentonoRegistroDetalhe=" + CodigoSegmentonoRegistroDetalhe + ", AutenticacaodoPagamento="
				+ AutenticacaodoPagamento + ", ProtocolodoPagamento=" + ProtocolodoPagamento + ", Filler=" + Filler
				+ ", OcorrênciasparaoRetorno=" + OcorrenciasparaoRetorno + "]";
	}
	
	
}