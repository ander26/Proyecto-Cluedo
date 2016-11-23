package Proyecto.Cluedo.Logica;

import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.util.ArrayList;

public class Jugador {
	
	private GestionBaseDeDatos gestion = new GestionBaseDeDatos();
	
	private ArrayList<ArrayList<Integer>> MisCartas;
	
	private String Ficha;
	
	private int Lugar;
	
	private double PosicionMuñeco;
	
	private int Codigo;
	
	private int Turno;
	
	private String Usuario;
	
	private int CodigoPartida;

	private BufferedImage dibujo;
	
	private boolean enLinea;
	

	public Jugador() {
	
		
	}
	
	public Jugador (String Ficha, String Usuario, int CodigoPartida,Connection conexion){
		
		this.Ficha=Ficha;
		this.Codigo=generadorCodigo(gestion.obtenerCodigoJugador(conexion));
		this.Usuario=Usuario;
		this.CodigoPartida=CodigoPartida;
		MisCartas= new ArrayList<>();
		this.Turno=0;
		
		this.Lugar=-1;
		this.PosicionMuñeco=-1;
		
		dibujo=null;
		
		enLinea=false;
		
		
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

	public String getFicha() {
		return Ficha;
	}

	public void setMonigote(String Ficha) {
		this.Ficha = Ficha;
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

	public BufferedImage getDibujo() {
		return dibujo;
	}

	public void setDibujo(BufferedImage dibujo) {
		this.dibujo = dibujo;
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

	public boolean isEnLinea() {
		return enLinea;
	}

	public void setEnLinea(boolean enLinea) {
		this.enLinea = enLinea;
	}

	public void setFicha(String ficha) {
		Ficha = ficha;
	}
	
	
}
