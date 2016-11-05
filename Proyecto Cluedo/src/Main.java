import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;

import Proyecto.Cluedo.Datos.Usuario;
import Proyecto.Cluedo.Logica.GestionBaseDeDatos;
import Proyecto.Cluedo.Ventanas.VentanaLogin;
import Proyecto.Cluedo.Ventanas.VentanaLogo;

public class Main {

	
	public static void main (String [] args){
		GestionBaseDeDatos gestion = new GestionBaseDeDatos();
		Connection conexion = gestion.inicializarLaBase("cluedo");
		Statement statement = gestion.crearTablaUsuario(conexion);
		Usuario u = new Usuario("Maider", "Ibarra", "maideribarra", "prueba", "M", new Date("26/09/1997"), "prueba", 2, "maideribarra@opendeusto.es",null);
		u.setConexion(new Date(System.currentTimeMillis()));
		if (gestion.insertarUsuario(statement, u)){
			
		}else{
			System.out.println("No se puede añadir maider a la tabla ");
		}
		
		VentanaLogo ventana = new VentanaLogo();
		ventana.setVisible(true);
		
		
		VentanaLogin ventanaPrincipal = new VentanaLogin(statement);
		
		while (ventanaPrincipal.isValid()){			
		}
		
		ventana.dispose();
		
		ventanaPrincipal.setVisible(true);
	}
}
