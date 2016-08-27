package br.com.pw.antares.febraban.enums;

public enum TipoRegistro{
	HEADER_ARQUIVO(0),
	HEADER(1),
	SEGMENTO(3),
	TRAILER(5),
	TRAILER_ARQUIVO(9);
	
	private int value;
	TipoRegistro(int value){
		this.value = value;
	}
	
	public static TipoRegistro getByValue(int value) throws Exception{
		for(TipoRegistro t : values()){
			if(t.value == value)return t;
		}
		throw new Exception("Tipo de registro inválido: "+value);
	}
}
