package br.com.pw.antares.fields;

import br.com.pw.antares.interfaces.AntaresField;

public class IntField implements AntaresField<Long> {
	private String name;
	private Long value;
	private int offset;
	private int end;
	private boolean required;
	private boolean emptyAllowed;

	public IntField(String nome, Boolean isObrigatorio, int start, int end) {
		this.setName(nome);
		this.setRequired(isObrigatorio);
		this.setOffset(start);
		this.setEnd(end);
	}

	public IntField(String nome, Boolean isObrigatorio, int start, int end, Long value) {
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
	public Long getValue() {
		return value;
	}

	@Override
	public void setValue(Long value) {
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

		String valor = String.valueOf(getValue() == null ? 0 : getValue());
		
		//Verifica pelo tamanho do campo
		if (valor.length() > getLenght()){
			throw new Exception("["+getName()+"] - Tamanho maximo escedido - Max: " + getLenght()+ " - Tamanho: " + valor.length());
		}

		//Retorna o valor formatado
		return String.format("%1$" + getLenght() + "s", valor).replace(" ", "0");
	}

	@Override
	public void fromLine(String line) {
		String string = line.substring(offset - 1, end).trim();
		if (string.isEmpty())
			return;
		this.value = Long.parseLong(string);
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

}
