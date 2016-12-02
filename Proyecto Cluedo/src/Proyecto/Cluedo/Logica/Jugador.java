package Proyecto.Cluedo.Logica;

import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.util.ArrayList;

public class Jugador {

	private ArrayList<ArrayList<String>> MisCartas;

	
	private GestionBaseDeDatos gestion = new GestionBaseDeDatos();
	
	private ArrayList<ArrayList<String>> MisCartas;
	

	private String Ficha;
	private int Lugar;
	private double PosicionMuñeco;
	private int Codigo;
	private int Turno;
	private String Usuario;
	private int CodigoPartida;

	private GestionBaseDeDatos gestion = new GestionBaseDeDatos();

	
	

	private BufferedImage dibujo;
	private boolean enLinea;


	public Jugador() {

		MisCartas = new ArrayList();
		ArrayList<String> sospechosos = new ArrayList();
		ArrayList<String> lugar = new ArrayList();
		ArrayList<String> arma = new ArrayList();
		ArrayList<String> comodin = new ArrayList();
		MisCartas.add(sospechosos);
		MisCartas.add(arma);
		MisCartas.add(lugar);
		MisCartas.add(comodin);

		this.Ficha = null;
		this.Turno = 0;
		this.Lugar = -1;
		this.PosicionMuñeco = -1;
		this.Codigo = -1;
		this.Usuario = "";
		this.CodigoPartida = -1;
		dibujo = null;

		enLinea = false;


	}

//public Jugador(String Ficha, String Usuario, int CodigoPartida,Connection conexion) {
//		
//		MisCartas = new ArrayList();
//		ArrayList<String> sospechosos=new ArrayList();
//		ArrayList<String> lugar=new ArrayList();
//		ArrayList<String> arma=new ArrayList();
//		ArrayList<String> comodin=new ArrayList();
//		MisCartas.add(sospechosos);
//		MisCartas.add(arma);
//		MisCartas.add(lugar);
//		MisCartas.add(comodin);
//		
//		
//		this.Ficha=Ficha;
//		this.Codigo=generadorCodigo(gestion.obtenerCodigoJugador(conexion));
//		this.Usuario=Usuario;
//		this.CodigoPartida=CodigoPartida;
//		MisCartas= new ArrayList<>();
//		this.Turno=0;
//		
//		this.Lugar=-1;
//		this.PosicionMuñeco=-1;
//		
//		dibujo=null;
//		
//		enLinea=false;
//		
//		
//=======

	public Jugador(String Ficha, String Usuario, int CodigoPartida, Connection conexion) {

		MisCartas = new ArrayList();
		ArrayList<String> sospechosos = new ArrayList();
		ArrayList<String> lugar = new ArrayList();
		ArrayList<String> arma = new ArrayList();
		ArrayList<String> comodin = new ArrayList();
		MisCartas.add(sospechosos);
		MisCartas.add(arma);
		MisCartas.add(lugar);
		MisCartas.add(comodin);

		this.Ficha = Ficha;
		this.Codigo = generadorCodigo(gestion.obtenerCodigoJugador(conexion));
		this.Usuario = Usuario;
		this.CodigoPartida = CodigoPartida;
		MisCartas = new ArrayList<>();
		this.Turno = 0;

		this.Lugar = -1;
		this.PosicionMuñeco = -1;

		dibujo = null;

		enLinea = false;


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

	public void setFicha(String Ficha) {
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

	public ArrayList<ArrayList<String>> getMisCartas() {
		return MisCartas;
	}

	public void setMisCartas(ArrayList<ArrayList<String>> misCartas) {
		MisCartas = misCartas;
	}


	public void setCarta(int indice, String nombre) {

		MisCartas.get(indice).add(nombre);
	}
		public BufferedImage getDibujo() {
		return dibujo;
	}
		

	public void setDibujo(BufferedImage dibujo) {
		this.dibujo = dibujo;
	}

	public int generadorCodigo(ArrayList<Integer> listaCodigos) {

		int contador = 1;

		for (Integer i : listaCodigos) {
			if (contador == i) {
				contador++;

			} else {
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


}
