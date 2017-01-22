package Proyecto.Cluedo.Hilo;

import java.awt.Container;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import javax.swing.DefaultListModel;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.hamcrest.Matcher;

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
	
	private Container panel;
	
	private int contador =0;
	
	public chatHilo(Connection conexion,Jugador j,JLabel usuariosLinea,JEditorPane principal,JList <String> usuarios,JScrollPane panelMensajes,Container panel){
		this.conexion=conexion;
		this.j=j;
		this.usuariosLinea=usuariosLinea;
		this.principal=principal;
		this.usuarios=usuarios;
		this.panelMensajes=panelMensajes;
		this.panel=panel;
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
				
				System.out.println(s);
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
				Pattern patern =Pattern.compile(j.getUsuario()+": ");
				System.out.println(s);
				System.out.println(patern);
				if (patern.matcher(s).find()){
					System.out.println("SI");
					s=s.replaceAll(j.getUsuario()+":", "<font color=\"green\">"+j.getUsuario()+":");
					s=s+"</font>";
					System.out.println(s);
				}else {
					System.out.println("NO");
				}
				tabla=tabla+s+"<br>";
				}
			
			tabla=tabla+"</body></html>";
			
			String imgsrc6 = chatHilo.class.getResource("Imagenes/angry.png").toString();
			tabla=tabla.replaceAll(">:\\(", "<img src='" + imgsrc6 + "' width=30 height=30></img>");
			
			
			String imgsrc8 = chatHilo.class.getResource("Imagenes/angel.png").toString();
			tabla=tabla.replaceAll("0:\\)", "<img src='" + imgsrc8 + "' width=30 height=30></img>");
			
			
			String imgsrc9 = chatHilo.class.getResource("Imagenes/pervert.png").toString();
			tabla=tabla.replaceAll(";\\)", "<img src='" + imgsrc9 + "' width=30 height=30></img>");
			
			String imgsrc1 = chatHilo.class.getResource("Imagenes/laugh.png").toString();
			tabla=tabla.replaceAll(":\\)\\)", "<img src='" + imgsrc1 + "' width=30 height=30></img>");

			String imgsrc2 = chatHilo.class.getResource("Imagenes/happy.png").toString();
			tabla=tabla.replaceAll(":\\)", "<img src='" + imgsrc2 + "' width=30 height=30></img>");
			
			
			String imgsrc3 = chatHilo.class.getResource("Imagenes/sad.png").toString();
			tabla=tabla.replaceAll(":\\(", "<img src='" + imgsrc3 + "' width=28 height=28></img>");
			
			

			
			String imgsrc4 = chatHilo.class.getResource("Imagenes/caca.png").toString();
			tabla=tabla.replaceAll("mierda", "<img src='" + imgsrc4 + "' width=30 height=30></img>");
			
			
			String imgsrc5 = chatHilo.class.getResource("Imagenes/heart.png").toString();
			tabla=tabla.replaceAll("<3", "<img src='" + imgsrc5 + "' width=30 height=30></img>");
			

			String imgsrc7 = chatHilo.class.getResource("Imagenes/shark.png").toString();
			tabla=tabla.replaceAll("\\(\\^\\^\\^\\)", "<img src='" + imgsrc7 + "' width=30 height=30></img>");
			

			
		
			
			
			
			tabla=tabla.replaceAll("gilipollas", "INSULTO");
			
			tabla=tabla.replaceAll("puta", "INSULTO");
			
			tabla=tabla.replaceAll("zorra", "INSULTO");
			
			
			
			if (tabla.length()!=contador){
//			panelMensajes.getVerticalScrollBar().setValue(panelMensajes.getVerticalScrollBar().getMaximum());
			principal.setText(tabla);
			principal.setSelectionStart(tabla.length());
			contador=tabla.length();
			}
//			panelMensajes.getVerticalScrollBar().setValue(panelMensajes.getVerticalScrollBar().getMaximum());
			
//			panelMensajes.revalidate();
			
			panel.revalidate();
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
	}
}
