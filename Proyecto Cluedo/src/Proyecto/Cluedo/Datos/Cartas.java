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
	
	private TipoCarta tipo;
	
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
		this.seleccionada=false;
	
	}
	
	/**
	 * Constructor con parametros
	 * @param nombre Parametro que contiene el nombre de la carta
	 * @param rutaIcono Parametro que contiene la ruta del icono de la carta
	 * @param icono Parametro que contiene el label en el que se contendra la carta
	 * @param culpable Parametro que contiene si la carta es la que se busca en el juego o no 
	 */
	
	public Cartas (String nombre, String rutaIcono,boolean culpable,TipoCarta tipo){
		
		this.nombre=nombre;
		this.rutaIcono=rutaIcono;		
		this.culpable=culpable;		
		this.tipo=tipo;
		this.seleccionada=false;
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
	
	public int isCulpable() {
		if(this.culpable){
			return 1;
		}
		return 0;
	
	}

	/**
	 * Metodo que sirve para establecer una carta como culpable
	 * @param culpable Parametro que contiene si una carta es culpable
	 */
	
	public void setCulpable(int culpable) {
		if(culpable==1){
			this.culpable=true;
		}else{
			this.culpable = false;
			
		}
		
	}

	/**
	 * Metodo que sirve para obtener el tipo de carta
	 * @return Devuelve el tipo de carta
	 */
	
	public int getTipo() {
		if(this.tipo==TipoCarta.ARMA){
			return 0;
			
			
		}else if(this.tipo==TipoCarta.LUGAR){
		return 1;
		}else if(this.tipo==TipoCarta.SOSPECHOSO){
			return 2;
		}else if(this.tipo==TipoCarta.COMODIN){
			return 3;
		}else{
			return 4;
			
		}
		
	}
	
	/**
	 * Metodo que sirve para establecer el tipo de carta
	 * @param tipo Parametro que contiene el tipo de carta
	 */

	public void setTipo(int tipo) {
		if(tipo==0){
			this.tipo = TipoCarta.ARMA;
			
			
		}else if (tipo==1){
			this.tipo = TipoCarta.LUGAR;
		}else if(tipo==2){
			this.tipo = TipoCarta.SOSPECHOSO;
		}else if(tipo==3){
			this.tipo = TipoCarta.COMODIN;
		}
		
	}
	
	public boolean isSeleccionada() {
		return seleccionada;
	}

	public void setSeleccionada(boolean seleccionada) {
		this.seleccionada = seleccionada;
	}

	
	
	

}
