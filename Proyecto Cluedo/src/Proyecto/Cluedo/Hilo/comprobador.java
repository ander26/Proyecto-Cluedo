package Proyecto.Cluedo.Hilo;

import java.awt.Window;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Proyecto.Cluedo.Datos.Partida;
import Proyecto.Cluedo.Datos.Usuario;
import Proyecto.Cluedo.Logica.GestionBaseDeDatos;
import Proyecto.Cluedo.Logica.Jugador;
import Proyecto.Cluedo.Ventanas.VentanaTablero;

public class comprobador extends Thread {

	
	public GestionBaseDeDatos base;
	public Partida p;

	public Connection conexion;
	
	private Jugador j;
	
	private Usuario u;

	public comprobador(Partida p, Connection conexion,Jugador j,Usuario u) {
		this.p = p;
		this.conexion = conexion;
		this.j=j;
		this.u=u;
	}

	public void run() {

		String sql = "SELECT NUMEROJUGADORESMAXIMO,NUMEROJUGADORESACTUAL FROM PARTIDA WHERE CODIGO=" + p.getCodigo();

		while (p.getNumeroJugadoresActual() < p.getNumeroJugadoresMaximo()) {
			Statement statement;
			try {
				statement = conexion.createStatement();

				ResultSet rs = statement.executeQuery(sql);

				while (rs.next()) {
					p.setNumeroJugadoresActual(rs.getInt("NUMEROJUGADORESACTUAL"));
					p.setNumeroJugadoresMaximo(rs.getInt("NUMEROJUGADORESMAXIMO"));
				}
				System.out.println(p.getNumeroJugadoresActual() + " " + p.getNumeroJugadoresMaximo());
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		 for (Window window : Window.getWindows()) {
			    window.dispose();
			}
		
		 VentanaTablero tablero = new VentanaTablero(conexion,j,u,base,p);
		 tablero.setVisible(true);
		
	}

	public void setJ(Jugador j) {
		this.j = j;
	}

	public void setU(Usuario u) {
		this.u = u;
	}

	
}