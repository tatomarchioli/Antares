package br.com.pw.antares.febraban.segmentos;

import br.com.pw.antares.baseclasses.AntaresLine;
import br.com.pw.antares.baseclasses.AntaresLineBatch;
import br.com.pw.antares.fields.IntField;
import br.com.pw.antares.fields.StringField;

public class SegmentoJ52 extends AntaresLine{
	
	public SegmentoJ52(){
		this(true, null);
	}
	
	public SegmentoJ52(boolean include, AntaresLineBatch batch) {
		super(240, 3, "Segmento J52", include, batch);
	}
	
	public IntField CodigodoBanco = new IntField (" Código do Banco ", false, 1 , 3 , 033l, this); 
	public IntField LotedeServico = new IntField (" Lote de Serviço ", false, 4 , 7 , this); 
	public IntField TipodeRegistro = new IntField (" Tipo de Registro ", false, 8 , 8 ,3l, this); 
	public IntField NumeroSequencialdoRegistronoLote = new IntField (" Número Sequencial do Registro no Lote ", false, 9 , 13 , this); 
	public StringField CodigoSegmentodoRegistroDetalhe = new StringField (" Código Segmento do Registro Detalhe ", false, 14 , 14 , "J" , this); 
	public StringField Filler1 = new StringField (" Filler ", false, 15 , 15 , this); 
	public IntField CodigodeMovimentoRemessa = new IntField (" Código de Movimento Remessa ", false, 16 , 17 , this); 
	public IntField IdentificacaoRegistroOpcional = new IntField (" Identificação Registro Opcional ", false, 18 , 19 , this); 
	public IntField TipodeInscricaoSacado = new IntField (" Tipo de Inscrição ", false, 20 , 20 , this);
	public IntField CPFNNPJdoSacado = new IntField (" CPF/NNPJ do Sacado ", false, 21 , 35 , this); 
	public StringField NomedoSacado = new StringField (" Nome do Sacado ", false, 36 , 75 , this); 
	public IntField TipodeInscricaoCedente = new IntField (" Tipo de Inscrição ", false, 76 , 76 , this);
	public IntField CPFCNPJdoCedente = new IntField (" CPF/CNPJ do Cedente ", false, 77 , 91 , this); 
	public StringField NomedoCedente = new StringField (" Nome do Cedente ", false, 92 , 131 , this); 
	public IntField TipodeInscricaoSacador = new IntField (" Tipo de Inscrição ", false, 132 , 132 , this); 
	public IntField CPFNNPJdoSacador = new IntField (" CPF/NNPJ do Sacador ", false, 133 , 147 , this); 
	public StringField NomedoSacador = new StringField (" Nome do Sacador ", false, 148 , 187 , this);
	public StringField Filler2 = new StringField (" Filler ", false, 188 , 240 , this);
	
	@Override
	public boolean canUnmarshal(String line) {
		
		return false;
	}
}