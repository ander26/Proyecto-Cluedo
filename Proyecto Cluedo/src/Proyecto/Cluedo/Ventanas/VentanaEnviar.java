package Proyecto.Cluedo.Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Proyecto.Cluedo.Datos.Cartas;
import Proyecto.Cluedo.Datos.Partida;
import Proyecto.Cluedo.Logica.GestionBaseDeDatos;
import Proyecto.Cluedo.Logica.Jugador;

public class VentanaEnviar extends JFrame {
	
	private  JPanel pcsospechoso=new JPanel();
	//private static JPanel pclugar=new JPanel();
	private  JPanel pcarma=new JPanel();
	private  panelrosa pprincipal;
	//private static Propiedades prop =new Propiedades(6,8,7,2);
	private  int [] arposcartas=new int[3];
	private  JLabel labels=new JLabel();
	//private static JLabel labell=new JLabel();
	private  JLabel labela=new JLabel();
	private  JPanel paneldentropri=new JPanel();
	private JLabel lbAcusar=new JLabel();
	private JLabel lbResolver=new JLabel();
	private JPanel pbotonera=new JPanel();
	private JPanel pantesbotonera=new JPanel();
	private JPanel pcentrar=new JPanel();
	

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub		
		Jugador a =new Jugador();
		a.setLugar(2);
		//mete el fondo del lugar en el que este
		String [] aimglug=new String [8];
		aimglug[0]="Imagenes/ingenieria.jpg";
		aimglug[1]="Imagenes/comercial.jpg";
		aimglug[2]="Imagenes/capilla.JPG";
		aimglug[3]="Imagenes/centenario.jpg";
		aimglug[4]="Imagenes/letras.jpg";
		aimglug[5]="Imagenes/biblioteca.jpeg";
		aimglug[6]="Imagenes/zubiarte.jpg";
		aimglug[7]="Imagenes/zubiarte.jpg";
																		
		//JFrame f=new VentanaAcusar(aimglug[a.getLugar()]);		
		//f.setVisible(true);
	}
	

	public VentanaEnviar(GestionBaseDeDatos base,Connection conexion,Partida p,Jugador j){
		
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );		
		setSize( 1330, 730 );			
		setMinimumSize(new Dimension(900,500));		
		setResizable( true );
		ImageIcon imagefondo = new ImageIcon(ventana.class.getResource("Imagenes/cofre.jpg"));
		pprincipal=new panelrosa(imagefondo.getImage());
				
		pprincipal.setLayout(new BorderLayout());
		paneldentropri.setLayout(new BoxLayout(paneldentropri,BoxLayout.X_AXIS));
		//Añadir layout a los paneles de las cartas
		
		
		//pclugar.setLayout(new BorderLayout());
		//pclugar.setOpaque(false);
		pcarma.setLayout(new BorderLayout());
		pcarma.setOpaque(false);
		
		
		//arreglar panel
		JLabel hueco=new JLabel();
		hueco.setSize(new Dimension(80,200));
		ImageIcon vacio = new ImageIcon(ventana.class.getResource("Imagenes/vacio.png"));
		Icon iconovacio = new ImageIcon(vacio.getImage().getScaledInstance(hueco.getWidth()	, hueco.getHeight(), Image.SCALE_DEFAULT));
		hueco.setIcon(iconovacio);
		JLabel hueco2=new JLabel();
		hueco2.setSize(new Dimension(80,200));
		ImageIcon vacio2 = new ImageIcon(ventana.class.getResource("Imagenes/vacio.png"));
		Icon iconovacio2 = new ImageIcon(vacio2.getImage().getScaledInstance(hueco2.getWidth()	, hueco2.getHeight(), Image.SCALE_DEFAULT));
		hueco2.setIcon(iconovacio2);
		paneldentropri.setOpaque(false);
		//añadir los componenetes
		
		//paneldentropri.add(pcsospechoso);
		//paneldentropri.add(pclugar);
		//paneldentropri.add(pcarma);

		pcentrar.setOpaque(false);


		pcentrar.add(paneldentropri);
		pprincipal.add(pcentrar,BorderLayout.CENTER);
		pprincipal.add(hueco,BorderLayout.EAST);
		pprincipal.add(hueco2,BorderLayout.WEST);
		getContentPane().add(pprincipal);
		//meter las cartas
		meterCartas(base,conexion,p,j);
	
		
		
		
		
		
		
		
		
		
		
	}
	public void meterCartas(GestionBaseDeDatos base,Connection conexion,Partida p,Jugador j){
		ArrayList<Cartas> CartasRecibidas;
		CartasRecibidas=base.obtenerCartasEnviadas(conexion,p.getCodigo(), j.getCodigo());
		for(int i=0;i<CartasRecibidas.size();i++){
			
			
			ImageIcon imagefondo = new ImageIcon(ventana.class.getResource("Imagenes/MaskX_1.png"));			
			panelrosa pan=new panelrosa(imagefondo.getImage());
			JPanel panel=new JPanel();
			panel.setOpaque(false);
			pan.setLayout(new BorderLayout());
			pan.setOpaque(false);
			JLabel label=new JLabel();
			label.setHorizontalAlignment(0);
			ImageIcon iconocarta = new ImageIcon(VentanaEnviar.class.getResource(CartasRecibidas.get(i).getRutaIcono()));		
			label.setSize(227,283);
			Icon icono = new ImageIcon(iconocarta.getImage().getScaledInstance(label.getWidth()	, label.getHeight(), Image.SCALE_DEFAULT));
			label.setIcon(icono);
			panel.add(label);
			pan.add(panel,BorderLayout.CENTER);
			paneldentropri.add(pan);
			label.repaint();
			paneldentropri.repaint();
			
		}

		base.modificarPanel(conexion, "<html><body><br> <br> El jugador "+j.getUsuario()+"<br> ha recibido "+CartasRecibidas.size()+" cartas ", p);			

		
	}
	
	

}
