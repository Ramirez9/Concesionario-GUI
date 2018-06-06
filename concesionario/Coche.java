package concesionario;

import java.io.Serializable;
import java.util.regex.Pattern;

import concesionario.enumeraciones.Color;
import concesionario.enumeraciones.Modelo;
import concesionario.excepciones.ColorNoValidoException;
import concesionario.excepciones.MatriculaNoValidaException;
import concesionario.excepciones.ModeloNoValidoException;
/**
 * Clase coche del paquete concesionario
 * @author Francisco Ramírez Ruiz
 * @version 1.0
 *
 */
public class Coche implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Matrícula del coche
	 */
	private String matricula;

	/**
	 * Modelo del coche
	 */
	private Modelo modelo;

	/**
	 * Color del coche
	 */
	private Color color;
	
	static final private Pattern patternMatricula = Pattern.compile("^(\\d{4})[ -]?([B-Z&&[^EIOUQ]]{3})$");

	/**
	 * Constructor para crear un coche por la matrícula, modelo y color. Si
	 * alguno de estos no es válido, lanza una excepción
	 * 
	 * @param matricula
	 * @param modelo
	 * @param color
	 * @throws MatriculaNoValidaException
	 * @throws ModeloNoValidoException
	 * @throws ColorNoValidoException
	 */
	public Coche(String matricula, Modelo modelo, Color color)
			throws MatriculaNoValidaException, ModeloNoValidoException, ColorNoValidoException {
		setMatricula(matricula);
		setModelo(modelo);
		setColor(color);
	}

	/**
	 * Constructor que crea un coche solo por la matrícula. Si la matrícula es
	 * inválida, se lanza una excepción
	 * 
	 * @param matricula
	 * @throws MatriculaNoValidaException
	 */
	public Coche(String matricula) throws MatriculaNoValidaException {
		setMatricula(matricula);
	}

	public String getMatricula() {
		return matricula;
	}

	/**
	 * Asigna una matrícula al coche de nuestra clase, si es inválida se lanza
	 * una excepción
	 * 
	 * @param matricula
	 * @throws MatriculaNoValidaException
	 */
	private void setMatricula(String matricula) throws MatriculaNoValidaException {
		if (!esValida(matricula)) 
			throw new MatriculaNoValidaException("La matrícula no es válida");
		this.matricula = estandarizarMatricula(matricula);
	}

	/**
	 * Transforma el formato de una matrícula para que las podamos tratar a
	 * todas por igual
	 * 
	 * @param matricula
	 * @return matrícula válida
	 */
	private String estandarizarMatricula(String matricula) {
		assert esValida(matricula);
		return matricula.replaceAll("[ -]", "");
	}

	/**
	 * Comprueba si una matrícula es o no válida mediante la expresión regular
	 * 
	 * @param matricula
	 * @return 
	 * @return true si la matrícula es válida, false si no lo es
	 */
	public static boolean esValida(String matricula){
		return patternMatricula.matcher(matricula).matches();
	}

	public Modelo getModelo() {
		return modelo;
	}

	/**
	 * Asigna un modelo al coche de nuestra clase. Lanza una excepción si el modelo no es válido
	 * @param modelo
	 * @throws ModeloNoValidoException
	 */
	private void setModelo(Modelo modelo) throws ModeloNoValidoException {
		if (modelo != null) 
			this.modelo = modelo;
		else 
			throw new ModeloNoValidoException("El modelo no es válido");
	}

	public Color getColor() {
		return color;
	}

	/**
	 * Asigna un color al coche de nuestra clase. Lanza una excepción si el color no es válido
	 * @param color
	 * @throws ColorNoValidoException
	 */
	private void setColor(Color color) throws ColorNoValidoException {
		if (modelo != null) 
			this.color = color;
		else
			throw new ColorNoValidoException("El color no es válido");
		
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		Coche other = (Coche) o;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Coche con matricula " + getMatricula() + ", color " + getColor() + " y modelo " + getModelo() + "\n";
	}

}
