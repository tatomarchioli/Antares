package br.com.pw.antares.fields;

import br.com.pw.antares.interfaces.AntaresField;

public class StringField implements AntaresField{
	private String value;
	private String nome;
	private boolean isObrigatorio;
	private int start;
	private int end;
	
	public StringField(String nome,Boolean isObrigatorio, int start, int end){
		this.start = start;
		this.end = end;
		this.isObrigatorio = isObrigatorio;
		this.nome = nome;
	}
	
	public StringField(String nome,Boolean isObrigatorio, int start, int end, String value){
		this.start = start;
		this.end = end;
		this.isObrigatorio = isObrigatorio;
		this.nome = nome;
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
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

	public boolean isObrigatorio() {
		return isObrigatorio;
	}

	public void setObrigatorio(boolean isObrigatorio) {
		this.isObrigatorio = isObrigatorio;
	}

	@Override
	public String getValueAsLine() throws Exception {
		if(isObrigatorio && (value == null || value.length() == 0) )
			throw new Exception(nome+" inválido: Valor obrigatório vazio");
		if(value!= null && value.length() > getSize())
			throw new Exception(nome+" inválido: Tamanho maximo escedido - Max: "+getSize()+" - Tamanho: "+value.length());
		return String.format("%1$-"+getSize()+ "s", value == null ? "" : value.trim());
	}
	
	@Override
	public void setValueFromLine(String line) {
		this.value = line.substring(start-1,end).trim();
	}
	
	@Override
	public String toString(){
		return String.valueOf(value);
	}
}
