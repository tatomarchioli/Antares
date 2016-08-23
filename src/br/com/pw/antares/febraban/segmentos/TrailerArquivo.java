package br.com.pw.antares.febraban.segmentos;

import java.util.ArrayList;
import java.util.List;

import br.com.pw.antares.febraban.interfaces.FebrabanSegmento;
import br.com.pw.antares.fields.IntField;
import br.com.pw.antares.fields.StringField;
import br.com.pw.antares.interfaces.AntaresField;

public	class TrailerArquivo implements FebrabanSegmento<TrailerArquivo>{
	public IntField CodigodoBanco = new IntField (" Código do Banco ", true, 1 , 3 , 33l); 
	public IntField LotedeServico = new IntField (" Lote de Serviço ", true, 4 , 7, 9999l ); 
	public IntField TipodeRegistro = new IntField (" Tipo de Registro ", true, 8 , 8 , 9l );
	public StringField Filler1 = new StringField (" Filler ", false, 9 , 17 ); 
	public IntField Quantidadedelotesdoarquivo = new IntField (" Quantidade de lotes do arquivo ", true, 18 , 23 ); 
	public IntField Quantidadederegistrosnoarquivo = new IntField (" Quantidade de registros no arquivo ", true, 24 , 29 ); 
	public StringField Filler2 = new StringField (" Filler ", false, 30 , 240 );

	List<AntaresField<?>> fields = new ArrayList<>();

	public TrailerArquivo(){
		fields.add(CodigodoBanco);
		fields.add(LotedeServico);
		fields.add(TipodeRegistro);
		fields.add(Filler1);
		fields.add(Quantidadedelotesdoarquivo);
		fields.add(Quantidadederegistrosnoarquivo);
		fields.add(Filler2);
	}

	@Override
	public String toLinha() throws Exception {
		String linha = "";
		for(AntaresField<?> f : fields){
			linha+= f.toLine();
		}
		return linha;
	}
	
	@Override
	public TrailerArquivo fromLinha(String line) throws Exception {
		try{
			for(AntaresField<?> f : fields){
				f.fromLine(line);
			}
		}catch(Exception e){
			throw new Exception("Lote: "+LotedeServico.getValue()+" - Header Lote - "+e.getMessage());
		}
		return this;
	}
}