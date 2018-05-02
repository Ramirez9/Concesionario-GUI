package concesionarioGUI;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import concesionario.*;
import concesionario.excepciones.*;
import concesionario.enumeraciones.*;

/**
 * Seleciona un color para recorrer la ArrayList de concesionario según ese color.
 * 
 * @author Francisco Ramírez
 *
 */

public class SeleccionarColor extends JDialog {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private JLabel lblColor;
	private JRadioButton radioButtonPlata;
	private JRadioButton radioButtonRojo;
	private JRadioButton radioButtonAzul;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton aceptar;
	private JButton salir;
	private MostrarColor mostrarColor;

	/**
	 * Create the dialog.
	 */
	public SeleccionarColor() {
		getContentPane().setBackground(new java.awt.Color(255, 160, 122));
		setTitle("Seleccionar color");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 373, 129);

		lblColor = new JLabel("Color");
		lblColor.setBounds(20, 11, 49, 14);

		radioButtonPlata = new JRadioButton("Plata");
		radioButtonPlata.setBackground(new java.awt.Color(255, 160, 122));
		radioButtonPlata.setBounds(100, 7, 65, 23);
		buttonGroup.add(radioButtonPlata);

		radioButtonRojo = new JRadioButton("Rojo");
		radioButtonRojo.setBackground(new java.awt.Color(255, 160, 122));
		radioButtonRojo.setBounds(167, 7, 65, 23);
		buttonGroup.add(radioButtonRojo);

		radioButtonAzul = new JRadioButton("Azul");
		radioButtonAzul.setBackground(new java.awt.Color(255, 160, 122));
		radioButtonAzul.setBounds(232, 7, 65, 23);
		buttonGroup.add(radioButtonAzul);

		aceptar = new JButton("Aceptar");
		aceptar.setBounds(172, 64, 98, 23);
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color color = getColor();
				if (color != null) {
					ArrayList<Coche> coches;
					try {
						coches = Principal.concesionario.getCocheColor(color);
						mostrarColor = new MostrarColor(coches);
						mostrarColor.setVisible(true);
					} catch (CocheNoExisteException e1) {
						JOptionPane.showMessageDialog(contentPanel, "No existe ningún coche de ese color.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				} else
					JOptionPane.showMessageDialog(contentPanel, "Debes seleccionar un color.", "Error",
							JOptionPane.ERROR_MESSAGE);
			}
		});

		salir = new JButton("Salir");
		salir.setBounds(282, 64, 77, 23);
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		getContentPane().setLayout(null);
		getContentPane().add(lblColor);
		getContentPane().add(aceptar);
		getContentPane().add(salir);
		getContentPane().add(radioButtonPlata);
		getContentPane().add(radioButtonRojo);
		getContentPane().add(radioButtonAzul);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}

	private Color getColor() {
		if (radioButtonPlata.isSelected())
			return Color.PLATA;
		else if (radioButtonRojo.isSelected())
			return Color.ROJO;
		else if (radioButtonAzul.isSelected())
			return Color.AZUL;
		else
			return null;
	}
}
