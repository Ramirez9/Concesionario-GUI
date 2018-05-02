package concesionario.excepciones;

/**
 * Exception modelo no v�lido
 * 
 * @author Francisco Ram�rez Ruiz
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
