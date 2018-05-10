package concesionarioGUI;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import concesionario.Coche;
import concesionario.enumeraciones.Marca;
import concesionario.enumeraciones.Modelo;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.Color;

/**
 * Clase Padre del concesionarioGUI
 * 
 * @author Francisco Ramírez Ruiz
 *
 */
public class VentanaPadre extends JDialog {

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Objetos del paquete swing
	 */
	 final JPanel contentPanel = new JPanel();
	 JTextField textField;
	 JLabel lblMatricula;
	 JLabel lblMarca;
	 JLabel lblModelo;
	 JButton btnAccion;
	 JButton cancelButton;
	 JButton anterior;
	 JButton siguiente;
	 JComboBox<Modelo> comboBoxModelos;
	 JComboBox<Marca> comboBoxMarca;
	 JRadioButton rdbtnPlata;
	 JRadioButton rdbtnRojo;
	 JRadioButton rdbtnAzul;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the dialog.
	 */
	public VentanaPadre() {
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 478, 345);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 127, 80));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBackground(new Color(255, 127, 80));
		panelBotones.setForeground(new Color(0, 0, 0));
		panelBotones.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Colores", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPanel.add(panelBotones);
		panelBotones.setLayout(null);
		
		rdbtnPlata = new JRadioButton("Plata");
		rdbtnPlata.setBackground(new Color(255, 127, 80));
		buttonGroup.add(rdbtnPlata);
		
		panelBotones.add(rdbtnPlata);
		
		rdbtnRojo = new JRadioButton("Rojo");
		rdbtnRojo.setBackground(new Color(255, 127, 80));
		rdbtnRojo.setForeground(Color.RED);
		buttonGroup.add(rdbtnRojo);
		panelBotones.add(rdbtnRojo);
		
		rdbtnAzul = new JRadioButton("Azul");
		rdbtnAzul.setBackground(new Color(255, 127, 80));
		rdbtnAzul.setForeground(Color.BLUE);
		buttonGroup.add(rdbtnAzul);
		panelBotones.add(rdbtnAzul);

		lblMatricula = new JLabel("Matrícula");
		contentPanel.add(lblMatricula);

		lblMarca = new JLabel("Marca");
	
		contentPanel.add(lblMarca);

		lblModelo = new JLabel("Modelo");
		contentPanel.add(lblModelo);



		btnAccion = new JButton("");
		btnAccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAccion.setHorizontalAlignment(SwingConstants.RIGHT);
		btnAccion.setSize(98, 23);
		btnAccion.setLocation(230, 272);
		contentPanel.add(btnAccion);

		cancelButton = new JButton("Salir");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		cancelButton.setSize(100, 23);
		cancelButton.setLocation(338, 272);
		cancelButton.setActionCommand("Cancel");
		contentPanel.add(cancelButton);

		anterior = new JButton("<-");
		contentPanel.add(anterior);

		siguiente = new JButton("->");
		contentPanel.add(siguiente);

		comboBoxModelos = new JComboBox<Modelo>();
		contentPanel.add(comboBoxModelos);

		comboBoxMarca = new JComboBox<Marca>();
		contentPanel.add(comboBoxMarca);

		textField = new JTextField();
		/**
		 * Controla si es una mátricula válida o no al perder su foco
		 */
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if (!Coche.esValida(textField.getText().trim().toUpperCase())) {
					textField.setText(textField.getText());
					textField.setForeground(java.awt.Color.RED);
				}

			}

			@Override
			public void focusGained(FocusEvent arg0) {
				textField.setForeground(java.awt.Color.BLACK);
			}
		});
		contentPanel.add(textField);
		textField.setColumns(10);
		
		/**
		 * Coordenadas bounds
		 */
		panelBotones.setBounds(36, 76, 321, 55);
		rdbtnPlata.setBounds(90, 25, 62, 23);
		rdbtnRojo.setBounds(154, 25, 62, 23);
		rdbtnAzul.setBounds(218, 25, 62, 23);
		lblMatricula.setBounds(67, 35, 70, 15);
		lblMarca.setBounds(67, 142, 70, 15);
		lblModelo.setBounds(67, 187, 46, 14);
		anterior.setBounds(307, 183, 50, 23);
		siguiente.setBounds(357, 183, 50, 23);
		comboBoxModelos.setBounds(129, 183, 151, 22);
		comboBoxMarca.setBounds(129, 137, 151, 24);
		textField.setBounds(129, 31, 151, 23);

	}

	protected void limpiar() {
		textField.setText("");
		buttonGroup.clearSelection();
		comboBoxMarca.setSelectedIndex(-1);
		comboBoxModelos.setSelectedIndex(-1);

	}
}
