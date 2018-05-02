package concesionario;

import java.io.File;
import java.io.IOException;

import utiles.Teclado;
import concesionario.enumeraciones.Color;
import concesionario.enumeraciones.Modelo;
import concesionario.excepciones.CocheNoExisteException;
import concesionario.excepciones.CocheYaExisteException;
import concesionario.excepciones.ColorNoValidoException;
import concesionario.excepciones.MatriculaNoValidaException;
import concesionario.excepciones.ModeloNoValidoException;
import utiles.Menu;

/**
 * 
 * Queremos modelar un concesionario de coches en Java. Nos limitaremos a las
 * siguientes opciones:
 * 
 * Alta de un coche (se pedirá matricula, color y modelo), Baja de un coche (por
 * matrícula), Mostrar un coche (por matrícula), Mostrar concesionario (todos
 * los coches del concesionario), Contar el número de coches en el
 * concesionario, Mostrar coches de un color.
 * 
 * 
 * @author Francisco Ramírez
 * @version 1.0
 *
 */

public class TestConcesionarioFichero {
    static String[] opciones = { "Alta de un coche", "Baja de un coche (por matrícula)",
            "Mostrar un coche (por matrícula)", "Mostrar todos los coches",
            "Contar el número de coches del concesionario", "Mostrar coches de un color","Fichero","Salir\n" };

    static String[] opcionesFicheros = { "Nuevo", "Abrir", "Guardar", "Guardar como...", "Salir\n" };
    
    static String[] opcionesGuardar = {"Si","No"};
    
    static Menu menuGuardar = new Menu("Desea guardar los cambios?", opcionesGuardar);
    static Menu menuFicheros = new Menu("---Gestionar ficheros----", opcionesFicheros);
    static Menu menu = new Menu("\n*****CONCESIONARIO****", opciones);
    static Menu menuModelos = new Menu("\n****MARCA - MODELO****", Modelo.generarOpcionesMenu());
    static Menu menuColores = new Menu("\n*****COLOR*****", Color.generarOpcionesMenu());

    static Concesionario concesionario = new Concesionario();

    private static File file;
    private static boolean modificado;

    
    public static void main(String[] args) {
        int opcion;

        do {
            opcion = menu.gestionar();

            switch (opcion) {
            case 1:
                anadirCoche();
                break;

            case 2:
                bajaCoche();
                break;

            case 3:
                mostrarCoche();
                break;

            case 4:
                mostrarConcesionario();
                break;

            case 5:
                contarCoches();
                break;

            case 6:
                mostrarCochesPorColor();
                break;
            case 7:
                gestionarFicheros();
                break;
            case 8:
                System.out.println("Adiós!");
                break;
            }
        } while (opcion != 8);

    }


    /**
     * Muestra todos los coches del color pedido
     */
    private static void mostrarCochesPorColor() {

            System.out.println(concesionario.getColor(pedirColor()));

    }

    /**
     *La cantidad de números de coches en el concesionario
     */
    private static void contarCoches() {
        if(concesionario.isEmpty())
            System.out.println("No hay coches en el concesionario.");
        else
        System.out.println("\nHay " + concesionario.size() + " coches en el concesionario");
    }

    /**
     * Muestra todos los coches del concesionario
     */
    private static void mostrarConcesionario() {
        System.out.println(concesionario.toString());
    }

    /**
     * Busca el coche a través de la matrícula pedida por teclado
     */
    private static void mostrarCoche() {
        String matricula = Teclado.leerCadena("Introduzca una matrícula para buscar el coche: ");
        try {
            System.out.println(concesionario.getCoche(matricula));
        } catch (MatriculaNoValidaException| CocheNoExisteException e) {
            System.err.println(e.getMessage());
        
        }

    }

    /**
     * Elimina un coche del concesionario
     */
    private static void bajaCoche() {
        String matricula = Teclado.leerCadena("Introduzca una matrícula: ");
        try {

            System.out.println("\nCoche eliminado correctamente: " + concesionario.getCoche(matricula));
            concesionario.eliminar(matricula);
            setModificado(true);
        } catch (CocheNoExisteException | MatriculaNoValidaException e) {
            System.err.println(e.getMessage());
        }

    }

    /**
     * Añadimos un coche al concesionario
     */
    private static void anadirCoche() {
        String matricula = Teclado.leerCadena("Introduzca una matrícula: ");
        try {
            concesionario.annadir(matricula, pedirModelo(), pedirColor());
            setModificado(true);
            System.out.println("\nCoche añadido");
        } catch (MatriculaNoValidaException | ModeloNoValidoException | ColorNoValidoException | CocheYaExisteException e) {
            System.err.println(e.getMessage());
        }

    }
    
    private static void gestionarFicheros() {
        int opcion;

        do {
            opcion = menuFicheros.gestionar();

            switch (opcion) {
            case 1:
                nuevo();
                break;

            case 2:
                abrir();
                break;

            case 3:
                guardar();
                break;

            case 4:
                guardarComo();
                break;
                
            case 5:
                System.out.println("Adiooos...");

            }
        } while (opcion != 5);

    }

    private static void inicializar() {
        setModificado(false);
        concesionario = new Concesionario();
    }

    /**
     * Archivo nuevo
     */ 
    private static void nuevo() {
        comprobarCambios();
        inicializar();
        setFile(null);
    }
    
    /**
     * Archivo abrir
     */
    private static void abrir() {
        comprobarCambios();
        try {
            File file = new File(Teclado.leerCadena("Introduce el nombre del fichero: "));
            concesionario = Fichero.abrir(file);
            setFile(file);
        } catch (ClassNotFoundException e) {
            System.out.println("Fichero con información distinta a la esperada.");
        } catch (IOException e) {
            System.out.println("El sistema no puede abrir el fichero.");
        }
    }

    /**
     * Archivo guardar
     */
    private static void guardar() {
        if (getFile() == null)
            guardarComo();
        else {
            try {
                Fichero.escribir(getFile(), concesionario);
                setModificado(false);
                System.out.println("Fichero guardado con éxito.");
            } catch (IOException e) {
                System.out.println("El sistema no puede guardar el fichero.");
            }
        }
    }

    /**
     * Archivo guardarComo
     */
    private static void guardarComo() {
        try {
            File file = new File(Teclado.leerCadena("GuardarComo - Introduce el nombre del fichero: "));
            if (Fichero.isExists(file)) {
                char c = Teclado.leerCaracter("El fichero ya existe. ¿Desea sobreescribirlo? (s/n)");
                switch (c) {
                case 'n':
                case 'N':
                    return;
                }
            }
            Fichero.escribir(file, concesionario);
            setModificado(false);
            setFile(file);
        } catch (IOException e) {
            System.out.println("El sistema no puede guardar el fichero.");
        }
    }
    
    private static boolean comprobarCambios() {
        if (isModificado()) {
            switch (menuGuardar.gestionar()) {
            case 1: 
                guardar();
                return true;
            }
        }
        return false;
    }

    private static File getFile() {
        return file;
    }

    private static void setFile(File file) {
        TestConcesionarioFichero.file = file;
    }

    private static boolean isModificado() {
        return modificado;
    }

    private static void setModificado(boolean modificado) {
        TestConcesionarioFichero.modificado = modificado;
    }

    /**
     * Pide un color
     * 
     * @return Color deseado
     */
    private static Color pedirColor() {
        return Color.values()[menuColores.gestionar() - 1];
    }

    /**
     * Pide un modelo
     * 
     * @return Modelo deseado
     */
    private static Modelo pedirModelo() {
        return Modelo.values()[menuModelos.gestionar() - 1];
    }
}