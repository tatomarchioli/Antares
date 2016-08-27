package br.com.pw.antares.fields;

import br.com.pw.antares.baseclasses.AntaresField;
import br.com.pw.antares.baseclasses.AntaresLine;

public class StringField extends AntaresField<String> {

	public StringField(String name, Boolean obligatory, int start, int end) {
		this(name, obligatory, start, end, null, null);
	}
	
	public StringField(String name, Boolean obligatory, int start, int end, AntaresLine line) {
		this(name, obligatory, start, end, null, line);
	}

	public StringField(String name, Boolean obligatory, int start, int end, String value) {
		this(name, obligatory, start, end, value, null);
	}
	
	public StringField(String name, Boolean obligatory, int start, int end, String value, AntaresLine line) {
		super(name, obligatory, start, end, value, line);
	}

	@Override
	public String toLine() throws Exception {
		//Verifica por requerido
		//TODO remover verificação por zeros apos a criação da verificação por allowEmpty
		if (isRequired() && (getValue() == null || getValue().isEmpty())) {
			throw new Exception("["+getName()+"] - Este campo é requerido.");
		}
		
		//Verifica pelo tamanho do campo
		if (getValue().length() > getLength()){
			throw new Exception("["+getName()+"] - Tamanho maximo escedido - Max: " + getLength()+ " - Tamanho: " + getValue().length());
		}

		//Retorna o valor formatado
		return String.format("%1$-" + getLength() + "s", getValue() == null ? "" : getValue().trim());
	}

	@Override
	public void fromLine(String line) {
		setValue(line.substring(getOffset() - 1, getEnd()).trim());
	}

	@Override
	public String toString() {
		return getValue();
	}
}
