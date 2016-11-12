import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.ImageIcon;

import Proyecto.Cluedo.Datos.Genero;
import Proyecto.Cluedo.Datos.Usuario;
import Proyecto.Cluedo.Logica.GestionBaseDeDatos;
import Proyecto.Cluedo.Ventanas.VentanaLogin;
import Proyecto.Cluedo.Ventanas.VentanaLogo;

public class Main {

	
	public static void main (String [] args){
		
		GestionBaseDeDatos gestion = new GestionBaseDeDatos();
		Connection conexion = gestion.inicializarLaBase();
		
		/*try{
			Statement statement = conexion.createStatement();
			statement.executeUpdate("DROP TABLE IF EXISTS PARTIDA");
		}catch (Exception e){
			
		}
		String creacion = "CREATE TABLE PARTIDA (NOMBRE text, CODIGO int NOT NULL PRIMARY KEY, NUMEROJUGADORESMAXIMO int , NUMEROJUGADORESACTUAL int,POSICIONBARCO real,MENSAJECARTEL text)";
		
		gestion.crearTabla(creacion, conexion);*/
		
		
		VentanaLogo ventana = new VentanaLogo();
		ventana.setVisible(true);
		
		
		VentanaLogin ventanaPrincipal = new VentanaLogin(conexion);
		
		while (ventanaPrincipal.isValid()){			
		}
		
		ventana.dispose();
		
		ventanaPrincipal.setVisible(true);
	}
}
