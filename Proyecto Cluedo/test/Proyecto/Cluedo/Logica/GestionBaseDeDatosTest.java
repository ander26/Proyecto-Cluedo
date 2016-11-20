package Proyecto.Cluedo.Logica;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import Proyecto.Cluedo.Datos.Partida;
import Proyecto.Cluedo.Datos.Usuario;

public class GestionBaseDeDatosTest {
GestionBaseDeDatos gestion = new GestionBaseDeDatos();
Connection conexion=gestion.inicializarLaBase();


//Jugador j1=new Jugador();
//Jugador j2=new Jugador();
//Partida p1=new Partida(4,"partidilla",conexion);
	@Test
	public void test() {
		
		//j1.setCodigo(01);
//		j1.setLugar(0);
//		j1.setMonigote(null);
//		j1.setPosicionMuñeco(-1);
//		j1.setTurno(0);
//		j1.setCodigoPartida(1);
//		j1.setUsuario("ander");
//		j2.setCodigo(02);
//		j2.setLugar(0);
//		j2.setMonigote(null);
//		j2.setPosicionMuñeco(-1);
//		j2.setTurno(0);
//		j2.setUsuario("ander");
//		j2.setCodigoPartida(1);
		
	}
	
	@Test
	public void insertarJugadorTest (){
		
		
		gestion.insertarPartida(conexion,p1);
		gestion.insertarJugador(conexion, j1);
		gestion.insertarJugador(conexion, j2);
		assertEquals(gestion.consultaATablaJugador(conexion,null).size(), 2);
		
		
		
	}
	@Test
	public void consultaATablaHashTest(){
//		gestion.modificar(conexion, "USUARIO","PUNTUACION=2000", "NOMBREUSUARIO='ander'");
//		HashMap<String,Integer> hm=gestion.consultaATablaHash(conexion,"NOMBREUSUARIO='ander'" );		
//		assertEquals((int)hm.get("ander"), 2000);
	}
	@Test
	public void consultaATablaOrdenadoNombreUsuarioTest(){
//		ArrayList<Usuario> Usuarios=gestion.consultaATablaOrdenadoNombreUsuario(conexion);
//		for(int i=0;i<Usuarios.size();i++){
//			if(i==Usuarios.size()-1){
//				
//			}else{
//				assertEquals(Usuarios.get(i).getUsuario().compareTo(Usuarios.get(i+1).getUsuario()),-1);
//
//			}
//					}
	}
	
	@Test
	public void consultaATablaOrdenadoPuntuacionTest(){
		ArrayList<Usuario> Usuarios=gestion.consultaATablaOrdenadoNombreUsuario(conexion);
		for(int i=0;i<Usuarios.size();i++){
			if(i==Usuarios.size()-1){
				
			}else{
				assertEquals(Usuarios.get(i).getPuntuacion()>Usuarios.get(i+1).getPuntuacion(),true);

			}
					}
	}
	
	
	
	


}
