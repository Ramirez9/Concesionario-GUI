package concesionario.excepciones;
/**
 * Exception coche no existe
 * 
 * @author Francisco Ramírez Ruiz
 *
 */
public class CocheNoExisteException extends Exception {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;

	public CocheNoExisteException (String string) {
		super(string);
	}
}
