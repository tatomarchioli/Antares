package br.com.pw.antares.fields;

import java.text.DecimalFormat;

import br.com.pw.antares.baseclasses.AntaresField;
import br.com.pw.antares.baseclasses.AntaresLine;

public class DoubleField extends AntaresField<Double> {
	private int decimalCases;

	public DoubleField(String name, Boolean obligatory, int start, int end, int decimalCases) {
		this(name, obligatory, start, end, decimalCases, null, null);
	}

	public DoubleField(String name, Boolean obligatory, int start, int end, int decimalCases, AntaresLine line) {
		this(name, obligatory, start, end, decimalCases, null, line);
	}
	
	public DoubleField(String name, Boolean obligatory, int start, int end, int decimalCases, Double value) {
		this(name, obligatory, start, end, decimalCases, value, null);
	}
	public DoubleField(String name, Boolean obligatory, int start, int end,  int decimalCases, Double value, AntaresLine line) {
		super(name, obligatory, start, end, value, line);
		this.setDecimalCases(decimalCases);
	}

	public int getDecimalCases() {
		return decimalCases;
	}

	public void setDecimalCases(int decimalCases) {
		this.decimalCases = decimalCases;
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
		if (valor.length() > getLength())
			throw new Exception("["+getName()+"] - Tamanho maximo escedido - Max: " + getLength() + " - Tamanho: " + valor.length());

		//Retorna o valor formatado
		return String.format("%1$" + getLength() + "s", valor).replace(" ", "0");
	}

	@Override
	public void fromLine(String line) {
		String string = line.substring(getOffset() - 1, getEnd()).trim();
		if (string.isEmpty())
			return;

		StringBuilder b = new StringBuilder(string);
		b.insert(getLength() - getDecimalCases(), '.');
		setValue(Double.parseDouble(b.toString()));
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(getDecimalCases());
		df.setMinimumFractionDigits(getDecimalCases());
		return df.format(getValue());
	}

}
