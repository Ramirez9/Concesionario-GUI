package concesionario.excepciones;
/**
 * Exception coche no existe
 * 
 * @author Francisco Ram�rez Ruiz
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
