package Proyecto.Cluedo.Logica;

import java.util.ArrayList;

public class Jugador {
	private ArrayList<ArrayList<Integer>> MisCartas;
	private String Monigote;
	private boolean Turno;

	public Jugador() {
		
		MisCartas = null;
		Monigote = null;
		Turno=false;
		
	}

	public String getMonigote() {
		return Monigote;
	}

	public void setMonigote(String monigote) {
		Monigote = monigote;
	}

	public boolean isTurno() {
		return Turno;
	}

	public void setTurno(boolean turno) {
		Turno = turno;
	}

	public ArrayList<ArrayList<Integer>> getMisCartas() {
		return MisCartas;
	}

	public void setMisCartas(ArrayList<ArrayList<Integer>> misCartas) {
		MisCartas = misCartas;
	}
}
