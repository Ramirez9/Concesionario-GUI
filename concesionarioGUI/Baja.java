package concesionarioGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import concesionario.excepciones.*;

/**
 * Clase Baja para dar de baja un coche del concesionario.
 * 
 * @author Francisco Ramírez Ruiz
 *
 */
public class Baja extends VentanaPadre{

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public Baja() {
		super();
		rdbtnAzul.setEnabled(false);
		rdbtnRojo.setEnabled(false);
		rdbtnPlata.setEnabled(false);
		comboBoxModelos.setEnabled(false);
		comboBoxMarca.setEnabled(false);
		setModal(true);

		contentPanel.setBorder(
				new TitledBorder(null, "Baja de coches", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		contentPanel.setLayout(null);

		anterior.setVisible(false);
		siguiente.setVisible(false);

		btnAccion.setText("Eliminar");
		btnAccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Principal.concesionario.eliminar(textField.getText());
					JOptionPane.showMessageDialog(contentPanel, "Coche eliminado correctamente", "Información",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (CocheNoExisteException | MatriculaNoValidaException e1) {
					JOptionPane.showMessageDialog(contentPanel, e1.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				dispose();
			}
		});

	}

}

