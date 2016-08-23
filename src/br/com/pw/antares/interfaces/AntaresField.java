package br.com.pw.antares.interfaces;

public interface AntaresField<T> {
	/** Retorna o nome do campo, utilizado para identifica-lo nos logs */
	public String getName();

	/** Seta o nome do campo, utilizado para indentifica-lo nos logs */
	public void setName(String name);

	/** Retorna o valor contido neste campo */
	public T getValue();

	/** Seta o valor do campo */
	public void setValue(T value);

	/**
	 * Retorna o inicio do campo (offset) dentro da linha do arquivo de remessa.
	 */
	public int getOffset();

	/**
	 * Seta o inicio do campo (offset) dentro da linha do arquivo de remessa.
	 */
	public void setOffset(int offset);

	/** Retorna o fim do campo (end) dentro da linha do arquivo de remessa. */
	public int getEnd();

	/** Seta o fim do campo (end) dentro da linha do arquivo de remessa. */
	public void setEnd(int end);

	/**
	 * Retorna o tamanho do campo (lenght) dentro da linha do arquivo de
	 * remessa.<br>
	 * É pelo valor de <strong>{@code getEnd() - getOffset() - 1}</strong>
	 */
	default int getLenght(){
		return getEnd() - (getOffset() - 1);
	};

	/**
	 * Define se este campo é requerido ou não, ou seja, no momento de
	 * validação, caso o valor seja nulo, uma exception será lançada.
	 */
	public void setRequired(boolean required);

	/**
	 * Retorna se este campo é requerido ou não, ou seja, no momento de
	 * validação, caso o valor seja nulo, uma exception será lançada
	 */
	public boolean isRequired();

	/**
	 * Define se este campo permite valores vazios, mesmo que seja requerido.
	 */
	public void setEmptyAllowed(boolean emptyAllowed);

	/**
	 * Retorna se este campo permite valores vazios, mesmo que seja requerido.
	 */
	public boolean isEmptyAllowed();

	/**
	 * Retorna o valor do campo já formatado em linha, pronto para ser
	 * adicionado ao arquivo.
	 */
	public String toLine() throws Exception;

	/**
	 * Recebe a linha de um arquivo e faz o setup do valor do campo de acordo
	 * com as configurações de offset e end.
	 */
	public void fromLine(String line) throws Exception;

}
