package concesionarioGUI;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import concesionario.enumeraciones.*;
import concesionario.excepciones.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase Alta, añade un coche al Concesionario y hereda de VentanaPadre
 * 
 * @author Francisco Ramírez Ruiz
 *
 */
public class Alta extends VentanaPadre {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Alta() {
		super();
		btnAccion.setBounds(258, 272, 70, 23);
		setTitle("Alta de un Coche");

		btnAccion.setText("Alta");

		anterior.setVisible(false);
		siguiente.setVisible(false);

		comboBoxMarca.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent arg0) {
				comboBoxModelos.setModel(new DefaultComboBoxModel(getModelo(comboBoxMarca)));
			}
		});
		comboBoxMarca.setModel(new DefaultComboBoxModel(Marca.values()));
		comboBoxModelos.setModel(new DefaultComboBoxModel(getModelo(comboBoxMarca)));
		comboBoxMarca.setSelectedItem(null);

		btnAccion.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					Principal.concesionario.annadir(textField.getText().trim().toUpperCase(),
							(Modelo) comboBoxModelos.getSelectedItem(), getColor());
					limpiar();

				} catch (CocheYaExisteException | MatriculaNoValidaException | ModeloNoValidoException
						| ColorNoValidoException e1) {
					JOptionPane.showMessageDialog(contentPanel, e1.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
	}

	private Object[] getModelo(JComboBox<Marca> comboBoxMarca) {
		Marca marca = (Marca) comboBoxMarca.getSelectedItem();
		ArrayList<Modelo> modelos = new ArrayList<Modelo>();
		for (Modelo m : Modelo.values()) {
			if (m.getMarca() == marca)
				modelos.add(m);
		}
		return modelos.toArray();
	}

	private Color getColor() throws ColorNoValidoException {
		if (rdbtnPlata.isSelected())
			return Color.PLATA;
		if (rdbtnRojo.isSelected())
			return Color.ROJO;
		if (rdbtnAzul.isSelected())
			return Color.AZUL;

		throw new ColorNoValidoException("Escoja un color");
	}
}
