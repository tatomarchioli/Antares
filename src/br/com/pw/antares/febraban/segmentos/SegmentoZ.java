package br.com.pw.antares.febraban.segmentos;

import br.com.pw.antares.baseclasses.AntaresLine;
import br.com.pw.antares.baseclasses.AntaresLineBatch;
import br.com.pw.antares.fields.IntField;
import br.com.pw.antares.fields.StringField;

public class SegmentoZ extends AntaresLine{
	public SegmentoZ(){
		this(true, null);
	}
	
	public SegmentoZ(boolean include, AntaresLineBatch batch) {
		super(240, 3, "Segmento Z", include, batch);
	}
	public IntField CodigodoBanco = new IntField (" Código do Banco ", false, 1 , 3 , 033l, this); 
	public IntField LotedeServico = new IntField (" Lote de Serviço ", false, 4 , 7 , this);
	public IntField TipodeRegistro = new IntField (" Tipo de Registro ", false, 8 , 8 ,3l , this);
	public IntField NumeroSequencialdoRegistronoLote = new IntField (" Número Sequencial do Registro no Lote ", false, 9 , 13 , this); 
	public StringField CodigoSegmentonoRegistroDetalhe = new StringField (" Código Segmento no Registro Detalhe ", false, 14 , 14 , "Z" , this);
	public StringField AutenticacaodoPagamento = new StringField (" Autenticação do Pagamento ", false, 15 , 78 , this); 
	public StringField ProtocolodoPagamento = new StringField (" Protocolo do Pagamento ", false, 79 , 103 , this); 
	public StringField Filler = new StringField (" Filler ", false, 104 , 230 , this);
	public StringField OcorrenciasparaoRetorno = new StringField (" Ocorrências para o Retorno ", false, 231 , 240 , this);
}