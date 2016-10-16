package Proyecto.Cluedo.Logica;

import Proyecto.Cluedo.Datos.Cartas;

public class Propiedades {
	private int numTotArmas;
	private int numTotLugares;
	private int numTotSospechosos;
	private int numTotCartas;
	private int numJugadores;
	private  Cartas [][] baraja;
	
	public Propiedades(int numTotArmas, int numTotLugares, int numTotSospechosos, int numJugadores) {
		
		this.numTotArmas = numTotArmas;
		this.numTotLugares = numTotLugares;
		this.numTotSospechosos = numTotSospechosos;
		this.numTotCartas=numTotArmas+numTotLugares+numTotSospechosos;
		this.numJugadores = numJugadores;
		this.baraja = new Cartas[3][numTotSospechosos];///Igual es un arraylist
	}

	public int getNumTotArmas() {
		return numTotArmas;
	}

	public void setNumTotArmas(int numTotArmas) {
		this.numTotArmas = numTotArmas;
	}

	public int getNumTotLugares() {
		return numTotLugares;
	}

	public void setNumTotLugares(int numTotLugares) {
		this.numTotLugares = numTotLugares;
	}

	public int getNumTotSospechosos() {
		return numTotSospechosos;
	}

	public void setNumTotSospechosos(int numTotSospechosos) {
		this.numTotSospechosos = numTotSospechosos;
	}

	public int getNumTotCartas() {
		return numTotCartas;
	}

	public void setNumTotCartas(int numTotCartas) {
		this.numTotCartas = numTotCartas;
	}

	public int getNumJugadores() {
		return numJugadores;
	}

	public void setNumJugadores(int numJugadores) {
		this.numJugadores = numJugadores;
	}

	public Cartas[][] getBaraja() {
		return baraja;
	}

	public void setBaraja(Cartas[][] baraja) {
		this.baraja = baraja;
	}
	
	
	
}
