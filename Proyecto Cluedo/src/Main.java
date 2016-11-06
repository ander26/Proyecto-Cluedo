import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import Proyecto.Cluedo.Datos.Genero;
import Proyecto.Cluedo.Datos.Usuario;
import Proyecto.Cluedo.Logica.GestionBaseDeDatos;
import Proyecto.Cluedo.Ventanas.VentanaLogin;
import Proyecto.Cluedo.Ventanas.VentanaLogo;

public class Main {

	
	public static void main (String [] args){
		
		GestionBaseDeDatos gestion = new GestionBaseDeDatos();
		Connection conexion = gestion.inicializarLaBase("cluedo");
		
		VentanaLogo ventana = new VentanaLogo();
		ventana.setVisible(true);
		
		
		VentanaLogin ventanaPrincipal = new VentanaLogin(conexion);
		
		while (ventanaPrincipal.isValid()){			
		}
		
		ventana.dispose();
		
		ventanaPrincipal.setVisible(true);
	}
}
