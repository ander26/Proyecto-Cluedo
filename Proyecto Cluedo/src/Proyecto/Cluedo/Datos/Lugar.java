package Proyecto.Cluedo.Datos;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Lugar extends Cartas {

	/**
	 * Constructor sin parametros
	 */

	public Lugar() {
		super();

	}

	/**
	 * Constructor con parametros
	 * 
	 * @param nombre
	 *            Parametro que contiene el nombre del lugar
	 * @param rutaIcono
	 *            Parametro que contiene la ruta del icono
	 * @param culpable
	 *            Parametro que contiene si la carta esta involucrada
	 */

	public Lugar(String nombre, String rutaIcono, boolean culpable) {
		super(nombre, rutaIcono, culpable);

		labelCarta.setSize(95, 152);
	}

}
