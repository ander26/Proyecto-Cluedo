package Proyecto.Cluedo.Datos;

import java.awt.Image;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Cartas {
	
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
	 * Atributo que contiene un booleano para saber si es la carta culpable
	 */
	
	protected boolean culpable;
	
	/**
	 * Atributo que contiene que tipo de carta es
	 */
	
	private int tipo;
	
	/**
	 * Atributo que nos dice si esa carta ya esta repartida para un jugador
	 */
	
	private boolean seleccionada;
	
	
	/**
	 * Constructor sin parametros
	 */
	
	public Cartas (){
		
		this.nombre="";
		this.rutaIcono="";
		this.culpable=false;
	
	}
	
	/**
	 * Constructor con parametros
	 * @param nombre Parametro que contiene el nombre de la carta
	 * @param rutaIcono Parametro que contiene la ruta del icono de la carta
	 * @param icono Parametro que contiene el label en el que se contendra la carta
	 * @param culpable Parametro que contiene si la carta es la que se busca en el juego o no 
	 */
	
	public Cartas (String nombre, String rutaIcono,boolean culpable,int tipo){
		
		this.nombre=nombre;
		this.rutaIcono=rutaIcono;		
		this.culpable=culpable;		
		this.tipo=tipo;
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

	/**
	 * Metodo que sirve para obtener el tipo de carta
	 * @return Devuelve el tipo de carta
	 */
	
	public int getTipo() {
		return tipo;
	}
	
	/**
	 * Metodo que sirve para establecer el tipo de carta
	 * @param tipo Parametro que contiene el tipo de carta
	 */

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public boolean isSeleccionada() {
		return seleccionada;
	}

	public void setSeleccionada(boolean seleccionada) {
		this.seleccionada = seleccionada;
	}

	
	
	

}
