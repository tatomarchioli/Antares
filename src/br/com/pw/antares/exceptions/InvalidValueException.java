package br.com.pw.antares.exceptions;


public class InvalidValueException extends Exception {
	private static final long serialVersionUID = 739289872006483969L;

	public InvalidValueException() {
		super();
	}

	public InvalidValueException(String message) {
		super(message);
	}

	public InvalidValueException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidValueException(Throwable cause) {
		super(cause);
	}
}
