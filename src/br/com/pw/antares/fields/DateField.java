package br.com.pw.antares.fields;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import br.com.pw.antares.baseclasses.AntaresField;
import br.com.pw.antares.baseclasses.AntaresLine;

public class DateField extends AntaresField<DateTime> {

	private String format;

	public DateField(String name, boolean obligatory, int start, int end, String format) {
		this(name, obligatory, start, end, format, null, null);
	}

	public DateField(String name, boolean obligatory, int start, int end, String format, DateTime value) {
		this(name, obligatory, start, end, format, value, null);
	}

	public DateField(String name, boolean obligatory, int start, int end, String format, AntaresLine line) {
		this(name, obligatory, start, end, format, null, line);
	}

	public DateField(String name, boolean obligatory, int start, int end, String format, DateTime value,
			AntaresLine line) {
		super(name, obligatory, start, end, value, line);
		this.setFormat(format);
		this.setFiller('0');
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		try {
			DateTimeFormat.forPattern(format);
		} catch (Exception e) {
			throw new IllegalArgumentException("[" + getName() + "] - Formato de Data/Hora inválido: " + format);
		}
		if (format.length() != getLength())
			throw new IllegalArgumentException(
					"[" + getName() + "] - O format de Data/Hora deve ser do mesmo tamanho do campo");
		this.format = format;
	}

	@Override
	public void fromLine(String line) {
		String string = line.substring(getOffset() - 1, getLimit()).trim();
		if (string.isEmpty())
			return;
		DateTimeFormatter f;
		try{
			f = DateTimeFormat.forPattern(getFormat());
		}catch(Exception e){
			throw new IllegalArgumentException("[" + getName() + "] - Formato de Data/Hora inválido: " + format);
		}
		setValue(f.parseDateTime(string));
	}

	@Override
	public String toString() {
		try {
			return getValue().toString("dd/MM/yyyy HH:mm:ss");
		} catch (Exception e) {
			return "NULL";
		}
	}

	@Override
	public String toStringValue() {
		return getValue() == null ? "" : getValue().toString(format);
	}
}
