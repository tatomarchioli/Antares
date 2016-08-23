package br.com.pw.antares.fields;

import br.com.pw.antares.interfaces.AntaresField;

public class StringField implements AntaresField<String> {
	private String name;
	private String value;
	private int offset;
	private int end;
	private boolean required;
	private boolean emptyAllowed;

	public StringField(String nome, Boolean isObrigatorio, int start, int end) {
		this.setName(nome);
		this.setRequired(isObrigatorio);
		this.setOffset(start);
		this.setEnd(end);
	}

	public StringField(String nome, Boolean isObrigatorio, int start, int end, String value) {
		this.setName(nome);
		this.setRequired(isObrigatorio);
		this.setOffset(start);
		this.setEnd(end);
		this.setValue(value);
	}

	//	@Override
	//	public int getLenght() {
	//		return end - (offset - 1);
	//	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
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
		if (isRequired() && (getValue() == null || getValue().isEmpty())) {
			throw new Exception("["+getName()+"] - Este campo é requerido.");
		}
		
		//Verifica pelo tamanho do campo
		if (getValue().length() > getLenght()){
			throw new Exception("["+getName()+"] - Tamanho maximo escedido - Max: " + getLenght()+ " - Tamanho: " + getValue().length());
		}

		//Retorna o valor formatado
		return String.format("%1$-" + getLenght() + "s", value == null ? "" : value.trim());
	}

	@Override
	public void fromLine(String line) {
		this.value = line.substring(offset - 1, end).trim();
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
