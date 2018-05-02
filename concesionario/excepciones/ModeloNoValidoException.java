package concesionario.excepciones;

/**
 * Exception modelo no válido
 * 
 * @author Francisco Ramírez Ruiz
 *
 */
public class ModeloNoValidoException extends Exception {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;

	public ModeloNoValidoException(String string) {
		super(string);
		
	}
}
