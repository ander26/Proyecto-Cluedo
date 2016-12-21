package Proyecto.Cluedo.Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Proyecto.Cluedo.Datos.Partida;
import Proyecto.Cluedo.Hilo.HiloTurno;
import Proyecto.Cluedo.Logica.GestionBaseDeDatos;
import Proyecto.Cluedo.Logica.Jugador;
import Proyecto.Cluedo.Logica.Propiedades;


public class VentanaAcusar extends JFrame {
	
	private static Logger logger = Logger.getLogger(GestionBaseDeDatos.class.getName());

//	private static JPanel pcsospechoso=new JPanel();
//	//private static JPanel pclugar=new JPanel();
//	private static JPanel pcarma=new JPanel();
//	private static panelrosa pprincipal;
//	//private static Propiedades prop =new Propiedades(6,8,7,2);
//	private static int [] arposcartas=new int[3];
//	private static JLabel labels=new JLabel();
//	//private static JLabel labell=new JLabel();
//	private static JLabel labela=new JLabel();
//	private static JPanel paneldentropri=new JPanel();
//	private JLabel lbAcusar=new JLabel();
//	private JLabel lbResolver=new JLabel();
//	private JPanel pbotonera=new JPanel();
//	private JPanel pantesbotonera=new JPanel();
//	
//
//	public static void main(String[] args) {
//		
//		// TODO Auto-generated method stub		
//		Jugador a =new Jugador();
//		a.setLugar(2);
//		//mete el fondo del lugar en el que este
//		String [] aimglug=new String [8];
//		aimglug[0]="Imagenes/ingenieria.jpg";
//		aimglug[1]="Imagenes/comercial.jpg";
//		aimglug[2]="Imagenes/capilla.JPG";
//		aimglug[3]="Imagenes/centenario.jpg";
//		aimglug[4]="Imagenes/letras.jpg";
//		aimglug[5]="Imagenes/biblioteca.jpeg";
//		aimglug[6]="Imagenes/zubiarte.jpg";
//		aimglug[7]="Imagenes/zubiarte.jpg";
//																		
//		JFrame f=new VentanaAcusar(aimglug[a.getLugar()]);		
//		f.setVisible(true);
//	}
//	
//
//	public VentanaAcusar(String ruta,Propiedades prop){
//		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );		
//		setSize( 1330, 730 );			
//		setMinimumSize(new Dimension(900,500));		
//		setResizable( true );
//		ImageIcon imagefondo = new ImageIcon(ventana.class.getResource(ruta));
//		pprincipal=new panelrosa(imagefondo.getImage());		
//		pprincipal.setLayout(new BorderLayout());
//		paneldentropri.setLayout(new BoxLayout(paneldentropri,BoxLayout.X_AXIS));
//		//Añadir layout a los paneles de las cartas
//		pcsospechoso.setLayout(new BorderLayout());
//		pcsospechoso.setOpaque(true);
//		pcsospechoso.setBackground(Color.BLUE);
//		
//		//pclugar.setLayout(new BorderLayout());
//		//pclugar.setOpaque(false);
//		pcarma.setLayout(new BorderLayout());
//		pcarma.setOpaque(false);
//		
//		//añadir flechas a los paneles de las cartas		
//		JLabel lflechaizqs=new JLabel();
//		JLabel lflechaizql=new JLabel();
//		JLabel lflechaizqa=new JLabel();
//		JLabel lflechaders=new JLabel();
//		JLabel lflechaderl=new JLabel();
//		JLabel lflechadera=new JLabel();
//		cargarFlecha(lflechaizqs,"Imagenes/flechaizquierda.png",pcsospechoso,0);	
//		//cargarFlecha(lflechaizql,"Imagenes/flechaizquierda.png",pclugar,0);
//		cargarFlecha(lflechaizqa,"Imagenes/flechaizquierda.png",pcarma,0);
//		cargarFlecha(lflechaders,"Imagenes/flechaderecha.png",pcsospechoso,1);
//		//cargarFlecha(lflechaderl,"Imagenes/flechaderecha.png",pclugar,1);
//		cargarFlecha(lflechadera,"Imagenes/flechaderecha.png",pcarma,1);
//		
//		//arreglar panel
//		JLabel hueco=new JLabel();
//		hueco.setSize(new Dimension(80,200));
//		ImageIcon vacio = new ImageIcon(ventana.class.getResource("Imagenes/vacio.png"));
//		Icon iconovacio = new ImageIcon(vacio.getImage().getScaledInstance(hueco.getWidth()	, hueco.getHeight(), Image.SCALE_DEFAULT));
//		hueco.setIcon(iconovacio);
//		JLabel hueco2=new JLabel();
//		hueco2.setSize(new Dimension(80,200));
//		ImageIcon vacio2 = new ImageIcon(ventana.class.getResource("Imagenes/vacio.png"));
//		Icon iconovacio2 = new ImageIcon(vacio2.getImage().getScaledInstance(hueco2.getWidth()	, hueco2.getHeight(), Image.SCALE_DEFAULT));
//		hueco2.setIcon(iconovacio2);
//		paneldentropri.setOpaque(false);
//		//añadir los componenetes
//		
//		paneldentropri.add(pcsospechoso);
//		//paneldentropri.add(pclugar);
//		paneldentropri.add(pcarma);
//		pprincipal.add(paneldentropri,BorderLayout.CENTER);
//		pprincipal.add(hueco,BorderLayout.EAST);
//		pprincipal.add(hueco2,BorderLayout.WEST);
//		getContentPane().add(pprincipal);
//		//meter las cartas
//		meterCartas(prop,2,pcsospechoso,labels);
//		//meterCartas(prop,1,pclugar,labell);
//		meterCartas(prop,0,pcarma,labela);
//		//meter botones
//		ImageIcon iconobacusar = new ImageIcon(ventana.class.getResource("Imagenes/bacusar.png"));		
//		lbAcusar.setSize(200,150);
//		
//		Icon iconoacu = new ImageIcon(iconobacusar.getImage().getScaledInstance(lbAcusar.getWidth()	, lbAcusar.getHeight(), Image.SCALE_DEFAULT));
//		lbAcusar.setIcon(iconoacu);
//		ImageIcon iconobresolver = new ImageIcon(ventana.class.getResource("Imagenes/Bresolver.png"));		
//		lbResolver.setSize(200,150);
//		Icon iconores = new ImageIcon(iconobresolver.getImage().getScaledInstance(lbResolver.getWidth()	, lbResolver.getHeight(), Image.SCALE_DEFAULT));
//		lbResolver.setIcon(iconores);
//		pbotonera.add(lbAcusar);
//		pbotonera.add(lbResolver);
//		pbotonera.setBackground(new Color(213, 134, 145, 123));
//		pantesbotonera.add(pbotonera);
//		//pbotonera.setOpaque(false);
//		pprincipal.add(pantesbotonera,BorderLayout.SOUTH);
//		pantesbotonera.setOpaque(false);
//		
//		
//		//escuchadores
//		lflechaizql.addMouseListener( new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				if(arposcartas[1]<prop.getBaraja().get(1).size() && arposcartas[1]>0){
//				arposcartas[1]=arposcartas[1]-1;
//				//meterCartas(prop,1,pclugar,labell);
//				
//				}else{
//					
//				}
//			}
//		});
//		lflechaderl.addMouseListener( new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				if(arposcartas[1]>-1 && arposcartas[1]<prop.getBaraja().get(1).size()-1){
//					System.out.println(prop.getBaraja().get(2).size());
//				arposcartas[1]=arposcartas[1]+1;
//				//meterCartas(prop,1,pclugar,labell);
//				repaint();
//				}
//				else{
////					arposcartas[1]=prop.getBaraja().get(1).size();
//			
//			}
//			}
//		});
//		lflechaizqa.addMouseListener( new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				if(arposcartas[0]<(prop.getBaraja().get(0).size()) && arposcartas[0]>0){
//				arposcartas[0]=arposcartas[0]-1;
//				meterCartas(prop,0,pcarma,labela);
//				repaint();
//				}else{
//					
//				}
//			}
//		});
//		lflechadera.addMouseListener( new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				if(arposcartas[0]>-1 && arposcartas[0]<(prop.getBaraja().get(0).size()-1)){
//				arposcartas[0]=arposcartas[0]+1;
//				meterCartas(prop,0,pcarma,labela);
//				getContentPane().repaint();
//				repaint();
//				}
//				else{
//					
//				}
//			}
//		});
//		lflechaizqs.addMouseListener( new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				if(arposcartas[2]<(prop.getBaraja().get(2).size()) && arposcartas[2]>0){
//				System.out.println(prop.getBaraja().get(2).size());
//				arposcartas[2]=arposcartas[2]-1;
//				meterCartas(prop,2,pcsospechoso,labels);
//				getContentPane().repaint();
//				}
//				else{
////					
//				}
//			}
//		});
//		lflechaders.addMouseListener( new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				if(arposcartas[2]>-1 && arposcartas[2]<(prop.getBaraja().get(2).size()-1)){
//				System.out.println(prop.getBaraja().get(2).size());
//				arposcartas[2]=arposcartas[2]+1;
//				meterCartas(prop,2,pcsospechoso,labels);
//				
//				repaint();
//				}
//				else{
//					
//				}
//				
//			}
//		});
//		
//		
//		
//	}
//	public static void meterCartas(Propiedades p,int panel,JPanel pan,JLabel label){	
//		String ruta=p.getBaraja().get(panel).get(arposcartas[panel]).getRutaIcono();		
//		System.out.println(ruta);
//		ImageIcon iconocarta = new ImageIcon(ventana.class.getResource(ruta));		
//		label.setSize(227,283);
//		Icon icono = new ImageIcon(iconocarta.getImage().getScaledInstance(label.getWidth()	, label.getHeight(), Image.SCALE_DEFAULT));
//		label.setIcon(icono);
//		
//		pan.setOpaque(true);
//		label.setHorizontalAlignment(0);
//		pan.add(label,BorderLayout.CENTER);
//		label.repaint();
//		pan.repaint();
//				
//		
//	}
//	public static void cargarFlecha(JLabel lflecha,String ruta,JPanel panel,int num){		
//		lflecha.setSize(new Dimension(80,80));
//		System.out.println(ruta);
//		ImageIcon iilflecha = new ImageIcon(VentanaAcusar.class.getResource(ruta));
//		Icon iconovacios = new ImageIcon(iilflecha.getImage().getScaledInstance(lflecha.getWidth()	, lflecha.getHeight(), Image.SCALE_DEFAULT));
//		lflecha.setIcon(iconovacios);
//		if(num==0){
//		panel.add(lflecha,BorderLayout.WEST);	
//		}else{
//			panel.add(lflecha,BorderLayout.EAST);	
//			
//		}
//		
//		
//	}
//	
	public JPanel pprincipal=new JPanel();
	public JTabbedPane ptabbed=new JTabbedPane(JTabbedPane.LEFT);
	public sospechoso psospechoso=new sospechoso();
	public armas parmas=new armas();
	public JPanel pbotonera=new JPanel();
	public JLabel lbAcusar=new JLabel();
	public JLabel lbResolver=new JLabel();
	public String [] acusacion=new String[3];
	
	public VentanaAcusar(GestionBaseDeDatos base,Connection con,Jugador j,Partida p){
		setSize( 1330, 730 );
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );	
		//crear los iconos 
		ImageIcon iconoarma = new ImageIcon(ventana.class.getResource("Imagenes/iconoarmas.png"));
		ImageIcon iconosospechosos = new ImageIcon(ventana.class.getResource("Imagenes/iconosospechosos.png"));
		//hacer tabbedpane
		ptabbed.addTab("", iconoarma, parmas,"");
		ptabbed.setMnemonicAt(0, KeyEvent.VK_1);		
		ptabbed.addTab("", iconosospechosos,psospechoso,"");
		ptabbed.setMnemonicAt(1, KeyEvent.VK_3);
		ptabbed.setForeground(new Color(1f,0f,0f,1f));
		ptabbed.setBackground(Color.magenta);
		ptabbed.setBorder(null);
		pprincipal.setBackground(Color.GRAY);
		//ventana
		pbotonera.setOpaque(false);
		
//=======
//	private static JPanel pcsospechoso=new JPanel();
//	//private static JPanel pclugar=new JPanel();
//	private static JPanel pcarma=new JPanel();
//	private static panelrosa pprincipal;
//	//private static Propiedades prop =new Propiedades(6,8,7,2);
//	private static int [] arposcartas=new int[3];
//	private static JLabel labels=new JLabel();
//	//private static JLabel labell=new JLabel();
//	private static JLabel labela=new JLabel();
//	private static JPanel paneldentropri=new JPanel();
//	private JLabel lbAcusar=new JLabel();
//	private JLabel lbResolver=new JLabel();
//	private JPanel pbotonera=new JPanel();
//	private JPanel pantesbotonera=new JPanel();
//	
//
////	public static void main(String[] args) {
////		
////		// TODO Auto-generated method stub		
////		Jugador a =new Jugador();
////		a.setLugar(2);
////		//mete el fondo del lugar en el que este
////		String [] aimglug=new String [8];
////		aimglug[0]="Imagenes/ingenieria.jpg";
////		aimglug[1]="Imagenes/comercial.jpg";
////		aimglug[2]="Imagenes/capilla.JPG";
////		aimglug[3]="Imagenes/centenario.jpg";
////		aimglug[4]="Imagenes/letras.jpg";
////		aimglug[5]="Imagenes/biblioteca.jpeg";
////		aimglug[6]="Imagenes/zubiarte.jpg";
////		aimglug[7]="Imagenes/zubiarte.jpg";
////																		
////		JFrame f=new VentanaAcusar(aimglug[a.getLugar()]);		
////		f.setVisible(true);
////	}
//	
//
//	public VentanaAcusar(String ruta,Propiedades prop){
//		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );		
//		setSize( 1330, 730 );			
//		setMinimumSize(new Dimension(900,500));		
//		setResizable( true );
//		ImageIcon imagefondo = new ImageIcon(ventana.class.getResource(ruta));
//		pprincipal=new panelrosa(imagefondo.getImage());		
//>>>>>>> refs/remotes/origin/master
		pprincipal.setLayout(new BorderLayout());
		pprincipal.add(ptabbed,BorderLayout.CENTER);
		ImageIcon iconobacusar = new ImageIcon(ventana.class.getResource("Imagenes/bacusar.png"));		
		lbAcusar.setSize(200,150);		
		Icon iconoacu = new ImageIcon(iconobacusar.getImage().getScaledInstance(lbAcusar.getWidth()	, lbAcusar.getHeight(), Image.SCALE_DEFAULT));
		lbAcusar.setIcon(iconoacu);
		ImageIcon iconobresolver = new ImageIcon(ventana.class.getResource("Imagenes/Bresolver.png"));		
		lbResolver.setSize(200,150);
		Icon iconores = new ImageIcon(iconobresolver.getImage().getScaledInstance(lbResolver.getWidth()	, lbResolver.getHeight(), Image.SCALE_DEFAULT));
		lbResolver.setIcon(iconores);
		pbotonera.setLayout(new BoxLayout(pbotonera,BoxLayout.Y_AXIS));
		pbotonera.add(lbAcusar);
		pbotonera.add(lbResolver);
		pprincipal.add(pbotonera,BorderLayout.WEST);
		getContentPane().add(pprincipal);
		lbAcusar.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				//acusacion[0]=base.lugarAcusacion(con, j); para hacer pruebas
				acusacion[0]="F. Ingenieria";
				acusacion[2]=psospechoso.getSospechoso();
				acusacion[1]=parmas.getArma();
				SubirAbaseAcusacion(j,p,con);
				base.modificarPanel(con, "<html><body>El jugador "+j.getUsuario()+"<br> piensa que <br>"+acusacion[2]+"cometio el crimen <br> en"+acusacion[0]+"con  <br> el"+acusacion[1], p);
				
				
				
			}
	});
		
	}
	public void SubirAbaseAcusacion(Jugador j,Partida p,Connection conexion){
			
		
		try {
			Statement statement = conexion.createStatement();
			String sql = "INSERT INTO SOSPECHA VALUES ('" +acusacion[0] + "','" + acusacion[1] + "','" +acusacion[2]+"',"+j.getCodigo()+","+
					 p.getCodigo() + ","+System.currentTimeMillis()+ ")";

			statement.executeUpdate(sql);

			logger.log(Level.INFO, "Se ha añadido la sospecha: " + sql);

			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

//	public static void main(String[] args) {
//	
//	// TODO Auto-generated method stub		
//	
//	
//																	
//	JFrame f=new VentanaAcusar();		
//	f.setVisible(true);
//}
	}
	
	



