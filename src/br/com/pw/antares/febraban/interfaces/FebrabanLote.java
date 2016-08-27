package br.com.pw.antares.febraban.interfaces;

import java.util.List;

public interface FebrabanLote<T> {
	

	
	/**Retorna a lista de linhas contidas no lote.*/
	public List<String> getLinhas()  throws Exception;
	
	public T setLinhas(List<String> linhas)throws Exception;

	public boolean validate() throws Exception;
	
	public int contadorRegistros();
}