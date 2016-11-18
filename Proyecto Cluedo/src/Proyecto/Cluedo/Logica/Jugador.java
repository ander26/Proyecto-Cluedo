package Proyecto.Cluedo.Logica;

import java.util.ArrayList;

public class Jugador {
	private ArrayList<ArrayList<Integer>> MisCartas;
	private String Monigote;
	private int Lugar;
	private double PosicionMuñeco;
	private int Codigo;
	private int Turno;
	private String Usuario;
	private int CodigoPartida;

	

	public Jugador() {
		
		MisCartas = new ArrayList();
		this.Monigote = null;
		this.Turno=0;
		this.Lugar=-1;
		this.PosicionMuñeco=-1;
		this.Codigo=-1;
		this.Usuario="";
		this.CodigoPartida=-1;
		
	}
	public int getCodigoPartida() {
		return CodigoPartida;
	}
	public void setCodigoPartida(int codigoPartida) {
		CodigoPartida = codigoPartida;
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	public void setTurno(int turno) {
		Turno = turno;
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

	
	public double getPosicionMuñeco() {
		return PosicionMuñeco;
	}
	public void setPosicionMuñeco(double posicionMuñeco) {
		PosicionMuñeco = posicionMuñeco;
	}
	public int getCodigo() {
		return Codigo;
	}
	public void setCodigo(int codigo) {
		Codigo = codigo;
	}
	public int getTurno() {
		return Turno;
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
