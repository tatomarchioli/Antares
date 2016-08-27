package br.com.pw.antares.fields;

import java.text.DecimalFormat;

import br.com.pw.antares.baseclasses.AntaresField;
import br.com.pw.antares.baseclasses.AntaresLine;

public class DoubleField extends AntaresField<Double> {
	private int decimalCases;

	public DoubleField(String name, boolean obligatory, int start, int end, int decimalCases) {
		this(name, obligatory, start, end, decimalCases, null, null);
	}

	public DoubleField(String name, boolean obligatory, int start, int end, int decimalCases, AntaresLine line) {
		this(name, obligatory, start, end, decimalCases, null, line);
	}

	public DoubleField(String name, boolean obligatory, int start, int end, int decimalCases, Double value) {
		this(name, obligatory, start, end, decimalCases, value, null);
	}

	public DoubleField(String name, boolean obligatory, int start, int end, int decimalCases, Double value, AntaresLine line) {
		super(name, obligatory, start, end, value, line);
		this.setDecimalCases(decimalCases);
		this.setFiller('0');
	}

	public int getDecimalCases() {
		return decimalCases;
	}

	public void setDecimalCases(int decimalCases) {
		if (decimalCases >= getLength())
			throw new IllegalArgumentException(
					"O numero de casas decimais não pode ser maior ou igual ao tamanho total do campo.");
		this.decimalCases = decimalCases;
	}

	@Override
	public void fromLine(String line) {
		String string = line.substring(getOffset() - 1, getLimit()).trim();
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

	@Override
	public String toStringValue() {
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(getDecimalCases());
		df.setMinimumFractionDigits(getDecimalCases());
		return df.format(getValue() == null ? 0.00 : getValue()).replaceAll("\\D", "");
	}

}
