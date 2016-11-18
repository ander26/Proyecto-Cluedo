package Proyecto.Cluedo.Logica;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import Proyecto.Cluedo.Datos.Partida;
import Proyecto.Cluedo.Datos.Usuario;

public class GestionBaseDeDatosTest {
Connection conexion;
GestionBaseDeDatos gestion = new GestionBaseDeDatos();

Jugador j1=new Jugador();
Jugador j2=new Jugador();
Partida p1=new Partida(4,"partidilla",conexion);
	@Test
	public void test() {
		
		conexion = gestion.inicializarLaBase();
		j1.setCodigo(01);
		j1.setLugar(0);
		j1.setMonigote(null);
		j1.setPosicionMuñeco(-1);
		j1.setTurno(0);
		j1.setCodigoPartida(1);
		j1.setUsuario("ander");
		j2.setCodigo(02);
		j2.setLugar(0);
		j2.setMonigote(null);
		j2.setPosicionMuñeco(-1);
		j2.setTurno(0);
		j2.setUsuario("ander");
		j2.setCodigoPartida(1);
		
	}
	
	@Test
	public void insertarJugadorTest (){
		gestion.insertarPartida(conexion,p1);
		gestion.insertarJugador(conexion, j1);
		gestion.insertarJugador(conexion, j2);
		assertEquals(gestion.consultaATablaJugador(conexion,null).size(), 2);
		
		
	}
	


}
