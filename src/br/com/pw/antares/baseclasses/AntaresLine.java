package br.com.pw.antares.baseclasses;

import java.util.ArrayList;
import java.util.List;

public abstract class AntaresLine {
	private final List<AntaresField<?>> fields = new ArrayList<>();
	private int length;
	private int lineType;
	private String lineTag;
	private int lineSequence;
	private boolean include;

	protected AntaresLine(int maxLength, int lineType, String lineTag, boolean include, AntaresLineBatch batch) {
		setLength(maxLength);
		setLineType(lineType);
		setLineTag(lineTag);
		setupInBatch(batch);
	}

	/**
	 * Retorna o tipo da linha. Utilizado como um id para diferencias os tipos
	 * diferentes de linhas dentro do arquivo
	 */
	public int getLineType() {
		return lineType;
	}

	/**
	 * Seta o tipo da linha. Utilizado como um id para diferencias os tipos
	 * diferentes de linhas dentro do arquivo
	 */
	public void setLineType(int lineType) {
		this.lineType = lineType;
	}

	/**
	 * Retorna a tag da linha. Utilizado para facilitar a identificação dos
	 * erros no log e etc.
	 */
	public String getLineTag() {
		return lineTag;
	}

	/**
	 * Seta a tag da linha. Utilizado para facilitar a identificação dos erros
	 * no log e etc.
	 */
	public void setLineTag(String lineTag) {
		if (lineTag == null) {
			throw new NullPointerException("Line Tag is null");
		}
		this.lineTag = lineTag;
	}

	/**
	 * Retorna a sequencia da linha no arquivo.
	 */
	public int getLineSequence() {
		return lineSequence;
	}

	/**
	 * Seta a sequencia da linha no arquivo.
	 */
	public void setLineSequence(int lineSequence) {
		this.lineSequence = lineSequence;
	}

	/**
	 * Verifica se a linha deve ser inclusa automaticamente ao lote
	 */
	public boolean isInclude() {
		return include;
	}

	/**
	 * Seta se a linha deve ser inclusa automaticamente ao lote
	 */
	public void setInclude(boolean include) {
		this.include = include;
	}

	/**
	 * Retorna a lista completa de Fields contidos nesta linha.
	 * 
	 */
	public final List<AntaresField<?>> getFields() {
		return fields;
	}

	/**
	 * Registra um novo field na lista de fields. Ao transformar em string, a
	 * ordem de adição será mantida
	 */
	public final void addField(AntaresField<?> field) {
		if (field == null) {
			throw new NullPointerException("Field is null");
		}
		this.fields.add(field);
	}

	/**
	 * Retorna a quantidade máxima de caracteres que permitida por esta linha
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Seta a quantidade máxima de caracteres que permitida por esta linha
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * Retorna uma string contendo todos os campos contidos no segmento,
	 * formatados e concatenados, prontos para serem adicionados ao arquivo.
	 */
	public String toLine() throws Exception {
		String val = "";
		try {
			for (AntaresField<?> field : getFields()) {
				val += field.toLine();
			}
		} catch (Exception e) {
			throw new Exception("[" + getLineTag() + "] -> " + e.getMessage());
		}
		if (val.length() > getLength()) {
			throw new Exception(
					"Tamanho máximo da linha excedido. Max: " + getLength() + ", Length: " + val.length());
		}
		return val;
	}

	/**
	 * Seta todos os valores do segmento a partir de uma string vinda do
	 * arquivo.
	 */
	public void fromLine(String line) throws Exception {
		if(line.length() != getLength())
			throw new Exception("[" + getLineTag() + "] -> Os tamanhos não conferem. Informado: "+getLength()+", Recebido: "+line.length());
		try {
			for (AntaresField<?> field : getFields()) {
				field.fromLine(line);
			}
		} catch (Exception e) {
			throw new Exception("[" + getLineTag() + "] -> " + e.getMessage());
		}
	}

	@Override
	public String toString() {
		String val = getLineTag() + " | LineType = " + getLineType() + " | MaxLength = " + getLength()
				+ " | Fields[";
		for (AntaresField<?> field : getFields()) {
			val += field.getName() + " = '" + field.toString()+"'";
			val += (getFields().indexOf(field) == getFields().size() - 1 ? "]" : ", ");
		}
		return val;
	}

	private final void setupInBatch(AntaresLineBatch lineBatch) {
		if (lineBatch == null)
			return;
		lineBatch.addLine(this);
	}
	
	/**
	 * Verifica se a string informada pode ser convertida para a classe desejada*/
	public abstract boolean canUnmarshal(String line);

}
