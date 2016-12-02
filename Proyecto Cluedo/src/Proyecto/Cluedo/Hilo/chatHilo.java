package Proyecto.Cluedo.Hilo;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.DefaultListModel;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
	
	public JEditorPane principal;
	
	private ArrayList <String> listaMensajes;
	
	private JScrollPane panelMensajes;
	
//	private JPanel panel;
	
	public chatHilo(Connection conexion,Jugador j,JLabel usuariosLinea,JEditorPane principal,JList <String> usuarios,JScrollPane panelMensajes){
		this.conexion=conexion;
		this.j=j;
		this.usuariosLinea=usuariosLinea;
		this.principal=principal;
		this.usuarios=usuarios;
		this.panelMensajes=panelMensajes;
//		this.panel=panel;
	}
	
	public void run (){
		
		while (j.isEnLinea()){
			
			listaUsuarios= new ArrayList<>();
			
			listaUsuarios=gestion.obtenerJugadoresLinea(conexion, j);
			
			DefaultListModel modelo = new DefaultListModel();
			
			for (String s: listaUsuarios){
				modelo.addElement(s);
			}
			
			usuarios.setModel(modelo);
			
			
			usuariosLinea.setText("  Usuarios en linea: "+listaUsuarios.size());
			
			usuariosLinea.revalidate();
			
			listaMensajes=gestion.obtenerChats(conexion, j.getCodigoPartida());
			
			String tabla="<html><body>";
			
			for (String s: listaMensajes){
//				StringTokenizer tokenizer= new StringTokenizer(s,":");
//				String nombreusuario=tokenizer.nextToken();
//				nombreusuario=nombreusuario.replaceAll("<br>", "");
////					System.out.println(nombreusuario);
//				if(nombreusuario.equals(j.getUsuario())){
//				
//					tabla=tabla+"<DIV ALIGN=right>"+s+"   </DIV>";
//				}else{
//				tabla=tabla+s;
//			}
				
				tabla=tabla+s;
				}
			
			tabla=tabla+"</body></html>";
			String imgsrc = chatHilo.class.getResource("Imagenes/happy.png").toString();
			tabla=tabla.replaceAll(":\\)", "<img src='" + imgsrc + "' width=30 height=30></img>");
			
			
			principal.setText(tabla);
			
			panelMensajes.getVerticalScrollBar().setValue(panelMensajes.getVerticalScrollBar().getMaximum());
			
			panelMensajes.validate();
			
//			panel.validate();
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
	}
}
