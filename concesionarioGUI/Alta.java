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
 * @author Francisco Ramírez Ruiz
 *
 */
public class Alta extends VentanaPadre{

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
			boolean bandera = false;

			public void actionPerformed(ActionEvent e) {
				try {
					Principal.concesionario.annadir(textField.getText(), (Modelo) comboBoxModelos.getSelectedItem(),
							getColor());
					JOptionPane.showMessageDialog(contentPanel, "¡Coche agreado!");
					bandera = true;
				} catch (CocheYaExisteException | MatriculaNoValidaException | ModeloNoValidoException
						| ColorNoValidoException e1) {
					JOptionPane.showMessageDialog(contentPanel, e1.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				}

				if (bandera) {
					dispose(); //La ventaja JFrame se limpia, para que no aparezca marcada una vez pulsada
					textField.setText("");
					rdbtnAzul.setSelected(false);
					rdbtnPlata.setSelected(false);
					rdbtnRojo.setSelected(false);
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
		else if (rdbtnRojo.isSelected())
			return Color.ROJO;
		else if (rdbtnAzul.isSelected())
			return Color.AZUL;
		else
			throw new ColorNoValidoException("Escoja un color");
	}
}
