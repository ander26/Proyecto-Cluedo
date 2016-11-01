package Proyecto.Cluedo.Ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

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

	public VentanaCartas(){
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );		
		setSize( 1330, 730 );	
		
		setMinimumSize(new Dimension(900,500));		
		setResizable( true );
		//Poner fondo a los paneles
		ImageIcon imagearma = new ImageIcon(ventana.class.getResource("Imagenes/cuchillo.jpg"));
		parmas=new panelrosa(imagearma.getImage());
		ImageIcon imagelugares = new ImageIcon(ventana.class.getResource("Imagenes/violencia.png"));
		plugares=new panelrosa(imagelugares.getImage());
		ImageIcon imagesospechosos = new ImageIcon(ventana.class.getResource("Imagenes/asesino.jpg"));
		psospechosos=new panelrosa(imagesospechosos.getImage());
		pcomodines=new JPanel();
		
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
		pdarmas.setLayout(new BoxLayout(pdarmas,BoxLayout.X_AXIS));
		pdarmas.setOpaque(false);
		pdlugares.setLayout(new BoxLayout(pdlugares,BoxLayout.X_AXIS));
		pdlugares.setOpaque(false);
		
		pcomodines.setLayout(new BoxLayout(pcomodines,BoxLayout.X_AXIS));
		pdsospechosos.setLayout(new BoxLayout(pdsospechosos,BoxLayout.X_AXIS));	
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
		parmas.setLayout(new BorderLayout());
		parmas.add(pdarmas,BorderLayout.CENTER);
		parmas.add(hueco,BorderLayout.WEST);
		
		plugares.setLayout(new BorderLayout());	
		plugares.add(pdlugares,BorderLayout.CENTER);
		plugares.add(hueco2,BorderLayout.WEST);
		//plugares.add(hueco,BorderLayout.WEST);
		
		psospechosos.setLayout(new BorderLayout());
		psospechosos.add(pdsospechosos,BorderLayout.CENTER);
		psospechosos.add(hueco3,BorderLayout.WEST);
		//psospechosos.add(hueco,BorderLayout.WEST);
		
		
		Jugador a=new Jugador();
		Jugador b=new Jugador();
		Jugador [] arrjug=new Jugador [2];
		arrjug[0]=a;
		arrjug[1]=b;
		Propiedades prop =new Propiedades(6,8,7,2);
		prop.repartirCartas(arrjug);
		meterCartas(a,prop,0,pdarmas);
		meterCartas(a,prop,1,pdlugares);
		meterCartas(a,prop,2,pdsospechosos);
		meterCartas(a,prop,3,pcomodines);
		
		pprincipal.add(BorderLayout.SOUTH,lenviar);
		pprincipal.add(BorderLayout.CENTER,ptabbed);
		getContentPane().add(pprincipal);

			}
	public static void meterCartas(Jugador jugador,Propiedades p,int panel,JPanel pan){		
			for(int j=0;j<jugador.getMisCartas().get(panel).size();j++){				
			String ruta=p.getBaraja().get(panel).get(jugador.getMisCartas().get(panel).get(j)).getRutaIcono();
			JLabel label=new JLabel();
			System.out.println(ruta);
			ImageIcon iconocarta = new ImageIcon(ventana.class.getResource(ruta));		
			label.setSize(227,283);
			Icon icono = new ImageIcon(iconocarta.getImage().getScaledInstance(label.getWidth()	, label.getHeight(), Image.SCALE_DEFAULT));
			label.setIcon(icono);
			pan.add(label,pan);
			}
			
		
			
	}
	public static void main (String [] args){
		VentanaCartas ventana = new VentanaCartas();
		ventana.setVisible(true);
	}

}
