package Proyecto.Cluedo.Datos;

import java.sql.Connection;
import java.util.ArrayList;

import Proyecto.Cluedo.Logica.GestionBaseDeDatos;

public class Partida {
	
	/**
	 * Atributo que contiene el objeto para gestionar la base de datos 
	 */
	
	private GestionBaseDeDatos gestion = new GestionBaseDeDatos();

	/**
	 * Atributo que contiene el nombre de la partida
	 */
	
	private String nombre;
	
	/**
	 * Atributo que contiene el numero de jugadores maximos 
	 */
	
	private int numeroJugadoresMaximo; 
	
	/**
	 * Atributo que contiene el numero de jugadores actuales
	 */
	
	private int numeroJugadoresActual; 
	
	/**
	 * Atributo que contiene el codigo de la partida
	 */
	
	private int codigo;
	
	/**
	 * Atributo que contiene la posicion del barco en cada partida 
	 */
	
	private double posicionBarco;
	
	/**
	 * Atributo que contiene el mensaje de 
	 */
	
	private String mensajeCartel;
	
	
	private boolean orientacion;
	
	private boolean accion;

	
	/**
	 * Constructor de partida
	 * @param numeroJugadoresMaximo Parametro que contiene el numero de jugadores maximos
	 * @param nombre Parametro que contiene el nombre de la partida 
	 */
	
	public Partida (int numeroJugadoresMaximo,String nombre,Connection conexion){
		this.nombre=nombre;
		this.numeroJugadoresMaximo=numeroJugadoresMaximo;
		this.numeroJugadoresActual=1;
		this.posicionBarco=-2000;
		this.mensajeCartel=null;
		this.codigo=generadorCodigo(gestion.obtenerCodigoPartidas(conexion));
		this.orientacion=true;
		accion=false;
	}

	
	
	public boolean isAccion() {
		return accion;
	}



	public void setAccion(boolean accion) {
		this.accion = accion;
	}



	public boolean isOrientacion() {
		return orientacion;
	}


	public void setOrientacion(boolean orientacion) {
		this.orientacion = orientacion;
	}


	public Partida (){
		
		
	}
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getNumeroJugadoresMaximo() {
		return numeroJugadoresMaximo;
	}


	public void setNumeroJugadoresMaximo(int numeroJugadoresMaximo) {
		this.numeroJugadoresMaximo = numeroJugadoresMaximo;
	}


	public int getNumeroJugadoresActual() {
		return numeroJugadoresActual;
	}


	public void setNumeroJugadoresActual(int numeroJugadoresActual) {
		this.numeroJugadoresActual = numeroJugadoresActual;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public double getPosicionBarco() {
		return posicionBarco;
	}


	public void setPosicionBarco(double posicionBarco) {
		this.posicionBarco = posicionBarco;
	}


	public String getMensajeCartel() {
		return mensajeCartel;
	}


	public void setMensajeCartel(String mensajeCartel) {
		this.mensajeCartel = mensajeCartel;
	}
	
	public int generadorCodigo (ArrayList <Integer> listaCodigos ){
		
		int contador =1;
	
		
		for (Integer i: listaCodigos){
			if (contador==i){
				contador++;
				
			}else{
				return contador;
			}
		}
		
		return contador;
	}
}
