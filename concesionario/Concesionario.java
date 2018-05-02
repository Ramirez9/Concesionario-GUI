package concesionario;

import java.io.Serializable;
import java.util.ArrayList;

import concesionario.enumeraciones.Color;
import concesionario.enumeraciones.Modelo;
import concesionario.excepciones.CocheNoExisteException;
import concesionario.excepciones.CocheYaExisteException;
import concesionario.excepciones.ColorNoValidoException;
import concesionario.excepciones.MatriculaNoValidaException;
import concesionario.excepciones.ModeloNoValidoException;
/**
 *  Envoltorio de un ArrayList de la clase Coche
 *  
 * @author Francisco Ram�rez
 * 
 *
 */
public class Concesionario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Coches que se guardar�n en el concesionario, ArrayList
	 */
	private ArrayList<Coche> concesionario = new ArrayList<Coche>();
	/**
	 * A�ade un coche al concesionario
	 * 
	 * @param matricula
	 * @param modelo
	 * @param color
	 * @throws CocheYaExisteException
	 * @throws MatriculaNoValidaException
	 * @throws ModeloNoValidoException
	 * @throws ColorNoValidoException
	 */
	public void annadir(String matricula, Modelo modelo, Color color) 
			throws CocheYaExisteException, MatriculaNoValidaException, ModeloNoValidoException, ColorNoValidoException {
		Coche coche = new Coche(matricula, modelo, color);
		if (!concesionario.contains(coche)) {
			concesionario.add(coche);
		} else {
			throw new CocheYaExisteException("El coche ya existe");
		}
	}

	/**
	 * Elimina un coche del concesionario
	 * 
	 * @param matricula
	 * @return 
	 * @throws CocheNoExisteException
	 * @throws MatriculaNoValidaException
	 */
	public boolean eliminar(String matricula) throws CocheNoExisteException, MatriculaNoValidaException {
		Coche coche = new Coche(matricula);
		if (concesionario.contains(coche)) {
			return concesionario.remove(coche);
		} else {
			throw new CocheNoExisteException("El coche no existe");
		}
	}

	/**
	 * Obtiene un coche del concesionario a trav�s de la matr�cula
	 * 
	 * @param matricula
	 * @return Coche del concesionario
	 * @throws MatriculaNoValidaException
	 * @throws CocheNoExisteException
	 */
	public Coche getCoche(String matricula) throws MatriculaNoValidaException, CocheNoExisteException {
		Coche coche = new Coche(matricula);
		if (concesionario.contains(coche)) {
			return concesionario.get(concesionario.indexOf(coche));
		} else {
			throw new CocheNoExisteException("El coche no existe");
		}
	}

	/**
	 * Cadena con los coches del color deseado
	 * 
	 * @param color
	 * @return candena con los coches de un color
	 */
	StringBuilder getColor(Color color) {
		StringBuilder cadena = new StringBuilder();
		for (Coche coche : concesionario) {
			if (coche.getColor() == color) {
				cadena.append(coche);
			}
		}
		return cadena;
	}
	/**
	 * Devuelve una cadena con los coches del color deseado
	 * 
	 * @param color
	 * @return candena con los coches de un color
	 * @throws ListaVaciaException
	 * @throws CocheNoExisteException
	 */
	public ArrayList<Coche> getCocheColor(Color color) throws CocheNoExisteException {
		if (isEmpty())
			throw new CocheNoExisteException("Lista vac�a");

		ArrayList<Coche> cadena = new ArrayList<Coche>();
		for (Coche coche : concesionario) {
			if (coche.getColor() == color) {
				cadena.add(coche);
			}
		}
		if (cadena.size() == 0) {
			throw new CocheNoExisteException("No hay ning�n coche de ese color");
		}
		return cadena;
	}

	/**
	 * N�mero de coches del concesionario para contarlos
	 * 
	 * @return tama�o de la lista
	 */
	public int size() {
		return concesionario.size();
	}
	/**
	 * No hay coches
	 * @return
	 */
	public boolean isEmpty() {
		return concesionario.isEmpty();
		}
	
	public ArrayList<Coche> getConcesionario(){
		return concesionario;
	}

	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		int i = 0;
		if (concesionario.isEmpty()) {
			cadena.append("\nEl concesionario est� vacio\n");
		}
		for (Coche coche : concesionario) {
			cadena.append("\n" + (i + 1) + ". " + coche);
			i++;
		}

		return cadena.toString();
	}

}
