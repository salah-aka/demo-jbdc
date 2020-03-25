package fr.diginamic.jdbc.Exception;


public class ComptaException extends RuntimeException {

	public ComptaException() {
	}

	public ComptaException(String message) {
		super(message);
	}

	public ComptaException(String message, Throwable cause) {
		super(message, cause);
	}

	public ComptaException(Throwable cause) {
		super(cause);
	}

}