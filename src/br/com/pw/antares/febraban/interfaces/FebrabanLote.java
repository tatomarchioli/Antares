package br.com.pw.antares.febraban.interfaces;

import java.util.List;

public interface FebrabanLote<T> {
	
	public enum TipoLote{
		
		PAGAMENTO_FORNECEDOR(20);
		private int value;
		TipoLote(int value){
			this.value = value;
		}
	
		public static TipoLote getByValue(int value) throws Exception{
			for(TipoLote t : values()){
				if (t.value == value) {
					return t;
				}
			}
			throw new Exception("Tipo de lote inválido: "+value);
		}
	}
	
	/**Retorna a lista de linhas contidas no lote.*/
	public List<String> getLinhas()  throws Exception;
	
	public T setLinhas(List<String> linhas)throws Exception;

	public boolean validate() throws Exception;
	
	public int contadorRegistros();
}