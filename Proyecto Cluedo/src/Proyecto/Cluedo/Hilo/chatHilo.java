package Proyecto.Cluedo.Hilo;

import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Proyecto.Cluedo.Logica.GestionBaseDeDatos;
import Proyecto.Cluedo.Logica.Jugador;

public class chatHilo extends Thread {
	
	private GestionBaseDeDatos gestion = new GestionBaseDeDatos();
	
	private Connection conexion;

	public Jugador j;
	
	public JList <String> usuarios;
	
	public JLabel usuariosLinea;
	
	private ArrayList <String> listaUsuarios;
	
	public JTextArea principal;
	
	private ArrayList <String> listaMensajes;
	
//	private JPanel panel;
	
	public chatHilo(Connection conexion,Jugador j,JLabel usuariosLinea,JTextArea principal,JList <String> usuarios){
		this.conexion=conexion;
		this.j=j;
		this.usuariosLinea=usuariosLinea;
		this.principal=principal;
		this.usuarios=usuarios;
//		this.panel=panel;
	}
	
	public void run (){
		
		while (j.isEnLinea()){
			
			listaUsuarios=gestion.obtenerJugadoresLinea(conexion, j);
			
			DefaultListModel modelo = new DefaultListModel();
			
			for (String s: listaUsuarios){
				modelo.addElement(s);
			}
			
			usuarios.setModel(modelo);
			
			
			usuariosLinea.setText("  Usuarios en linea: "+listaUsuarios.size());
			
			listaMensajes=gestion.obtenerChats(conexion, j.getCodigoPartida());
			
			String tabla="";
			
			for (String s: listaMensajes){
				tabla=tabla+s;
			}
			
			principal.setText(tabla);
			
//			panel.validate();
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
	}
}
