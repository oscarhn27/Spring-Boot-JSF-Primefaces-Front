package es.CitasMedicas.excepciones;

public class UserExistException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public UserExistException() {
		super("Para realizar la operacion no debe haber ningun usuario guardado");
	}
}