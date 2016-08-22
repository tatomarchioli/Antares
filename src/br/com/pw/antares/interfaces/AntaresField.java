package br.com.pw.antares.interfaces;

public interface AntaresField {

	/**
	 * Retorna o valor do campo j� formatado, pronto para ser adicionado ao arquivo.*/
	public String getValueAsLine() throws Exception;
	/**
	 * Recebe a linha de um arquivo e faz o setup do valor do campo de acordo com as configura��es.*/
	public void setValueFromLine(String linha) throws Exception;
	
	public String getNome();
	
}
