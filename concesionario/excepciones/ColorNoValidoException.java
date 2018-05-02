package concesionario.excepciones;

/**
 * Exception color no v�lido
 * 
 * @author Francisco Ramirez
 * @version 1.0
 */

public class ColorNoValidoException extends Exception {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;

	public ColorNoValidoException (String string) {
		super(string);
	}
}
