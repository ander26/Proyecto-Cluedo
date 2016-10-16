package Proyecto.Cluedo.Datos;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Arma extends Cartas {

	/**
	 * Constructor sin parametros
	 */

	public Arma() {
		super();

	}

	/**
	 * Constructor con parametros
	 * 
	 * @param nombre
	 *            Parametro que contiene el nombre del arma
	 * @param rutaIcono
	 *            Parametro que contiene la ruta del arma
	 * @param culpable
	 *            Parametro que contiene si un arma esta involucrada en el caso
	 */

	public Arma(String nombre, String rutaIcono, boolean culpable) {
		super(nombre, rutaIcono, culpable);
		
		labelCarta.setSize(95, 152);
		

	}

}
