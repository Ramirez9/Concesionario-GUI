package concesionarioGUI;

import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import concesionario.Concesionario;
import concesionario.Fichero;
import java.awt.event.KeyEvent;
import java.net.URISyntaxException;
import java.awt.event.InputEvent;
import java.awt.Color;

/**
 * Clase principal del concesionario de coches con un Menu sobre Fichero, alta,
 * bajas, mostrar y ayudas.
 * 
 * @author Francisco Ramírez
 *
 */

public class Principal extends JFrame {

	

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;

	private static final String INFORMACION = "Información";
	private static final String GUARDADO_EL_CONCESIONARIO = "Se ha guardado el concesionario";
	private static final String FALLO_AL_GUARDAR = "Fallo al guardar";
	private static final String ERROR = "ERROR";
	private static final String CONCESIONARIO_VACIO = "El concesionario está vacío";

	private JFrame frmConcesionario;
	static Concesionario concesionario = new Concesionario();

	/**
	 * File chooser
	 */
	static JFileChooser fileChooser = new JFileChooser();

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConcesionario = new JFrame();
		frmConcesionario.setResizable(false);
		frmConcesionario.getContentPane().setBackground(new Color(255, 160, 122));
		actualizarTituloVentana();
		frmConcesionario.setBounds(100, 100, 530, 300);
		frmConcesionario.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmConcesionario.getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 127, 80));
		menuBar.setBounds(0, 0, 1200, 21);
		frmConcesionario.getContentPane().add(menuBar);

		botonArchivo(menuBar);
		botonCoche(menuBar);
		botonBuscar(menuBar);
		botonVer(menuBar);

	}

	/**
	 * Botón archivo del menú
	 * 
	 * @param menuBar
	 */
	private void botonArchivo(JMenuBar menuBar) {
		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setBackground(new Color(255, 160, 122));
		mnArchivo.setMnemonic('A');
		menuBar.add(mnArchivo);

		JMenuItem mntmNuevoConcesionarioAltmaysn = new JMenuItem("Nuevo concesionario");
		mntmNuevoConcesionarioAltmaysn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Nuevo fichero
				nuevo();
			}
		});
		mntmNuevoConcesionarioAltmaysn
				.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.ALT_MASK | InputEvent.SHIFT_MASK));
		mnArchivo.add(mntmNuevoConcesionarioAltmaysn);

		JMenuItem mntmAbrirConcesionario = new JMenuItem("Abrir concesionario...");
		mntmAbrirConcesionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Abre ficheros
				abrir();
			}

		});
		mnArchivo.add(mntmAbrirConcesionario);

		JSeparator separator = new JSeparator();
		mnArchivo.add(separator);

		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Guarda el concesionario
				guardar();
			}
		});

		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmGuardar);

		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como...");
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// GuardarComo el concesionario
				guardarComo();
			}
		});
		mnArchivo.add(mntmGuardarComo);

		JSeparator separator_1 = new JSeparator();
		mnArchivo.add(separator_1);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}	
		});
		mnArchivo.add(mntmSalir);
	}

	/**
	 * Botón coche del menú
	 * 
	 * @param menuBar
	 */
	private void botonCoche(JMenuBar menuBar) {
		JMenu mnCoche = new JMenu("Coche");
		mnCoche.setBackground(new Color(255, 160, 122));
		mnCoche.setMnemonic('C');
		menuBar.add(mnCoche);

		/**
		 * Alta
		 */
		JMenuItem mntmAlta = new JMenuItem("Alta");
		mntmAlta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mntmAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPadre ventanaAlta = new Alta();
				ventanaAlta.setVisible(true);
			}
		});
		mnCoche.add(mntmAlta);

		/**
		 * Baja
		 */
		JMenuItem mntmBaja = new JMenuItem("Baja");
		mntmBaja.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
		mntmBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (concesionario.isEmpty()) {
					JOptionPane.showMessageDialog(mntmBaja, CONCESIONARIO_VACIO, ERROR, JOptionPane.ERROR_MESSAGE);
				} else {
					Baja ventanaBaja = new Baja();
					ventanaBaja.setVisible(true);
				}
			}
		});
		mnCoche.add(mntmBaja);

		/**
		 * Mostrar Concesionario
		 */
		JMenuItem mntmMostrarConcesionario = new JMenuItem("Mostrar Concesionario");
		mntmMostrarConcesionario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
		mntmMostrarConcesionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (concesionario.isEmpty()) {
					JOptionPane.showMessageDialog(mntmBaja, CONCESIONARIO_VACIO, ERROR, JOptionPane.ERROR_MESSAGE);
				} else {
					MostrarConcesionario ventanaMostrarConcesionario = new MostrarConcesionario();
					ventanaMostrarConcesionario.setVisible(true);
				}

			}
		});
		mnCoche.add(mntmMostrarConcesionario);
	}

	/**
	 * Botón Buscar del menú
	 * 
	 * @param menuBar
	 */
	private void botonBuscar(JMenuBar menuBar) {
		JMenu mnBuscar = new JMenu("Buscar");
		mnBuscar.setBackground(new Color(255, 160, 122));
		mnBuscar.setMnemonic('B');
		menuBar.add(mnBuscar);

		/**
		 * Muestra Coche por matrícula
		 */
		JMenuItem mntmBuscarPorMatricula = new JMenuItem("Buscar Por Matricula");
		mntmBuscarPorMatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (concesionario.isEmpty()) {
					JOptionPane.showMessageDialog(mntmBuscarPorMatricula, CONCESIONARIO_VACIO, ERROR,
							JOptionPane.ERROR_MESSAGE);
				} else {
					MostrarMatricula mostrarMatricula = new MostrarMatricula();
					mostrarMatricula.setVisible(true);
				}
			}
		});
		mntmBuscarPorMatricula.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK));
		mnBuscar.add(mntmBuscarPorMatricula);

		/**
		 * Muestra Coche por color
		 */
		JMenuItem mntmBuscarPorColor = new JMenuItem("Buscar Por Color");
		mntmBuscarPorColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (concesionario.isEmpty()) {
					JOptionPane.showMessageDialog(mntmBuscarPorColor, CONCESIONARIO_VACIO, ERROR,
							JOptionPane.ERROR_MESSAGE);
				} else {
					SeleccionarColor seleccionarColor = new SeleccionarColor();
					seleccionarColor.setVisible(true);
				}
			}
		});
		mntmBuscarPorColor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_MASK));
		mnBuscar.add(mntmBuscarPorColor);

	}

	/**
	 * Botón ver del menú
	 * 
	 * @param menuBar
	 */
	private void botonVer(JMenuBar menuBar) {
		JMenu mnVer = new JMenu("Ver");
		mnVer.setBackground(new Color(255, 160, 122));
		mnVer.setMnemonic('V');
		menuBar.add(mnVer);

		/**
		 * Abre en el navegador una página web
		 */
		JMenuItem mntmGithub = new JMenuItem("GitHub");
		mntmGithub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (java.awt.Desktop.isDesktopSupported()) {
					java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

					if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
						try {
							java.net.URI uri = new java.net.URI("https://github.com/Ramirez9");
							desktop.browse(uri);
						} catch (URISyntaxException | IOException ex) {
						}
					}
				}

			}
		});

		JMenuItem mntmAcercaDe = new JMenuItem("Acerca De");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcercaDe acercaDe = new AcercaDe();
				acercaDe.setVisible(true);
			}
		});
		mnVer.add(mntmAcercaDe);

		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ayuda ayuda = new Ayuda();
				ayuda.setVisible(true);
			}
		});
		mnVer.add(mntmAyuda);
		mnVer.add(mntmGithub);

	}
	// ------------------------------FICHERO------------------------------------------

	/**
	 * Abre el fileChooser para seleccionar un archivo
	 * 
	 * @param mntmAbrirConcesionario
	 */
	private void abrir() {
		if (!comprobarCambios()) {
			fileChooser.showOpenDialog(this);
			File file = fileChooser.getSelectedFile();
			if (file != null) {
				try {
					concesionario = Fichero.abrir(file);
					Fichero.setFile(file);
					actualizarTituloVentana();
				} catch (ClassNotFoundException | IOException e1) {
					JOptionPane.showMessageDialog(null, "No es un archivo de concesionario", ERROR,
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	/**
	 * Guarda el archivo
	 * 
	 * @param mntmGuardar
	 * @param mntmGuardarComo
	 */
	private void guardar() {
		if (Fichero.getFile() == null)
			guardarComo();
		else {
			try {
				Fichero.escribir(Fichero.getFile(), concesionario);
				Concesionario.setModificado(false);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "No se ha podido guardar el concesionario", ERROR,
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * GuardaComo el archivo
	 * 
	 * @param mntmGuardarComo
	 */
	private void guardarComo() {
		fileChooser.showSaveDialog(this);
		File file = fileChooser.getSelectedFile();
		if (file == null) {
			JOptionPane.showMessageDialog(null, FALLO_AL_GUARDAR, ERROR, JOptionPane.ERROR_MESSAGE);
		} else {

			try {
				Fichero.escribir(file, concesionario);
				Fichero.setFile(file);
				Concesionario.setModificado(false);
				actualizarTituloVentana();
				JOptionPane.showMessageDialog(null, GUARDADO_EL_CONCESIONARIO, INFORMACION,
						JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, FALLO_AL_GUARDAR, ERROR, JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	/**
	 * Actualiza el titulo del programa.
	 */
	private void actualizarTituloVentana() {
		frmConcesionario.setTitle(generarTitulo());

	}

	/**
	 * Genera un título dependiendo del archivo.
	 * 
	 * @return
	 */
	private String generarTitulo() {
		if (Fichero.getFile() == null)
			return "Concesionario Francisco: Sin título";
		return "Concesionario Francisco: " + Fichero.getFile()
					//getName para obtener solo el nombre del fichero
					//getAbsolutePath, muestra la ruta
							.getName();
	}

	/**
	 * Comprueba si está modificado
	 * 
	 * @param mntmGuardar
	 * @return
	 */
	private boolean comprobarCambios() {
		if (Concesionario.isModificado()) {
			switch (JOptionPane.showConfirmDialog(null, "¿Desea guardar los cambios hechos a " + generarTitulo() + "?",
					"Concesionario - Confirmación", JOptionPane.YES_NO_CANCEL_OPTION)) {
			case JOptionPane.YES_OPTION:
				guardar();
				break;
			case JOptionPane.NO_OPTION:
				break;
			default:
				return true;
			}
		}
		return false;

	}

	/**
	 * Inicializa el concesionario
	 */
	private static void inicializar() {
		Concesionario.setModificado(false);
		concesionario = new Concesionario();
	}

	/**
	 * Archivo nuevo
	 */
	private void nuevo() {
		if (!comprobarCambios()) {
			inicializar();
			Fichero.setFile(null);
			actualizarTituloVentana();
		}
	}
	/**
	 * Sale del programa
	 */
	private void salir() {
		if (!comprobarCambios()) {
			System.exit(0);
		}
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmConcesionario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}