package es.citasmedicas.excepciones;

public class UserNotExistException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserNotExistException() {
		super("Para realizar la operacion debe haber algun usuario guardado");
	}

}