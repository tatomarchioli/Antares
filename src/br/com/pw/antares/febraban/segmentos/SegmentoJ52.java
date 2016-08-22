package br.com.pw.antares.febraban.segmentos;

import java.util.ArrayList;
import java.util.List;

import br.com.pw.antares.febraban.interfaces.FebrabanSegmento;
import br.com.pw.antares.fields.IntField;
import br.com.pw.antares.fields.StringField;
import br.com.santander.interfaces.AntaresField;

public class SegmentoJ52 implements FebrabanSegmento<SegmentoJ52>{
	public IntField CodigodoBanco = new IntField (" Código do Banco ", false, 1 , 3 , 033); 
	public IntField LotedeServico = new IntField (" Lote de Serviço ", false, 4 , 7 ); 
	public IntField TipodeRegistro = new IntField (" Tipo de Registro ", false, 8 , 8 ,3 ); 
	public IntField NumeroSequencialdoRegistronoLote = new IntField (" Número Sequencial do Registro no Lote ", false, 9 , 13 ); 
	public StringField CodigoSegmentodoRegistroDetalhe = new StringField (" Código Segmento do Registro Detalhe ", false, 14 , 14 , "J" ); 
	public StringField Filler1 = new StringField (" Filler ", false, 15 , 15 ); 
	public IntField CodigodeMovimentoRemessa = new IntField (" Código de Movimento Remessa ", false, 16 , 17 ); 
	public IntField IdentificacaoRegistroOpcional = new IntField (" Identificação Registro Opcional ", false, 18 , 19 ); 
	public IntField TipodeInscricaoSacado = new IntField (" Tipo de Inscrição ", false, 20 , 20 );
	public IntField CPFNNPJdoSacado = new IntField (" CPF/NNPJ do Sacado ", false, 21 , 35 ); 
	public StringField NomedoSacado = new StringField (" Nome do Sacado ", false, 36 , 75 ); 
	public IntField TipodeInscricaoCedente = new IntField (" Tipo de Inscrição ", false, 76 , 76 );
	public IntField CPFCNPJdoCedente = new IntField (" CPF/CNPJ do Cedente ", false, 77 , 91 ); 
	public StringField NomedoCedente = new StringField (" Nome do Cedente ", false, 92 , 131 ); 
	public IntField TipodeInscricaoSacador = new IntField (" Tipo de Inscrição ", false, 132 , 132 ); 
	public IntField CPFNNPJdoSacador = new IntField (" CPF/NNPJ do Sacador ", false, 133 , 147 ); 
	public StringField NomedoSacador = new StringField (" Nome do Sacador ", false, 148 , 187 );
	public StringField Filler2 = new StringField (" Filler ", false, 188 , 240 );

	List<AntaresField> fields = new ArrayList<>();


	public SegmentoJ52(){
		fields.add(	CodigodoBanco	);	
		fields.add(	LotedeServico	);	
		fields.add(	TipodeRegistro	);	
		fields.add(	NumeroSequencialdoRegistronoLote	);	
		fields.add(	CodigoSegmentodoRegistroDetalhe	);	
		fields.add(	Filler1	);	
		fields.add(	CodigodeMovimentoRemessa	);	
		fields.add(	IdentificacaoRegistroOpcional	);	
		fields.add(	TipodeInscricaoSacado	);	
		fields.add(	CPFNNPJdoSacado	);	
		fields.add(	NomedoSacado	);	
		fields.add(	TipodeInscricaoCedente	);	
		fields.add(	CPFCNPJdoCedente	);	
		fields.add(	NomedoCedente	);	
		fields.add(	TipodeInscricaoSacador	);	
		fields.add(	CPFNNPJdoSacador	);	
		fields.add(	NomedoSacador	);	
		fields.add(	Filler2	);	
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
	public SegmentoJ52 setFromLine(String line) throws Exception {
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