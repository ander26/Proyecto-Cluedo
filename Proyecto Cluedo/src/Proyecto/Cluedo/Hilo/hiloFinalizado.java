package Proyecto.Cluedo.Hilo;

import java.sql.Connection;

import javax.swing.JOptionPane;

import Proyecto.Cluedo.Datos.Usuario;
import Proyecto.Cluedo.Logica.GestionBaseDeDatos;
import Proyecto.Cluedo.Ventanas.VentanaMenu;
import Proyecto.Cluedo.Ventanas.VentanaTablero;

public class hiloFinalizado extends Thread{

	
	
	public boolean acabado=true;
	
	public VentanaTablero ventana;
	
	private GestionBaseDeDatos gestion= new GestionBaseDeDatos();
	
	private Connection conexion;
	
	private int codigo;
	
	private Usuario u;
	
	public hiloFinalizado(Connection conexion,VentanaTablero ventana,int codigo,Usuario u){
		this.conexion=conexion;
		this.ventana=ventana;
		this.codigo=codigo;
		this.u=u;
	}
	
	public void run (){
		
		while (acabado){
			
			
			
			if (gestion.obtenerGanador(conexion, codigo)==1){
				
				ventana.dispose();
				
				JOptionPane.showMessageDialog(null, "Ha ganado "+gestion.obtenerUsuarioGanador(conexion, codigo)+"la partida", "Ganador", JOptionPane.INFORMATION_MESSAGE);
				
				VentanaMenu ventana = new VentanaMenu(conexion, u, gestion);
				
				ventana.setVisible(true);
				
			}
		}
		
	}
	
	public void acabar (){
		
		this.acabado=false;
		
	}
	
}
