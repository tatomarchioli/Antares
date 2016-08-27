package br.com.pw.antares.baseclasses;


import org.apache.commons.lang3.StringUtils;

import br.com.pw.antares.enums.PadDirection;

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
	private int limit;
	private boolean required;
	private boolean emptyAllowed;
	private char filler = ' ';
	private PadDirection padDirection = PadDirection.LEFT;

	protected AntaresField(String name, boolean obligatory, int start, int end, T defaultValue, AntaresLine line) {
		this.setName(name);
		this.setRequired(obligatory);
		this.setOffset(start);
		this.setLimit(end);
		this.setValue(defaultValue);
		this.setupInLine(line);
	}

	/**
	 * Retorna o nome do campo, utilizado para identifica-lo nos logs.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Seta o nome do campo, utilizado para indentifica-lo nos logs.
	 */
	public AntaresField<T> setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Retorna o valor contido neste campo.
	 */
	public T getValue() {
		return value;
	};

	/**
	 * Seta o valor do campo
	 */
	public AntaresField<T> setValue(T value) {
		this.value = value;
		return this;
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
	public AntaresField<T> setOffset(int offset) {
		this.offset = offset;
		return this;
	};

	/**
	 * Retorna o fim do campo (limit) dentro da linha do arquivo de remessa.
	 */
	public int getLimit() {
		return limit;
	};

	/**
	 * Seta o fim do campo (limit) dentro da linha do arquivo de remessa.
	 */
	public AntaresField<T> setLimit(int limit) {
		this.limit = limit;
		return this;
	};

	/**
	 * Retorna o tamanho do campo (length) dentro da linha do arquivo de
	 * remessa.<br>
	 * É composto pelo valor de <strong>{@code getEnd() - getOffset() - 1}</strong>.
	 */
	public int getLength() {
		if(getOffset() > getLimit())
			throw new IllegalArgumentException("O offset não pode ser maior que o limite");
		
		if(getLimit() <= 0)
			throw new IllegalArgumentException("O limit não pode ser menor ou igual a zero");
		
		return getLimit() - (getOffset() - 1);
	}

	/**
	 * Retorna o char que irá preencher o tamanho restante do campo, em caso de
	 * um valor menor que o tamanho total.
	 */
	public char getFiller() {
		return filler;
	}

	/**
	 * Seta o char que irá preencher o tamanho restante do campo, em caso de um
	 * valor menor que o tamanho total.
	 */
	public AntaresField<T> setFiller(char filler) {
		this.filler = filler;
		return this;
	}

	/**
	 * Seta a direção em que a string vai receber o padding.
	 */
	public AntaresField<T> setPadDirection(PadDirection padDirection) {
		if(padDirection == null)
			throw new NullPointerException("padDirection inválida");
		this.padDirection = padDirection;
		return this;
	}

	/**
	 * Retorna a direção em que a string vai receber o padding.
	 */
	public PadDirection getPadDirection() {
		return padDirection;
	}

	/**
	 * Define se este campo é requerido ou não, ou seja, no momento de
	 * validação, caso o valor seja nulo, uma exception será lançada.
	 */
	public AntaresField<T> setRequired(boolean required) {
		this.required = required;
		return this;
	};

	/**
	 * Retorna se este campo é requerido ou não, ou seja, no momento de
	 * validação, caso o valor seja nulo, uma exception será lançada.
	 */
	public boolean isRequired() {
		return required;
	};

	/**
	 * Define se este campo permite valores vazios, mesmo que seja requerido.
	 */
	public AntaresField<T> setEmptyAllowed(boolean emptyAllowed) {
		this.emptyAllowed = emptyAllowed;
		return this;
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
	public String toLine() throws Exception {
		// Verifica por requerido
		if (isRequired() && (getValue() == null)) {
			throw new Exception("[" + getName() + "] - Este campo é requerido.");
		}

		// Verifica por vazios
		if (isEmptyAllowed() && (toStringValue().isEmpty())) {
			throw new Exception("[" + getName() + "] - Este campo não pode ser vazio.");
		}

		String valor = toStringValue();
		if (valor == null) {
			throw new NullPointerException("[" + getName() + "] - O valor retornado não pode ser null.");
		}

		// Verifica pelo tamanho do campo
		if (valor.length() > getLength()) {
			throw new Exception("[" + getName() + "] - Tamanho maximo escedido - Max: " + getLength() + " - Tamanho: "
					+ valor.length());
		}

		// Retorna o valor formatado
		if(getPadDirection() == PadDirection.LEFT)
			return StringUtils.leftPad(valor, getLength(), String.valueOf(getFiller()));
		else
			return StringUtils.rightPad(valor, getLength(), String.valueOf(getFiller()));
	}

	/**
	 * Recebe a linha de um arquivo e faz o setup do valor do campo de acordo
	 * com as configurações de offset e end.
	 */
	public abstract void fromLine(String line) throws Exception;

	/**
	 * Retorna o valor em string que esse campo deve ter ao ser representado
	 * dentro do arquivo. O valor retornado não pode ser nulo.
	 */
	public abstract String toStringValue();

	/**
	 * Faz o setup deste campo dentro da linha. Utilizado para facilitar a
	 * construção das classes de linhas
	 */
	private final void setupInLine(AntaresLine line) {
		if (line == null)
			return;
		line.addField(this);
	}

}
