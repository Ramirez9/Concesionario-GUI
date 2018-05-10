package concesionario;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Fichero implements Serializable{
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;
	
	public static File file;

	/**
	 * Método para abrir un concesionario existente
	 * 
	 * @param file
	 *            Representa el fichero a abrir
	 * @return Concesionario existente
	 * @throws ClassNotFoundException 
	 * @throws IOException
	 */
	public static Concesionario abrir(File file) throws  IOException, ClassNotFoundException
	{
		file = comprobarExtension(file);
		try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
			return (Concesionario) in.readObject();
		}
	}
	
	/**
	 * Método para guardar un concesionario
	 * 
	 * @param file
	 *            Representa el fichero a guardar
	 * @param concesionario
	 *            Representa el concesionario a guardar
	 * @throws IOException
	 */
	public static void escribir(File file, Concesionario concesionario) throws IOException {
		file = comprobarExtension(file);
		try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
			out.writeObject(concesionario);
		}
	}
	
	/**
	 * Comprueba si el fichero existe
	 * 
	 * @param file
	 *            Representa el fichero a comprobar
	 * @return true si el fichero existe, false en otro caso
	 */
	public static boolean isExists(File file) {
		file = comprobarExtension(file);
		return file.exists();
	}
	
	/**
	 * Comprueba si la extensión del fichero es válida o no
	 * 
	 * @param file
	 *            Representa el fichero a comprobar
	 * @return Fichero con la extensión válida
	 */
	private static File comprobarExtension(File file) {
	    String path = file.getPath();
	    if (!path.endsWith(".obj"))
	      return new File(path + ".obj");
	    return new File(path);
	  }
	
	public static File getFile() {
        return file;
    }

    public static void setFile(File file) {
        Fichero.file = file;
    }

}
