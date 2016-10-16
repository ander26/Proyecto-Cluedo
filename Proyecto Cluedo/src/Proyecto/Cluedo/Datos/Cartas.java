package Proyecto.Cluedo.Datos;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Cartas {
	
	//Generamos las variables 
	
	/**
	 * Nombre que se le asigna al elemento de la carta
	 */
	
	protected String nombre;
	
	/**
	 * Ruta donde se encuentra el icono de la carta
	 */
	
	protected String rutaIcono;
	
	/**
	 * Atributo que contiene el label que contendra la carta  
	 */
	
	protected JLabel labelCarta;
	
	/**
	 * Atributo que contiene un booleano para saber si es la carta culpable
	 */
	
	protected boolean culpable;
	
	/**
	 * Constructor sin parametros
	 */
	
	public Cartas (){
		this.nombre="";
		this.rutaIcono="";
		this.labelCarta= new JLabel();
		this.culpable=false;
	}
	
	/**
	 * Constructor con parametros 
	 * @param nombre Parametro que contiene el nombre de la carta
	 * @param rutaIcono Parametro que contiene la ruta del icono de la carta
	 * @param icono Parametro que contiene el label en el que se contendra la carta
	 * @param culpable Parametro que contiene si la carta es la que se busca en el juego o no 
	 */
	
	public Cartas (String nombre, String rutaIcono,boolean culpable){
		this.nombre=nombre;
		this.rutaIcono=rutaIcono;
		this.labelCarta=new JLabel();
		this.culpable=culpable;
		ImageIcon a = new ImageIcon(Arma.class.getResource(this.rutaIcono));
		Icon b = new ImageIcon(
				a.getImage().getScaledInstance(labelCarta.getWidth(), labelCarta.getHeight(), Image.SCALE_DEFAULT));
		labelCarta.setIcon(b);
	}
	
	/**
	 * Metodo que sirve para obtener el nombre de la carta
	 * @return Devuelve el nombre de la carta
	 */
	
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Metodo que sirve para establecer el nombre de la carta
	 * @param nombre Parametro que contiene el nombre de la carta
	 */
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Metodo que sirve para obtener la ruta del icono
	 * @return Devuelve la ruta del icono
	 */
	
	public String getRutaIcono() {
		return rutaIcono;
	}
	
	/**
	 * Metodo que sirve para establecer la ruta del icono
	 * @param rutaIcono Parametro que contiene la ruta del icono
	 */
	
	public void setRutaIcono(String rutaIcono) {
		this.rutaIcono = rutaIcono;
	}
	
	/**
	 * Metodo que sirve para obtener el label de la carta
	 * @return Devuelve el label con el icono
	 */
	
	public JLabel getLabelCarta() {
		return labelCarta;
	}
	
	/**
	 * Metodo que sirve para establecer el icono 
	 * @param labelCarta Parametro que contiene el icono 
	 */
	
	public void setLabelCarta(JLabel labelCarta) {
		this.labelCarta = labelCarta;
	}

	/**
	 * Metodo que devuelve si una carta esta involucrada en el caso
	 * @return Devuelve true si esta involucrada
	 */
	
	public boolean isCulpable() {
		return culpable;
	}

	/**
	 * Metodo que sirve para establecer una carta como culpable
	 * @param culpable Parametro que contiene si una carta es culpable
	 */
	
	public void setCulpable(boolean culpable) {
		this.culpable = culpable;
	}
	
	
	

}
