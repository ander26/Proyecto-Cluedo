package Proyecto.Cluedo.Hilo;

import java.awt.Window;
import java.sql.Connection;

import javax.swing.JOptionPane;

import Proyecto.Cluedo.Datos.Usuario;
import Proyecto.Cluedo.Logica.GestionBaseDeDatos;
import Proyecto.Cluedo.Ventanas.VentanaAcusar;
import Proyecto.Cluedo.Ventanas.VentanaMenu;
import Proyecto.Cluedo.Ventanas.VentanaTablero;

public class hiloFinalizado extends Thread {

	public boolean acabado = true;

	
	

	private GestionBaseDeDatos gestion = new GestionBaseDeDatos();

	private Connection conexion;

	private int codigo;

	

	public hiloFinalizado(Connection conexion, int codigo) {
		this.conexion = conexion;
		
		this.codigo = codigo;
		
		
	}

	public void run() {

		while (acabado) {

			if (gestion.obtenerGanador(conexion, codigo) == 1) {

				for (Window window : Window.getWindows()) {
				    window.dispose();
				}
		        

				JOptionPane.showMessageDialog(null,
						"Ha ganado " + gestion.obtenerUsuarioGanador(conexion, codigo) + " la partida", "Ganador",
						JOptionPane.INFORMATION_MESSAGE);

			}
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println("Se ha producido un error con la espera");
			}
		}

		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("Se ha producido un error con la espera");
		}

		gestion.borrarGanador(conexion, codigo);

	}

	public void acabar() {

		this.acabado = false;

	}

}
