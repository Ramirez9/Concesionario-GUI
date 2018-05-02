package concesionarioGUI;

import java.awt.EventQueue;
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
import java.awt.event.KeyEvent;
import java.io.IOException;
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
	private static final String ERROR = "ERROR";
	private static final String CONCESIONARIO_VACIO = "El concesionario está vacío";

	
	private JFrame frmConcesionario;
	static Concesionario concesionario = new Concesionario();

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConcesionario = new JFrame();
		frmConcesionario.getContentPane().setBackground(new Color(255, 160, 122));
		frmConcesionario.setTitle("Concesionario IES Gran Capit\u00E1n - Francisco Ram\u00EDrez");
		frmConcesionario.setBounds(100, 100, 450, 300);
		frmConcesionario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConcesionario.getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 127, 80));
		menuBar.setBounds(0, 0, 442, 21);
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
		mntmNuevoConcesionarioAltmaysn
				.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.ALT_MASK | InputEvent.SHIFT_MASK));
		mnArchivo.add(mntmNuevoConcesionarioAltmaysn);

		JMenuItem mntmAbrirConcesionario = new JMenuItem("Abrir concesionario...");
		mnArchivo.add(mntmAbrirConcesionario);

		JSeparator separator = new JSeparator();
		mnArchivo.add(separator);

		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmGuardar);

		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como...");
		mnArchivo.add(mntmGuardarComo);

		JSeparator separator_1 = new JSeparator();
		mnArchivo.add(separator_1);

		JMenuItem mntmSalir = new JMenuItem("Salir");
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
				Alta ventanaAlta = new Alta();
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
		JMenuItem mntmBuscarPorMatricula = new JMenuItem("Buscar por Matricula");
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
		mntmBuscarPorColor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
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