package br.com.pw.antares.febraban.segmentos;

import java.util.ArrayList;
import java.util.List;

import br.com.pw.antares.febraban.interfaces.FebrabanSegmento;
import br.com.pw.antares.fields.DoubleField;
import br.com.pw.antares.fields.IntField;
import br.com.pw.antares.fields.StringField;
import br.com.pw.antares.interfaces.AntaresField;

public class Trailer  implements FebrabanSegmento<Trailer>{
	public IntField CodigodoBanco = new IntField (" Código do Banco ", true, 1 , 3 , 33l); 
	public IntField LotedeServico = new IntField (" Lote de Serviço ", true, 4 , 7 ); 
	public IntField TipodeRegistro = new IntField (" Tipo de Registro ", false, 8 , 8 ,5l ); 
	public StringField Filler1 = new StringField (" Filler ", false, 9 , 17 ); 
	public IntField QuantidadedeRegistrosdoLote = new IntField (" Quantidade de Registros do Lote ", true, 18 , 23 ); 
	public DoubleField SomatoriadosValores = new DoubleField (" Somatória dos Valores ", false, 24 , 41 , 2 ); 
	public DoubleField SomatpriaQuantidadedeMoedas = new DoubleField (" Somatória Quantidade de Moedas ", false, 42 , 59 , 2 ); 
	public IntField NumeroAvisodeDebito = new IntField (" Número Aviso de Débito ", false, 60 , 65 ); 
	public StringField Filler2 = new StringField (" Filler ", false, 66 , 230 ); 
	public StringField OcorrenciasparaoRetorno = new StringField (" Ocorrências para o Retorno ", false, 231 , 240 );

	List<AntaresField<?>> fields = new ArrayList<>();

	public Trailer(){
		fields.add(	CodigodoBanco	);
		fields.add(	LotedeServico	);
		fields.add(	TipodeRegistro	);
		fields.add(	Filler1	);
		fields.add(	QuantidadedeRegistrosdoLote	);
		fields.add(	SomatoriadosValores	);
		fields.add(	SomatpriaQuantidadedeMoedas	);
		fields.add(	NumeroAvisodeDebito	);
		fields.add(	Filler2	);
		fields.add(	OcorrenciasparaoRetorno	);
	}

	@Override
	public String toLinha() throws Exception {
		try{
			String linha = "";
			for(AntaresField<?> f : fields){
				linha+= f.toLine();
			}
			return linha;
		}catch(Exception e){
			throw new Exception("Lote: "+LotedeServico.getValue()+" - Trailer Lote - "+e.getMessage());
		}
	}
	
	@Override
	public Trailer fromLinha(String line) throws Exception {
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