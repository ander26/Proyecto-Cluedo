package Proyecto.Cluedo.Datos;

import Proyecto.Cluedo.Interfaces.Logineable;

public class Usuario implements Logineable {
	
	/**
	 * Atributo que contiene las cartas que se le asignan
	 */
	
	private  int  [] ACartas;
	
	/**
	 * Constructor con parametros
	 * @param totCartas Parametro que contiene el total de cartas que hay en juego
	 * @param totjugadores Parametro que contiene el total de jugadores
	 */
	
	public Usuario(int totCartas,int totjugadores){
		ACartas=new int [totCartas/totjugadores];
	}

	/**
	 * Metodo que sirve para obtener las cartas
	 * @return Devuelve el array
	 */
	
	public int [] getACartas() {
		return ACartas;
	}

	/**
	 * Metodo que sirve para establecer las cartas que tiene el usuario 
	 * @param aCartas Parametro que contiene el array de cartas
	 */
	
	public void setACartas(int[] aCartas) {
		ACartas = aCartas;
	}


}
