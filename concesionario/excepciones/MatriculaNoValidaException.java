package concesionario.excepciones;

/**
 * Exception matrícula no válida.
 * 
 * @author Francisco Ramírez Ruiz
 * @version 1.0
 */
public class MatriculaNoValidaException extends Exception {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;

	public MatriculaNoValidaException(String string) {
		super(string);
		
	}

}