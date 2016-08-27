package br.com.pw.antares.baseclasses;

/**
 * Antares field é a classe mãe de todos os campos que serão incluídos no
 * arquivo.<br>
 * Os campos recebem uma configuração de validação e serão validados apenas no
 * momento da geração do arquivo.
 */
public abstract class AntaresField<T> {

	private String name;
	private T value;
	private int offset;
	private int end;
	private boolean required;
	private boolean emptyAllowed;

//	protected AntaresField(String name, Boolean obligatory, int start, int end) {
//		this(name, obligatory, start, end, null);
//	}
//	
//	protected AntaresField(String name, Boolean obligatory, int start, int end, T defaultValue) {
//		this(name, obligatory, start, end, defaultValue, null);
//	}
	
	protected AntaresField(String name, Boolean obligatory, int start, int end, T defaultValue, AntaresLine line){
		this.setName(name);
		this.setRequired(obligatory);
		this.setOffset(start);
		this.setEnd(end);
		this.setValue(defaultValue);
		this.setupInLine(line);
	}
	
	/**
	 * Retorna o nome do campo, utilizado para identifica-lo nos logs
	 */
	public String getName() {
		return name;
	}

	/**
	 * Seta o nome do campo, utilizado para indentifica-lo nos logs
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retorna o valor contido neste campo
	 */
	public T getValue() {
		return value;
	};

	/**
	 * Seta o valor do campo
	 */
	public void setValue(T value) {
		this.value = value;
	};

	/**
	 * Retorna o inicio do campo (offset) dentro da linha do arquivo de remessa.
	 */
	public int getOffset() {
		return offset;
	};

	/**
	 * Seta o inicio do campo (offset) dentro da linha do arquivo de remessa.
	 */
	public void setOffset(int offset) {
		this.offset = offset;
	};

	/**
	 * Retorna o fim do campo (end) dentro da linha do arquivo de remessa.
	 */
	public int getEnd() {
		return end;
	};

	/**
	 * Seta o fim do campo (end) dentro da linha do arquivo de remessa.
	 */
	public void setEnd(int end) {
		this.end = end;
	};

	/**
	 * Retorna o tamanho do campo (length) dentro da linha do arquivo de
	 * remessa.<br>
	 * É pelo valor de <strong>{@code getEnd() - getOffset() - 1}</strong>
	 */
	public int getLength() {
		return getEnd() - (getOffset() - 1);
	};

	/**
	 * Define se este campo é requerido ou não, ou seja, no momento de
	 * validação, caso o valor seja nulo, uma exception será lançada.
	 */
	public void setRequired(boolean required) {
		this.required = required;
	};

	/**
	 * Retorna se este campo é requerido ou não, ou seja, no momento de
	 * validação, caso o valor seja nulo, uma exception será lançada
	 */
	public boolean isRequired() {
		return required;
	};

	/**
	 * Define se este campo permite valores vazios, mesmo que seja requerido.
	 */
	public void setEmptyAllowed(boolean emptyAllowed) {
		this.emptyAllowed = emptyAllowed;
	};

	/**
	 * Retorna se este campo permite valores vazios, mesmo que seja requerido.
	 */
	public boolean isEmptyAllowed() {
		return emptyAllowed;
	};

	/**
	 * Retorna o valor do campo já formatado em linha, pronto para ser
	 * adicionado ao arquivo.
	 */
	public abstract String toLine() throws Exception;

	/**
	 * Recebe a linha de um arquivo e faz o setup do valor do campo de acordo
	 * com as configurações de offset e end.
	 */
	public abstract void fromLine(String line) throws Exception;

	/**
	 * Faz o setup deste campo dentro da linha. Utilizado para facilitar a
	 * construção das classes de linhas
	 */
	private final void setupInLine(AntaresLine line) {
		if(line == null)return;
		line.addField(this);
	}
	
	
	

}
