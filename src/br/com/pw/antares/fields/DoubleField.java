package br.com.pw.antares.fields;

import java.text.DecimalFormat;

import br.com.pw.antares.interfaces.AntaresField;


public class DoubleField implements AntaresField {
	private double value;
	private int start;
	private int end;
	private int decimal;
	private String nome;
	private Boolean isObrigatorio;

	public DoubleField(String nome,Boolean isObrigatorio,int start, int end, int decimal){
		this.nome = nome;
		this.isObrigatorio = isObrigatorio;
		this.start = start;
		this.end = end;
		this.decimal = decimal;
	}
	
	public DoubleField(String nome,Boolean isObrigatorio,int start, int end, int decimal, double value){
		this.nome = nome;
		this.isObrigatorio = isObrigatorio;
		this.start = start;
		this.end = end;
		this.decimal = decimal;
		this.value = value;
	}

	public double getValue() {
		return value;
	}
	public void setValue(double value) {
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
	public int getDecimal() {
		return decimal;
	}
	public void setDecimal(int decimal) {
		this.decimal = decimal;
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
			DecimalFormat df = new DecimalFormat();
			df.setMaximumFractionDigits(decimal);
			df.setMinimumFractionDigits(decimal);
			String valor = df.format(value).replaceAll("\\D", "");
			if(valor.length() > getSize())
				throw new Exception("Tamanho maximo escedido - Max: "+getSize()+" - Tamanho: "+valor.length());
			return String.format("%1$"+getSize()+ "s", valor).replace(" ", "0");
		}catch(Exception e){
			throw new Exception(nome+" inválido: "+e);
		}
	}
	
	@Override
	public void setValueFromLine(String line) {
		String string = line.substring(start-1,end).trim();
		if (string.isEmpty())return;
		
		StringBuilder b = new StringBuilder(string);
		b.insert(getSize()-decimal, '.');
		this.value = Double.parseDouble(b.toString());
	}
	
	@Override
	public String toString(){
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(decimal);
		df.setMinimumFractionDigits(decimal);
		return df.format(value);
	}
}
