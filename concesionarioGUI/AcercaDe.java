package concesionarioGUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;

/**
 * Clase AcercaDe, Indica el creador del programa.
 * 
 * @author Francisco Ramírez
 *
 */
public class AcercaDe extends JDialog {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public AcercaDe() {
		setTitle("Autor: Francisco Ram\u00EDrez");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 391, 141);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(new Color(255, 160, 122));
		contentPanel.setBackground(new Color(255, 160, 122));
		contentPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Autor", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblConcesionario = new JLabel("Concesionario 2.0");
		lblConcesionario.setBounds(124, 11, 171, 15);
		contentPanel.add(lblConcesionario);

		JLabel lblCreado = new JLabel("Francisco Ram\u00EDrez Ruiz");
		lblCreado.setBounds(102, 43, 310, 15);
		contentPanel.add(lblCreado);{
			
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 160, 122));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);{
				
				JButton okButton = new JButton("Aceptar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}