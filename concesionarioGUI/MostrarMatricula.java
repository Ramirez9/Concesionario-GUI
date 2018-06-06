package concesionarioGUI;

import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import concesionario.*;
import concesionario.excepciones.*;

/**
 * Muestra un coche según la matrícula que se haya ingresado.
 * 
 * @author Francisco Ramírez Ruiz
 *
 */
public class MostrarMatricula extends VentanaPadre {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public MostrarMatricula() {
		super();
		setTitle("Mostrar por matricula");

		btnAccion.setText("Buscar");
		anterior.setVisible(false);
		siguiente.setVisible(false);

		rdbtnPlata.setEnabled(false);
		rdbtnRojo.setEnabled(false);
		rdbtnAzul.setEnabled(false);

		comboBoxMarca.setEnabled(false);
		comboBoxModelos.setEnabled(false);

		btnAccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Coche coche;
				try {
					coche = Principal.concesionario.getCoche(textField.getText().trim().toUpperCase());
					
					mostrarCoche(coche);
					
				} catch (MatriculaNoValidaException | CocheNoExisteException  e1) {
					JOptionPane.showMessageDialog(contentPanel, "La matrícula no está registrada", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
	}
}
