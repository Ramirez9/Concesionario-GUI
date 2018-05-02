package concesionario.excepciones;

/**
 * Exception coche ya existe
 * 
 * @author Francisco Ramírez Ruiz
 * @version 1.0
 */
public class CocheYaExisteException extends Exception {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;

	public CocheYaExisteException(String string) {
		super(string);
		
	}
}
