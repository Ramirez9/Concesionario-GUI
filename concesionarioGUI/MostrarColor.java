package concesionarioGUI;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.ListIterator;
import concesionario.*;

/**
 * Muestra el concesionario según el color seleccionado
 * 
 * @author Francisco Ramírez Ruiz
 *
 */
public class MostrarColor extends VentanaPadre{
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<Coche> concesionario;
	private ListIterator<Coche> iterador;
	private Coche copia;

	/**
	 * Create the dialog.
	 */
	public MostrarColor(ArrayList<Coche> concesionario) {
		super();
		setTitle("¡Coche por su color!");
		this.concesionario = concesionario;

		iterador = concesionario.listIterator();

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
		if (concesionario.size() == 1) {
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
		comboBoxMarca.removeAllItems();
		comboBoxMarca.addItem(coche.getModelo().getMarca());
		comboBoxModelos.removeAllItems();
		comboBoxModelos.addItem(coche.getModelo());
	}

	private void comprobarBotones() {
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
