package br.com.pw.antares.febraban.segmentos;

import br.com.pw.antares.baseclasses.AntaresLine;
import br.com.pw.antares.baseclasses.AntaresLineBatch;
import br.com.pw.antares.fields.IntField;
import br.com.pw.antares.fields.StringField;

public	class TrailerArquivo extends AntaresLine{
	
	public TrailerArquivo(){
		this(true, null);
	}
	
	public TrailerArquivo(boolean include, AntaresLineBatch batch) {
		super(240, 9,"Trailer Arquivo", include, batch);
	}
	
	public IntField CodigodoBanco = new IntField ("Código do Banco", true, 1 , 3 , 33l, this); 
	public IntField LotedeServico = new IntField ("Lote de Serviço", true, 4 , 7, 9999l , this); 
	public IntField TipodeRegistro = new IntField ("Tipo de Registro", true, 8 , 8 , 9l , this);
	public StringField Filler1 = new StringField ("Filler", false, 9 , 17 , this); 
	public IntField Quantidadedelotesdoarquivo = new IntField ("Quantidade de lotes do arquivo", true, 18 , 23 , this); 
	public IntField Quantidadederegistrosnoarquivo = new IntField ("Quantidade de registros no arquivo", true, 24 , 29 , this); 
	public StringField Filler2 = new StringField ("Filler", false, 30 , 240 , this);
}