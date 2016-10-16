package Proyecto.Cluedo.Datos;

import Proyecto.Cluedo.Interfaces.Logineable;

public class Usuario implements Logineable {
	private  Cartas [] ACartas;
	
	public Usuario(int totCartas,int totjugadores){
		ACartas=new Cartas[totCartas/totjugadores];
	}

	public Cartas[] getACartas() {
		return ACartas;
	}

	public void setACartas(Cartas[] aCartas) {
		ACartas = aCartas;
	}


}
