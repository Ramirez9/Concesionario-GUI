package concesionario.excepciones;

/**
 * Exception matr�cula no v�lida.
 * 
 * @author Francisco Ram�rez Ruiz
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