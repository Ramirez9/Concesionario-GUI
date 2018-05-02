package concesionario.enumeraciones;
/**
 * Modelos de los coches seg�n su Marca
 * 
 * @author Francisco Ram�rez Ruiz
 * @version 1.0
 *
 */
public enum Modelo {
	/**
	 * Modelos seg�n la marca SEAT
	 */
	CORDOBA(Marca.SEAT), TOLEDO(Marca.SEAT), IBIZA(Marca.SEAT),
	/**
	 * Modelos seg�n la marca BMW
	 */
	SERIE1(Marca.BMW), SERIE2(Marca.BMW), SERIE3(Marca.BMW), SERIE5(Marca.BMW);

	private Marca marca;
	private static final Modelo[] VALUES = values();

	private Modelo(Marca marca) {
		this.marca = marca;
	}

	public Marca getMarca() {
		return marca;
	}

	public String toString() {
		return getMarca() + " " + name();
	}

	public static String[] generarOpcionesMenu() {
		String[] opciones = new String[VALUES.length];

		int i = 0;
		for (Modelo modelo : VALUES) {
			opciones[i] = modelo.toString();
			i++;
		}

		return opciones;
	}
}
