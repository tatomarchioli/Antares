package br.com.pw.antares.febraban.interfaces;

public interface FebrabanSegmento<T> {
	/**
	 * Enumera todos os tipos de registros possíveis.*/
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
	
	/**
	 * Enumera todos os tipos de segmentos possíveis.*/
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
			throw new Exception("Tipo de registro inválido: "+value);
		}
	}
	
	
	/**
	 * Retorna uma string contendo todos os campos contidos no segmento, formatados
	 * e concatenados, prontos para serem adicionados ao arquivo.*/
	public String toLinha() throws Exception ;
	
	/**
	 * Seta todos os valores do segmento a partir de uma string vinda do arquivo.*/
	public T fromLinha(String line) throws Exception ;
}
