package br.com.pw.antares.fields;

import java.text.ParseException;

import org.joda.time.DateTime;

import br.com.pw.antares.interfaces.AntaresField;
import br.com.pw.antares.util.Tools;

public class DateField implements AntaresField<DateTime> {
	private String name;
	private DateTime value;
	private int offset;
	private int end;
	private String format;
	private boolean required;
	private boolean emptyAllowed;

	public DateField(String name, Boolean obligatory, int start, int end, String format) {
		this.setName(name);
		this.setRequired(obligatory);
		this.setOffset(start);
		this.setEnd(end);
		this.setFormat(format);
	}

	public DateField(String name, Boolean obligatory, int start, int end, String format, DateTime value) {
		this.setName(name);
		this.setRequired(obligatory);
		this.setOffset(start);
		this.setEnd(end);
		this.setFormat(format);
		this.setValue(value);
	}

	//	@Override
	//	public int getLenght() {
	//		return end - (start - 1);
	//	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public DateTime getValue() {
		return value;
	}

	@Override
	public void setValue(DateTime value) {
		this.value = value;
	}

	@Override
	public int getOffset() {
		return offset;
	}

	@Override
	public void setOffset(int start) {
		this.offset = start;
	}

	@Override
	public int getEnd() {
		return end;
	}

	@Override
	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public void setRequired(boolean obligatory) {
		this.required = obligatory;
	}

	@Override
	public boolean isRequired() {
		return required;
	}

	@Override
	public boolean isEmptyAllowed() {
		return emptyAllowed;
	}

	@Override
	public void setEmptyAllowed(boolean emptyAllowed) {
		this.emptyAllowed = emptyAllowed;
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
		if (valor.length() > getLenght()){
			throw new Exception("["+getName()+"] - Tamanho maximo excedido - Max: " + getLenght() + " - Tamanho: " + valor.length());
		}

		//Verifica se o campo permite vazios
		//TODO


		//Retorna campo formatado.
		return String.format("%1$" + getLenght() + "s", valor).replace(" ", "0");
	}

	@Override
	public void fromLine(String line) {
		try {
			String string = line.substring(offset - 1, end).trim();
			if (string.isEmpty())
				return;
			this.value = Tools.stringToDate(string, format);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		try {
			return value.toString("dd/MM/yyyy HH:mm:ss");
		} catch (Exception e) {
			return "NULL";
		}
	}
}
