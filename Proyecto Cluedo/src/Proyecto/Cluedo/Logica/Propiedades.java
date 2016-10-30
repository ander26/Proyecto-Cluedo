package Proyecto.Cluedo.Logica;

import java.util.ArrayList;

import Proyecto.Cluedo.Datos.Cartas;
import Proyecto.Cluedo.Datos.TipoCarta;

public class Propiedades {
	
	
	private int numTotArmas;
	private int numTotLugares;
	private int numTotSospechosos;
	private int numTotCartas;
	private int numJugadores;
	
	private ArrayList<ArrayList<Cartas>> baraja;
	
	/**
	 * Atributo que contiene el numero de cartas por usuario 
	 */
	
	private int [] [] cartasUsuario;
	
	public Propiedades(int numTotArmas, int numTotLugares, int numTotSospechosos, int numJugadores) {
		
		this.numTotArmas = numTotArmas;
		this.numTotLugares = numTotLugares;
		this.numTotSospechosos = numTotSospechosos;
		this.numTotCartas=numTotArmas+numTotLugares+numTotSospechosos;
		this.numJugadores = numJugadores;
		ArrayList<Cartas> alsospechoso=new ArrayList();
		alsospechoso.add(new Cartas ("Inspector Gadget","Imagenes/casinspecGadget.png",false,2));
		alsospechoso.add(new Cartas ("Paris Hilton", "Imagenes/casparish.png",false,2));
		alsospechoso.add(new Cartas ("Usain  Bolt", "Imagenes/casbolt.png",false,2));
		alsospechoso.add(new Cartas ("Socrates","cassocrates.png",false,2));
		alsospechoso.add(new Cartas ("Minerva", "Imagenes/casMCGONAGALL.png",false,2));
		alsospechoso.add(new Cartas ("La Momia","Imagenes/casLAmomia.png" ,false,2));
		alsospechoso.add(new Cartas ("El Papa","Imagenes/caspapa.png" ,false,2));
		ArrayList<Cartas> alarma=new ArrayList();
		alarma.add(new Cartas ("Pistola","Imagenes/carpistola.png",false,0));
		alarma.add(new Cartas ("Biblia","Imagenes/carbiblia.png",false,0));
		alarma.add(new Cartas ("Bocata envenenado","Imagenes/carbocata.png",false,0));
		alarma.add(new Cartas ("Chip","Imagenes/carchip.png",false,0));
		alarma.add(new Cartas ("Botella","Imagenes/carbotella.png",false,0));
		alarma.add(new Cartas ("Sarten","Imagenes/carpistola.png",false,0));
		ArrayList<Cartas> allugares=new ArrayList();alarma.add(new Cartas ("Pistola","Imagenes/carpistola.png",false,0));
		allugares.add(new Cartas ("F. Ingenieria","Imagenes/clINGENIERIA.png",false,1));
		allugares.add(new Cartas ("La Comercial","Imagenes/clCOMERCIAL.png",false,1));
		allugares.add(new Cartas ("la L","Imagenes/clL.png",false,1));
		allugares.add(new Cartas ("La Capilla","Imagenes/clCAPILLA.png",false,1));
		allugares.add(new Cartas ("Edificio centenario","Imagenes/clCENTENARIO.png",false,1));
		allugares.add(new Cartas ("Edificio de letras","Imagenes/clFLETRAS.png",false,1));
		allugares.add(new Cartas ("Biblioteca","Imagenes/clBIBLIOTECA.png",false,1));
		allugares.add(new Cartas ("Zubiarte","Imagenes/clZUBIARTE.png",false,1));				
		this.baraja = new ArrayList();
		this.baraja.add(alarma);
		this.baraja.add(allugares);
		this.baraja.add(alsospechoso);
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

	public ArrayList<ArrayList<Cartas>> getBaraja() {
		return baraja;
	}

	public void setBaraja(ArrayList<ArrayList<Cartas>> baraja) {
		this.baraja = baraja;
	}
	
	
	
}
