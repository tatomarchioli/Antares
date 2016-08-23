package br.com.pw.antares.fields;

import java.text.DecimalFormat;

import br.com.pw.antares.interfaces.AntaresField;

public class DoubleField implements AntaresField<Double> {
	private String name;
	private Double value;
	private int ofsset;
	private int end;
	private int decimalCases;
	private boolean required;
	private boolean emptyAllowed;

	public DoubleField(String name, Boolean obligatory, int start, int end, int decimalCases) {
		this.setName(name);
		this.setRequired(obligatory);
		this.setOffset(start);
		this.setEnd(end);
		this.setDecimalCases(decimalCases);
	}

	public DoubleField(String name, Boolean obligatory, int start, int end, int decimalCases, double value) {
		this.setName(name);
		this.setRequired(obligatory);
		this.setOffset(start);
		this.setEnd(end);
		this.setDecimalCases(decimalCases);
		this.setValue(value);
	}

	//	@Override
	//	public int getLenght() {
	//		return end - (ofsset - 1);
	//	}

	@Override
	public Double getValue() {
		return value;
	}

	@Override
	public void setValue(Double value) {
		this.value = value;
	}

	@Override
	public int getOffset() {
		return ofsset;
	}

	@Override
	public void setOffset(int start) {
		this.ofsset = start;
	}

	@Override
	public int getEnd() {
		return end;
	}

	@Override
	public void setEnd(int end) {
		this.end = end;
	}

	public int getDecimalCases() {
		return decimalCases;
	}

	public void setDecimalCases(int decimalCases) {
		this.decimalCases = decimalCases;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean isRequired() {
		return required;
	}

	@Override
	public void setRequired(boolean obligatory) {
		this.required = obligatory;
	}

	@Override
	public boolean isEmptyAllowed() {
		return emptyAllowed;
	}

	@Override
	public void setEmptyAllowed(boolean emptyAllowed) {
		this.emptyAllowed = emptyAllowed;
	}

	@Override
	public String toLine() throws Exception {
		//Verifica por requerido
		//TODO remover verificação por zeros apos a criação da verificação por allowEmpty

		if (isRequired() && (getValue() == null || getValue() == 0 )) {
			throw new Exception("["+getName()+"] - Este campo é requerido.");
		}

		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(getDecimalCases());
		df.setMinimumFractionDigits(getDecimalCases());
		String valor = df.format(getValue() == null ? 0.00 : getValue()).replaceAll("\\D", "");

		//Verifica pelo tamanho do campo
		if (valor.length() > getLenght())
			throw new Exception("["+getName()+"] - Tamanho maximo escedido - Max: " + getLenght() + " - Tamanho: " + valor.length());

		//Retorna o valor formatado
		return String.format("%1$" + getLenght() + "s", valor).replace(" ", "0");
	}

	@Override
	public void fromLine(String line) {
		String string = line.substring(ofsset - 1, end).trim();
		if (string.isEmpty())
			return;

		StringBuilder b = new StringBuilder(string);
		b.insert(getLenght() - getDecimalCases(), '.');
		this.value = Double.parseDouble(b.toString());
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(getDecimalCases());
		df.setMinimumFractionDigits(getDecimalCases());
		return df.format(value);
	}

}
