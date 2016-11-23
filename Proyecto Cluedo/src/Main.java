import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;

import Proyecto.Cluedo.Datos.Genero;
import Proyecto.Cluedo.Datos.Partida;
import Proyecto.Cluedo.Datos.Usuario;
import Proyecto.Cluedo.Logica.GestionBaseDeDatos;
import Proyecto.Cluedo.Ventanas.VentanaLogin;
import Proyecto.Cluedo.Ventanas.VentanaLogo;

public class Main {

	
	public static void main (String [] args){
		
		GestionBaseDeDatos gestion = new GestionBaseDeDatos();
		Connection conexion = gestion.inicializarLaBase();
		
		try{
			Statement statement = conexion.createStatement();
			statement.executeUpdate("DROP TABLE IF EXISTS CHAT");
		}catch (Exception e){
			
		}
//		String creacion = "CREATE TABLE PARTIDA (NOMBRE text, CODIGO int NOT NULL PRIMARY KEY, NUMEROJUGADORESMAXIMO int , NUMEROJUGADORESACTUAL int,POSICIONBARCO real,MENSAJECARTEL text)";
//		
//		gestion.crearTabla(creacion, conexion);
//		String creacion = "CREATE TABLE JUGADOR(COD_JUG int NOT NULL PRIMARY KEY,COD_PARTIDA int NOT NULL REFERENCES PARTIDA (CODIGO) ON DELETE CASCADE,NOMBRE_USUARIO text NOT NULL REFERENCES USUARIO(NOMBREUSUARIO),POS_MUÑECO real,LUGAR INT,TURNO int,MUÑECO text,DIBUJO bytea,ENLINEA boolean)";
//		gestion.crearTabla(creacion,conexion);
		
		
//		try{
//			Statement statament = conexion.createStatement();
//			
//			statament.executeUpdate("DELETE FROM CHAT");
//			
//			System.out.println("Se ha borrado todo");
//			
//			ArrayList <Integer> lista=gestion.obtenerCodigoPartidas(conexion);
//			
//			for (Integer i: lista){
//				System.out.println(i);
//			}
//		}catch (Exception e){
//			System.out.println("No se ha conseguido borrar");
//		}
//	
		
		String creacion = "CREATE TABLE CHAT(MENSAJE text,FECHAENVIO bigint NOT NULL,CODIGOPARTIDA int NOT NULL REFERENCES PARTIDA (CODIGO) ON DELETE CASCADE, CODIGOJUGADOR int NOT NULL REFERENCES JUGADOR (COD_JUG),NOMBREUSUARIO text,PRIMARY KEY (FECHAENVIO,CODIGOPARTIDA,CODIGOJUGADOR))";
		gestion.crearTabla(creacion,conexion);
		
		
		VentanaLogo ventana = new VentanaLogo();
		ventana.setVisible(true);
		
		
		VentanaLogin ventanaPrincipal = new VentanaLogin(conexion);
		
		while (ventanaPrincipal.isValid()){			
		}
		
		ventana.dispose();
		
		ventanaPrincipal.setVisible(true);
	}
}
