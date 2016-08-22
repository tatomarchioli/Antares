package br.com.pw.antares.fields;

import br.com.pw.antares.interfaces.AntaresField;

public class IntField implements AntaresField{
	private long value;
	private int start;
	private int end;
	private String nome;
	private Boolean isObrigatorio;
	
	public IntField(String nome,Boolean isObrigatorio,int start, int end){
		this.nome = nome;
		this.isObrigatorio = isObrigatorio;
		this.start = start;
		this.end = end;
	}
	
	public IntField(String nome,Boolean isObrigatorio,int start, int end, long value){
		this.nome = nome;
		this.isObrigatorio = isObrigatorio;
		this.start = start;
		this.end = end;
		this.value = value;
	}
	

	public long getValue() {
		return value;
	}
	public void setValue(long value) {
		this.value = value;
	}
	public int getSize() {
		return end-(start-1);
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getIsObrigatorio() {
		return isObrigatorio;
	}

	public void setIsObrigatorio(Boolean isObrigatorio) {
		this.isObrigatorio = isObrigatorio;
	}

	@Override
	public String getValueAsLine() throws Exception {
		try{
			if(isObrigatorio && value == 0){
				throw new Exception("Valor obrigatório vazio");
			}
			String valor = String.valueOf(value);
			if(valor.length() > getSize())
				throw new Exception(nome+" inválido: Tamanho maximo escedido - Max: "+getSize()+" - Tamanho: "+valor.length());
			
			return String.format("%1$"+getSize()+ "s", valor).replace(" ", "0");
		}catch(Exception e){
			throw new Exception(nome+" inválido: "+e);
		}
	}
	
	@Override
	public void setValueFromLine(String line) {
		String string = line.substring(start-1,end).trim();
		if (string.isEmpty())return;
		this.value = Long.parseLong(string);
	}
	
	@Override
	public String toString(){
		return String.valueOf(value);
	}

}
