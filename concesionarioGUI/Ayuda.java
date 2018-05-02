package concesionarioGUI;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
/**
 * Clase Ayuda con textos para indicar al usuario una pequeña guía sobre el programa
 * 
 * @author Francisco Ramírez
 *
 */
public class Ayuda extends JDialog {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public Ayuda() {
		getContentPane().setBackground(new Color(255, 160, 122));
		setTitle("Gu\u00EDa - Concesionario");
		setResizable(false);
		setBounds(100, 100, 609, 384);
		getContentPane().setLayout(null);{
			
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 160, 122));
			buttonPane.setBounds(0, 307, 607, 35);
			getContentPane().add(buttonPane);{
				
				JButton okButton = new JButton("Aceptar");
				okButton.setBounds(509, 11, 88, 23);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				buttonPane.setLayout(null);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}

		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(255, 160, 122));
		panel1.setBounds(12, 31, 583, 91);
		panel1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Alta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(panel1);
		panel1.setLayout(null);

		JLabel labelAnadir = new JLabel();
		labelAnadir.setBackground(new Color(0, 0, 0));
		labelAnadir.setBounds(12, 12, 516, 70);

		labelAnadir.setText(
				"<html> <body> <p>Normas: </p><br/> <p>1.La matr\u00EDcula:  4 digitos,3 letras sin vocales y may\u00FAsculas. Ejemplo: 1234-PPT</p> <p>2.Debe de seleccionar el resto de opciones.</p> </body> </html>");
		panel1.add(labelAnadir);{
			JPanel panel2 = new JPanel();
			panel2.setBackground(new Color(255, 160, 122));
			panel2.setBounds(12, 145, 583, 42);
			panel2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Baja", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			getContentPane().add(panel2);
			panel2.setLayout(null);{
				
				JLabel labelBaja = new JLabel();
				labelBaja.setBackground(new Color(0, 0, 0));
				labelBaja.setBounds(10, 11, 559, 45);
				labelBaja.setText(
						"<html>\r\n<body>\r\n<p>Introduzca una matr\u00EDcula correcta para poder eliminar..</p><br/>\r\n</body>\r\n</html>");
				panel2.add(labelBaja);
			}
			{
				JPanel panel3 = new JPanel();
				panel3.setBackground(new Color(255, 160, 122));
				panel3.setBounds(12, 205, 583, 91);
				panel3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Buscar", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
				getContentPane().add(panel3);
				panel3.setLayout(null);{
					
					JLabel labelBuscar = new JLabel();
					labelBuscar.setForeground(new Color(0, 0, 0));
					labelBuscar.setBounds(10, 13, 559, 67);
					labelBuscar.setText(
							"<html>\r\n<body>\r\n<p>Dos formas de buscar un coche</p><br/>\r\n<p>1.Por la matr\u00EDcula.</p>\r\n<p>2.Por el color.</p>\r\n</body>\r\n</html>");
					panel3.add(labelBuscar);
				}
			}
			{
				JLabel label2 = new JLabel();
				label2.setBounds(135, 0, 70, 15);

			}
		}
	}
}
