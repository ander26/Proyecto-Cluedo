package Proyecto.Cluedo.Logica;

import java.util.ArrayList;

public class Jugador {
	private ArrayList<ArrayList<Integer>> MisCartas;
	private String Monigote;
	private boolean Turno;
	private int Lugar;

	

	public Jugador() {
		
		MisCartas = new ArrayList();
		Monigote = null;
		Turno=false;
		Lugar=-1;
		
	}
	public int getLugar() {
		return Lugar;
	}

	public void setLugar(int lugar) {
		Lugar = lugar;
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
	public void setCarta(int indice,int num) {
		MisCartas.get(indice).add(num);
	}
}
