package Proyecto.Cluedo.Hilo;

import java.awt.Window;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Proyecto.Cluedo.Datos.Partida;
import Proyecto.Cluedo.Datos.Usuario;
import Proyecto.Cluedo.Logica.GestionBaseDeDatos;
import Proyecto.Cluedo.Logica.Jugador;
import Proyecto.Cluedo.Logica.Propiedades;
import Proyecto.Cluedo.Ventanas.VentanaTablero;
import Proyecto.Cluedo.Ventanas.VideoPlayer;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;

public class comprobador extends Thread {

	
	
	public GestionBaseDeDatos base;

	public Partida p;

	public Connection conexion;
	
	private Jugador j;
	
	private Usuario u;
	
	private Propiedades prop;

	public comprobador(Partida p, Connection conexion,Jugador j,Usuario u,GestionBaseDeDatos base,Propiedades prop) {
		this.p = p;
		this.conexion = conexion;
		this.j=j;
		this.u=u;
		this.base=base;
		this.prop=prop;
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
				statement.close();
				System.out.println(p.getNumeroJugadoresActual() + " " + p.getNumeroJugadoresMaximo());
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("error");
				}

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		 for (Window window : Window.getWindows()) {
			    window.dispose();
			}
		
		 int respuesta=JOptionPane.showConfirmDialog(null, "¿Desea visualizar un video introductorio?","Visualizacion del video",JOptionPane.YES_NO_OPTION);
		
		 if (respuesta==JOptionPane.YES_OPTION){
			
			// Inicializar VLC.
				// Probar con el buscador nativo...
				boolean found = new NativeDiscovery().discover();
				// System.out.println( LibVlc.INSTANCE.libvlc_get_version() ); //
				// Visualiza versiï¿½n de VLC encontrada
				// Si no se encuentra probar otras opciones:
				if (!found) {
					// Buscar vlc como variable de entorno
					String vlcPath = System.getenv().get("vlc");
					if (vlcPath == null) { // Poner VLC a mano
						System.setProperty("jna.library.path", "c:\\Program Files\\videolan\\VLC");
					} else { // Poner VLC desde la variable de entorno
						System.setProperty("jna.library.path", vlcPath);
					}
				}
			 VideoPlayer player = new VideoPlayer(conexion, j, u, base, p, prop, true); 
			player.setVisible(true);
			
			base.insertarGanador(conexion, u.getUsuario(), 0, p.getCodigo());
			
		 }else{
			 System.out.println("entro");
		 VentanaTablero tablero = new VentanaTablero(conexion,j,u,base,p,prop,true);
		 tablero.setVisible(true);
		 base.insertarGanador(conexion, u.getUsuario(), 0, p.getCodigo());
		 }
		 
	}

	public void setJ(Jugador j) {
		
		this.j = j;
	}

	public void setU(Usuario u) {
		this.u = u;
	}

	
}