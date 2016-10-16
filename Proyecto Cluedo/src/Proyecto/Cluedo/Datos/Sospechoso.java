package Proyecto.Cluedo.Datos;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Sospechoso extends Cartas {

	/**
	 * Constructor sin parametros
	 */
	
	public Sospechoso() {
		super();
		
	}

	/**
	 * Constructor con parametros
	 * @param nombre Parametro que contiene el nombre del sospechoso
	 * @param rutaIcono Parametro que contiene la ruta del icono
	 * @param culpable Parametro que contiene si la carta esta involucrada en el caso
	 */
	
	public Sospechoso(String nombre, String rutaIcono, boolean culpable) {
		super(nombre, rutaIcono, culpable);
	
		labelCarta.setSize(95, 152);
	}
	
	
	

}
