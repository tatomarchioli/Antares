package br.com.pw.antares.febraban.segmentos;

import br.com.pw.antares.baseclasses.AntaresLine;
import br.com.pw.antares.baseclasses.AntaresLineBatch;
import br.com.pw.antares.fields.DoubleField;
import br.com.pw.antares.fields.IntField;
import br.com.pw.antares.fields.StringField;

public class Trailer extends AntaresLine{
	public Trailer(){
		this(true, null);
	}
	public Trailer(boolean include, AntaresLineBatch batch) {
		super(240, 5, "Trailer", include, batch);
	}
	
	public IntField CodigodoBanco = new IntField (" Código do Banco ", true, 1 , 3 , 33l, this); 
	public IntField LotedeServico = new IntField (" Lote de Serviço ", true, 4 , 7 , this); 
	public IntField TipodeRegistro = new IntField (" Tipo de Registro ", false, 8 , 8 ,5l , this); 
	public StringField Filler1 = new StringField (" Filler ", false, 9 , 17 , this); 
	public IntField QuantidadedeRegistrosdoLote = new IntField (" Quantidade de Registros do Lote ", true, 18 , 23 , this); 
	public DoubleField SomatoriadosValores = new DoubleField (" Somatória dos Valores ", false, 24 , 41 , 2 , this); 
	public DoubleField SomatpriaQuantidadedeMoedas = new DoubleField (" Somatória Quantidade de Moedas ", false, 42 , 59 , 2 , this); 
	public IntField NumeroAvisodeDebito = new IntField (" Número Aviso de Débito ", false, 60 , 65 , this); 
	public StringField Filler2 = new StringField (" Filler ", false, 66 , 230 , this); 
	public StringField OcorrenciasparaoRetorno = new StringField (" Ocorrências para o Retorno ", false, 231 , 240 , this);
	
	@Override
	public boolean canUnmarshal(String line) {
		
		return false;
	}
}