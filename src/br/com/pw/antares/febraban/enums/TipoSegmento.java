package br.com.pw.antares.febraban.enums;

public enum TipoSegmento{
	A("A"),
	B("B"),
	J("J"),
	J52("J52"),
	Z("Z");
	
	private String value;
	TipoSegmento(String value){
		this.value = value;
	}
	
	public static TipoSegmento getByValue(String value) throws Exception{
		for(TipoSegmento t : values()){
			if(t.value.equalsIgnoreCase(value))return t;
		}
		throw new Exception("Tipo de segmento inválido: "+value);
	}
}
