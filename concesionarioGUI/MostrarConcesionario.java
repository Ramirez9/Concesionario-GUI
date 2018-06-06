package concesionarioGUI;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ListIterator;
import java.awt.event.ActionEvent;
import concesionario.Coche;
/**
 * Muestra el concesionario con ListIterator y hereda de clase padre VentanaPadre
 * @author Francisco Ramírez Ruiz
 *
 */
public class MostrarConcesionario extends VentanaPadre {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;
	protected ListIterator<Coche> iterador;
	protected Coche coche;
	protected int camino = 0;

	/**
	 * Create the dialog.
	 * @return 
	 */
	public MostrarConcesionario() {
		super();
		setTitle("Mostrar concesionario");
		iterador = Principal.concesionario.getConcesionario().listIterator();
		btnAccion.setVisible(false);

		textField.setEnabled(false);

		rdbtnPlata.setEnabled(false);
		rdbtnRojo.setEnabled(false);
		rdbtnAzul.setEnabled(false);

		comboBoxMarca.setEnabled(false);
		comboBoxModelos.setEnabled(false);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				comprobarBotones();
				siguiente();
				mostrarCoche(coche);
			}
		});
		
		accionBotones();
	}
	
	/**
	 * Siguiente coche
	 */
	protected void siguiente() {
		if (iterador.hasNext()) 
			coche = iterador.next();
		if(camino == 1)
			if(iterador.hasNext())
				coche = iterador.next();
			camino = 0;	
	}

	/**
	 * Vuelve al coche anterior
	 */
	protected void anterior() {
		if (iterador.hasPrevious()) 
			coche = iterador.previous();
		if(camino == 0)
			if(iterador.hasPrevious())
				coche = iterador.previous();
			camino = 1;
	}
	/**
	 * Comprueba los botones
	 */
	protected void comprobarBotones() {
		siguiente.setEnabled(true);
		anterior.setEnabled(true);
		if (!iterador.hasNext())
			siguiente.setEnabled(false);
		if (!iterador.hasPrevious())
			anterior.setEnabled(false);

		if (Principal.concesionario.size() == 1) {
			siguiente.setEnabled(false);
			anterior.setEnabled(false);
		}
	}
	
	/**
	 * Acción de los botones
	 */
	protected void accionBotones() {
		anterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anterior();
				mostrarCoche(coche);
				comprobarBotones();
			}
		});

		siguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				siguiente();
				mostrarCoche(coche);
				comprobarBotones();
			}
		});
	}
}
