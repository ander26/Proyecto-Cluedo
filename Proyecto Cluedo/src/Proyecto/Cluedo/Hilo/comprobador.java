package Proyecto.Cluedo.Hilo;

import java.awt.Window;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Proyecto.Cluedo.Datos.Partida;
import Proyecto.Cluedo.Ventanas.VentanaTablero;

public class comprobador extends Thread {

	

	public Partida p;

	public Connection conexion;

	public comprobador(Partida p, Connection conexion) {
		this.p = p;
		this.conexion = conexion;
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
					Thread.sleep(30000);
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
		
		 VentanaTablero tablero = new VentanaTablero();
		 tablero.setVisible(true);
		
	}

}
