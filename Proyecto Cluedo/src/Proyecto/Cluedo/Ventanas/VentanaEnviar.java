package Proyecto.Cluedo.Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaEnviar extends JFrame {
	private static JPanel pcsospechoso=new JPanel();
	//private static JPanel pclugar=new JPanel();
	private static JPanel pcarma=new JPanel();
	private static panelrosa pprincipal;
	//private static Propiedades prop =new Propiedades(6,8,7,2);
	private static int [] arposcartas=new int[3];
	private static JLabel labels=new JLabel();
	//private static JLabel labell=new JLabel();
	private static JLabel labela=new JLabel();
	private static JPanel paneldentropri=new JPanel();
	private JLabel lbAcusar=new JLabel();
	private JLabel lbResolver=new JLabel();
	private JPanel pbotonera=new JPanel();
	private JPanel pantesbotonera=new JPanel();
	

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
																		
		JFrame f=new VentanaAcusar(aimglug[a.getLugar()]);		
		f.setVisible(true);
	}
	

	public VentanaEnviar(){
		
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );		
		setSize( 1330, 730 );			
		setMinimumSize(new Dimension(900,500));		
		setResizable( true );
		ImageIcon imagefondo = new ImageIcon(ventana.class.getResource("Imagenes/baul-abierto.jpg"));
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
		
		paneldentropri.add(pcsospechoso);
		//paneldentropri.add(pclugar);
		paneldentropri.add(pcarma);
		pprincipal.add(paneldentropri,BorderLayout.CENTER);
		pprincipal.add(hueco,BorderLayout.EAST);
		pprincipal.add(hueco2,BorderLayout.WEST);
		getContentPane().add(pprincipal);
		//meter las cartas
		meterCartas(prop,2,pcsospechoso,labels);
		//meterCartas(prop,1,pclugar,labell);
		meterCartas(prop,0,pcarma,labela);
		//meter botones
		
		
		
		
		
		
		
		
		
		
	}
	public static void meterCartas(int panel){
		ImageIcon imagefondo = new ImageIcon(ventana.class.getResource("Imagenes/baul-abierto.jpg"));
		
		panelrosa pan=new panelrosa();
		pan.setLayout(new BorderLayout());
		pan.setOpaque(false);
		//coger de la base las cartas
		//String ruta=p.getBaraja().get(panel).get(arposcartas[panel]).getRutaIcono();		
		//System.out.println(ruta);
		//ImageIcon iconocarta = new ImageIcon(ventana.class.getResource(ruta));		
		//label.setSize(227,283);
		//Icon icono = new ImageIcon(iconocarta.getImage().getScaledInstance(label.getWidth()	, label.getHeight(), Image.SCALE_DEFAULT));
		//label.setIcon(icono);
		
		JLabel label=new JLabel();
		label.setHorizontalAlignment(0);
		pan.add(label,BorderLayout.CENTER);
		paneldentropri.add(pan);
		label.repaint();
		pan.repaint();
				
		
	}
	
	

}
