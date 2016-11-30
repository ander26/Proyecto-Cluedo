package Proyecto.Cluedo.Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import Proyecto.Cluedo.Datos.Partida;
import Proyecto.Cluedo.Logica.GestionBaseDeDatos;
import Proyecto.Cluedo.Logica.Jugador;
import Proyecto.Cluedo.Logica.Propiedades;

public class VentanaCartas extends JFrame{
	private JTabbedPane ptabbed=new JTabbedPane();
	private JPanel pprincipal=new JPanel();
	private panelrosa psospechosos;
	private JPanel pdsospechosos=new JPanel();
	private panelrosa parmas;
	private JPanel pdarmas=new JPanel();
	private panelrosa plugares;
	private JPanel pdlugares=new JPanel();
	private JPanel pcomodines=new JPanel();
	private JLabel lenviar;

	public VentanaCartas(GestionBaseDeDatos base,Jugador j,Partida p,Connection con){
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );		
		setSize( 1330, 730 );	
		
		setMinimumSize(new Dimension(900,500));		
		setResizable( true );
		//Poner fondo a los paneles
		ImageIcon imagearma = new ImageIcon(ventana.class.getResource("Imagenes/claustro.jpg"));
		parmas=new panelrosa(imagearma.getImage());
		ImageIcon imagelugares = new ImageIcon(ventana.class.getResource("Imagenes/violencia.png"));
		plugares=new panelrosa(imagelugares.getImage());
		ImageIcon imagesospechosos = new ImageIcon(ventana.class.getResource("Imagenes/asesino.jpg"));
		psospechosos=new panelrosa(imagesospechosos.getImage());
		pcomodines=new JPanel();
		//parmas
		
		JPanel pmesa=new JPanel();
		JLabel lmesa=new JLabel();
		
		ImageIcon iconomesa = new ImageIcon(ventana.class.getResource("Imagenes/mesa.png"));		
		lmesa.setSize(800,100);
		Icon iconomesaa = new ImageIcon(iconomesa.getImage().getScaledInstance(lmesa.getWidth()	, lmesa.getHeight(), Image.SCALE_DEFAULT));
		lmesa.setIcon(iconomesaa);
		pmesa.add(lmesa);
		pmesa.setOpaque(false);
		
		
		//crear los iconos 
		ImageIcon iconoarma = new ImageIcon(ventana.class.getResource("Imagenes/iconoarmas.png"));
		ImageIcon iconolugares = new ImageIcon(ventana.class.getResource("Imagenes/iconolugares.png"));		
		ImageIcon iconosospechosos = new ImageIcon(ventana.class.getResource("Imagenes/iconosospechosos.png"));
		ImageIcon iconocomodines = new ImageIcon(ventana.class.getResource("Imagenes/iconocomodines.png"));
		
		//crear ptabbed		
		ptabbed.addTab("", iconoarma, parmas,"");
		ptabbed.setMnemonicAt(0, KeyEvent.VK_1);		
		ptabbed.addTab("", iconolugares, plugares,"");
		ptabbed.setMnemonicAt(1, KeyEvent.VK_2);
		ptabbed.addTab("", iconosospechosos,psospechosos,"");
		ptabbed.setMnemonicAt(2, KeyEvent.VK_3);
		ptabbed.addTab("", iconocomodines, pcomodines,"");
		ptabbed.setMnemonicAt(0, KeyEvent.VK_4);
		//ptabbed.setTabPlacement(JTabbedPane.BOTTOM);
		ptabbed.setBorder(null);
		pprincipal.setLayout(new BorderLayout());
		ImageIcon iconoenviar = new ImageIcon(ventana.class.getResource("Imagenes/BOTONENVIAR.png"));		
		lenviar=new JLabel();
		lenviar.setSize(170,113);
		Icon icono = new ImageIcon(iconoenviar.getImage().getScaledInstance(lenviar.getWidth()	, lenviar.getHeight(), Image.SCALE_DEFAULT));
		lenviar.setIcon(icono);
		//Añadir layout a los paneles
		parmas.setLayout(new BorderLayout());
		
		parmas.add(BorderLayout.SOUTH,pmesa);
		
		pdlugares.setLayout(new BorderLayout());
		pdlugares.setOpaque(false);
		
		pcomodines.setLayout(new BorderLayout());
		pdsospechosos.setLayout(new BorderLayout());	
		pdsospechosos.setOpaque(false);
		
		//Añadir los paneles a sus respectivos paneles
		JLabel hueco=new JLabel();
		JLabel hueco2=new JLabel();
		JLabel hueco3=new JLabel();
		hueco.setSize(new Dimension(300,200));
		ImageIcon vacio = new ImageIcon(ventana.class.getResource("Imagenes/vacio.png"));
		Icon iconovacio = new ImageIcon(vacio.getImage().getScaledInstance(hueco.getWidth()	, hueco.getHeight(), Image.SCALE_DEFAULT));
		hueco.setIcon(iconovacio);
		hueco2.setIcon(iconovacio);
		hueco3.setIcon(iconovacio);
		
	
		
		
		plugares.setLayout(new BorderLayout());	
		plugares.add(pdlugares,BorderLayout.CENTER);
		plugares.add(hueco2,BorderLayout.WEST);
		//plugares.add(hueco,BorderLayout.WEST);
		
		psospechosos.setLayout(new BorderLayout());
		psospechosos.add(pdsospechosos,BorderLayout.CENTER);
		psospechosos.add(hueco3,BorderLayout.WEST);
		//psospechosos.add(hueco,BorderLayout.WEST);
		
		
//		Jugador a=new Jugador();
//		Jugador b=new Jugador();
//		Jugador [] arrjug=new Jugador [2];
//		arrjug[0]=a;
//		arrjug[1]=b;
//		Propiedades prop =new Propiedades(6,8,7,2);
//		prop.repartirCartas(arrjug);
//		meterCartas(a,prop,0,pdarmas);
//		meterCartas(a,prop,1,pdlugares);
//		meterCartas(a,prop,2,pdsospechosos);
//		meterCartas(a,prop,3,pcomodines);
		meterCartas(j,p,0,parmas,base,con,0,hueco,hueco2);
		meterCartas(j,p,1,pdlugares,base,con,1,hueco2,hueco);
		meterCartas(j,p,2,pdsospechosos,base,con,2,hueco3,hueco);
		//meterCartas(j,p,3,pcomodines,base,con,3);		
		pprincipal.add(BorderLayout.SOUTH,lenviar);
		pprincipal.add(BorderLayout.CENTER,ptabbed);
		getContentPane().add(pprincipal);

			}
	public static void meterCartas(Jugador jugador,Partida p,int panel,JPanel pan,GestionBaseDeDatos base,Connection con,int tipo,JLabel hueco,JLabel hueco2){	
			ArrayList<String> cartasdepalo=base.obtenerCartasDeJugador(con, p.getCodigo(), jugador.getCodigo(), tipo);
			int k=0;
			for(int i=0;i<cartasdepalo.size();i++){
				System.out.println(cartasdepalo.get(i));
				String ruta=base.consultaATablaCartas(con,"NOMBRE="+"'"+cartasdepalo.get(i)+"'").get(0).getRutaIcono();
//			for(int j=0;j<jugador.getMisCartas().get(panel).size();j++){				
//			String ruta=p.getBaraja().get(panel).get(jugador.getMisCartas().get(panel).get(j)).getRutaIcono();
			JLabel label=new JLabel();
			System.out.println(ruta);
			ImageIcon iconocarta = new ImageIcon(ventana.class.getResource(ruta));		
			label.setSize(227,283);
			Icon icono = new ImageIcon(iconocarta.getImage().getScaledInstance(label.getWidth()	, label.getHeight(), Image.SCALE_DEFAULT));
			label.setIcon(icono);
			JPanel panelcentrado=new JPanel();
			panelcentrado.add(label);
			if(k==0){
				pan.add(panelcentrado, BorderLayout.CENTER);
			}else if(k==1){
				panelcentrado.setBackground(Color.BLUE);
				JPanel panelnoesquina=new JPanel();
				panelnoesquina.setLayout(new BorderLayout());
				panelnoesquina.add(hueco,BorderLayout.EAST);
				panelnoesquina.add(panelcentrado,BorderLayout.CENTER);
				pan.add(panelnoesquina, BorderLayout.EAST);
				
			}else if(k==2){
				panelcentrado.setBackground(Color.BLUE);
				JPanel panelnoesquina=new JPanel();
				panelnoesquina.setLayout(new BorderLayout());
				panelnoesquina.add(hueco2,BorderLayout.WEST);
				panelnoesquina.add(panelcentrado,BorderLayout.CENTER);
				pan.add(panelnoesquina, BorderLayout.WEST);
			}
			
			k=k+1;
			
			}
			
		
			
	}
	public static void main (String [] args){
		VentanaCartas ventana = new VentanaCartas();
		ventana.setVisible(true);
	}

}
