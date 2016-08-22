package br.com.pw.antares.fields;

import java.text.ParseException;

import org.joda.time.DateTime;

import br.com.pw.antares.interfaces.AntaresField;
import br.com.pw.antares.util.Tools;

public class DateField implements AntaresField{
	private DateTime value;
	private String nome;
	private boolean isObrigatorio;
	private int start;
	private int end;
	private String format;

	public DateField(String nome,Boolean isObrigatorio, int start, int end, String format){
		this.nome = nome;
		this.isObrigatorio = isObrigatorio;
		this.start = start;
		this.end = end;
		this.format = format;
	}
	
	public DateField(String nome,Boolean isObrigatorio, int start, int end, String format, DateTime value){
		this.nome = nome;
		this.isObrigatorio = isObrigatorio;
		this.start = start;
		this.end = end;
		this.format = format;
		this.value = value;
	}

	public DateTime getValue() {
		return value;
	}
	public void setValue(DateTime value) {
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
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
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
		try{
			if(isObrigatorio && value == null){
				throw new Exception("Valor obrigatório vazio");
			}
			String valor = value.toString(format);
			return String.format("%1$"+getSize()+ "s", valor).replace(" ", "0");
		}catch(Exception e){
			if(isObrigatorio)
				throw new Exception(nome+" inválido: "+e);
			else 
				return String.format("%1$"+getSize()+ "s", "").replace(" ", "0");
		}
	}
	
	@Override
	public void setValueFromLine(String line) {
		try {
			String string = line.substring(start-1,end).trim();
			if (string.isEmpty())return;
			this.value = Tools.stringToDate(string,format);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString(){
		try{
			return value.toString("dd/MM/yyyy HH:mm:ss");
		}catch(Exception e){
			return "NULL";
		}
	}

}
