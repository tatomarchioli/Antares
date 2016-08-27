package br.com.pw.antares.febraban.enums;

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
