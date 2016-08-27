package br.com.pw.antares.fields;

import java.text.ParseException;

import org.joda.time.DateTime;

import br.com.pw.antares.baseclasses.AntaresField;
import br.com.pw.antares.baseclasses.AntaresLine;
import br.com.pw.antares.util.Tools;

public class DateField extends AntaresField<DateTime> {

	private String format;

	public DateField(String name, Boolean obligatory, int start, int end, String format) {
		this(name,obligatory, start, end, format, null, null);
	}

	public DateField(String name, Boolean obligatory, int start, int end, String format, DateTime value) {
		this(name,obligatory, start, end, format, value, null);
	}

	public DateField(String name, Boolean obligatory, int start, int end, String format, AntaresLine line) {
		this(name,obligatory, start, end, format, null, line);
	}
	
	public DateField(String name, Boolean obligatory, int start, int end, String format, DateTime value, AntaresLine line) {
		super(name, obligatory, start, end, value, line);
		this.setFormat(format);
	}

	
	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}


	@Override
	public String toLine() throws Exception {

		//Verifica se o campo é requerido
		if (isRequired() && getValue() == null) {
			throw new Exception("["+getName()+"] - Este campo é requerido.");
		}

		//Verifica por formato
		String valor;
		try{
			valor = getValue() == null ? "" : getValue().toString(format);
		}catch(Exception e){
			throw new Exception("["+getName()+"] - Formato de Data/Hora inválido: "+getFormat());
		}

		//Verifica o tamanho do campo
		if (valor.length() > getLength()){
			throw new Exception("["+getName()+"] - Tamanho maximo excedido - Max: " + getLength() + " - Tamanho: " + valor.length());
		}

		//Verifica se o campo permite vazios
		//TODO


		//Retorna campo formatado.
		return String.format("%1$" + getLength() + "s", valor).replace(" ", "0");
	}

	@Override
	public void fromLine(String line) {
		try {
			String string = line.substring(getOffset() - 1, getEnd()).trim();
			if (string.isEmpty())
				return;
			setValue(Tools.stringToDate(string, format));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		try {
			return getValue().toString("dd/MM/yyyy HH:mm:ss");
		} catch (Exception e) {
			return "NULL";
		}
	}
}
