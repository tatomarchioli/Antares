package br.com.pw.antares.fields;

import br.com.pw.antares.baseclasses.AntaresField;
import br.com.pw.antares.baseclasses.AntaresLine;

public class IntField extends AntaresField<Long> {

	public IntField(String name, boolean obligatory, int start, int end) {
		this(name, obligatory, start, end, null, null);
	}

	public IntField(String name, boolean obligatory, int start, int end, AntaresLine line) {
		this(name, obligatory, start, end, null, line);
	}
	
	public IntField(String name, boolean obligatory, int start, int end, Long value) {
		this(name, obligatory, start, end, value, null);
	}
	
	public IntField(String name, boolean obligatory, int start, int end, Long value, AntaresLine line) {
		super(name, obligatory, start, end, value, line);
		setFiller('0');
	}

	@Override
	public void fromLine(String line) {
		String string = line.substring(getOffset() - 1, getLimit()).trim();
		if (string.isEmpty())
			return;
		setValue(Long.parseLong(string));
	}

	@Override
	public String toString() {
		return String.valueOf(getValue());
	}

	@Override
	public String toStringValue() {
		return String.valueOf(getValue() == null ? 0 : getValue());
	}

}
