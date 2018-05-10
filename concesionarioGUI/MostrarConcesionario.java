package concesionarioGUI;

import java.awt.event.ActionListener;
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
	private ListIterator<Coche> iterador;
	private Coche copia;

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

		anterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarAnterior();
			}
		});

		siguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarSiguiente();
			}
		});
		actualizar();

	}

	void actualizar() {
		if (Principal.concesionario.size() == 1) {
			siguiente.setEnabled(false);
			anterior.setEnabled(false);
		} else {
			siguiente.setEnabled(true);
			anterior.setEnabled(false);
		}
		copia = iterador.next();
		
		mostrarCoche(copia);
	}

	private void mostrarSiguiente() {
		if (iterador.hasNext()) {
			copia = iterador.next();
			mostrarCoche(copia);
			comprobarBotones();
			if (!iterador.hasNext()) {
				iterador.previous();
			}
			
		}
	}

	private void mostrarAnterior() {
		if (iterador.hasPrevious()) {
			copia = iterador.previous();
			mostrarCoche(copia);
			comprobarBotones();
		}
		
		if (!iterador.hasPrevious()) {
			iterador.next();
		}
	}
	/**
	 * Muestra el coche según sus características
	 * @param coche
	 */
	private void mostrarCoche(Coche coche) {
		textField.setText(coche.getMatricula());
		switch (coche.getColor()) {
		case PLATA:
			rdbtnPlata.setSelected(true);
			break;
		case ROJO:
			rdbtnRojo.setSelected(true);
			break;
		case AZUL:
			rdbtnAzul.setSelected(true);
		}
		comboBoxMarca.addItem(coche.getModelo().getMarca());
		comboBoxMarca.setSelectedItem(coche.getModelo().getMarca());
		comboBoxModelos.addItem(coche.getModelo());
		comboBoxModelos.setSelectedItem(coche.getModelo());
	}
	/**
	 * Comprueba la posición de la ArrayList para mostrar o no el/los botones
	 */
	void comprobarBotones() {
		if (!iterador.hasNext()) {
			siguiente.setEnabled(false);
		} else {
			siguiente.setEnabled(true);
		}
		if (!iterador.hasPrevious()) {
			anterior.setEnabled(false);
		} else {
			anterior.setEnabled(true);
		}
	}
}
