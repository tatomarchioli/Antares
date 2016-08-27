package br.com.pw.antares.fields;

import br.com.pw.antares.baseclasses.AntaresField;
import br.com.pw.antares.baseclasses.AntaresLine;

public class IntField extends AntaresField<Long> {

	public IntField(String name, Boolean obligatory, int start, int end) {
		this(name, obligatory, start, end, null, null);
	}

	public IntField(String name, Boolean obligatory, int start, int end, AntaresLine line) {
		this(name, obligatory, start, end, null, line);
	}
	
	public IntField(String name, Boolean obligatory, int start, int end, Long value) {
		this(name, obligatory, start, end, value, null);
	}
	
	public IntField(String name, Boolean obligatory, int start, int end, Long value, AntaresLine line) {
		super(name, obligatory, start, end, value, line);
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
		if (valor.length() > getLength()){
			throw new Exception("["+getName()+"] - Tamanho maximo escedido - Max: " + getLength()+ " - Tamanho: " + valor.length());
		}

		//Retorna o valor formatado
		return String.format("%1$" + getLength() + "s", valor).replace(" ", "0");
	}

	@Override
	public void fromLine(String line) {
		String string = line.substring(getOffset() - 1, getEnd()).trim();
		if (string.isEmpty())
			return;
		setValue(Long.parseLong(string));
	}

	@Override
	public String toString() {
		return String.valueOf(getValue());
	}

}
