package concesionarioGUI;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.util.ArrayList;
import concesionario.*;

/**
 * Muestra el concesionario según el color seleccionado
 * 
 * @author Francisco Ramírez Ruiz
 *
 */
public class MostrarColor extends MostrarConcesionario{
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public MostrarColor(ArrayList<Coche> concesionario) {
		super();
		setTitle("Concesionario por Color");
		
		btnAccion.setVisible(false);

		textField.setEnabled(false);

		anterior.setEnabled(false);
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
}
