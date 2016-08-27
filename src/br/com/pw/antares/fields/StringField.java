package br.com.pw.antares.fields;

import br.com.pw.antares.baseclasses.AntaresField;
import br.com.pw.antares.baseclasses.AntaresLine;
import br.com.pw.antares.enums.PadDirection;

public class StringField extends AntaresField<String> {

	public StringField(String name, boolean obligatory, int start, int end) {
		this(name, obligatory, start, end, null, null);
	}
	
	public StringField(String name, boolean obligatory, int start, int end, AntaresLine line) {
		this(name, obligatory, start, end, null, line);
	}

	public StringField(String name, boolean obligatory, int start, int end, String value) {
		this(name, obligatory, start, end, value, null);
	}
	
	public StringField(String name, boolean obligatory, int start, int end, String value, AntaresLine line) {
		super(name, obligatory, start, end, value, line);
		setPadDirection(PadDirection.RIGHT);
	}

	@Override
	public void fromLine(String line) {
		setValue(line.substring(getOffset() - 1, getLimit()).trim());
	}

	@Override
	public String toString() {
		return getValue();
	}

	@Override
	public String toStringValue() {
		return getValue() == null ? "" : getValue().trim();
	}
}
